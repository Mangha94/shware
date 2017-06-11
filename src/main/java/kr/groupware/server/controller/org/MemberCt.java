package kr.groupware.server.controller.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

import kr.groupware.model.Paging;
import kr.groupware.model.PagingList;
import kr.groupware.model.member.MemberData;
import kr.groupware.model.member.MemberSearchData;
import kr.groupware.model.member.MemberSv;
import kr.groupware.model.rank.department.DepartmentData;
import kr.groupware.model.rank.department.DepartmentSv;
import kr.groupware.model.rank.position.PositionData;
import kr.groupware.model.rank.position.PositionSv;
import kr.groupware.model.rank.spot.SpotData;
import kr.groupware.model.rank.spot.SpotSv;

@Controller
@RequestMapping(value = "/org/member")
public class MemberCt {
    @Autowired
    private
    MemberSv memberSv;
    @Autowired
    private
    SpotSv spotSv;
    @Autowired
    private
    PositionSv positionSv;
    @Autowired
    private
    DepartmentSv departmentSv;

	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public ModelAndView searchMember(
		@RequestParam(value = "searchFrom", required = false, defaultValue = "") String searchFrom,
		@RequestParam(value = "searchVal", required = false, defaultValue = "") String searchVal,
		@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
		@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
	) {
		ModelAndView mv = new ModelAndView("/org/member/memberList");

		MemberSearchData searchData = new MemberSearchData();
		if (searchFrom.equals("memberId")) {
			searchData.setMemberId(searchVal);
		} else if (searchFrom.equals("name")) {
			searchData.setName(searchVal);
		} else if (searchFrom.equals("email")) {
			searchData.setEmail(searchVal);
		}

		Paging paging = new Paging (pageNo, 10, pageSize);

		PagingList<MemberData> pagingList = memberSv.searchMember (paging, searchData);

		mv.addObject ("paging", pagingList.getPaging ());
		mv.addObject ("pagingList", pagingList);

		mv.addObject("searchForm",searchFrom);
		mv.addObject("searchVal",searchVal);

		return mv;
	}

    @RequestMapping(value = "/reloadMember.do", method = RequestMethod.GET)
    public ModelAndView reloadMember(
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        ModelAndView mv = new ModelAndView("org/member/memberList");

        List<MemberData> reloadMember = memberSv.setMemberPage(pageNo, pageSize);

        mv.addObject("pageNo",pageNo);
        mv.addObject("memberList", reloadMember);
        return mv;
    }

    @RequestMapping(value = "/idCheckForm.do", method = {RequestMethod.GET})
    public ModelAndView idCheckForm(
            @RequestParam(value = "memberId", required = false) String memberId
    ) {
        ModelAndView mv = new ModelAndView("pageJsonReport");

        mv.addObject("success", !memberSv.existMemberId(memberId));

        return mv;
    }

    @RequestMapping(value = "/getMember.do", method = RequestMethod.GET)
    public ModelAndView getMember(
            @RequestParam(value = "memberId", required = false) String memberId
    ) {
        MemberData memberData = memberSv.getMember(memberId);
        ModelAndView mv = new ModelAndView("org/member/modifyMember");
        List<SpotData> spots = spotSv.getSpots();
        List<PositionData> positions = positionSv.getPositions();
        List<DepartmentData> departments = departmentSv.getDepartments();
        mv.addObject("getSpots", spots);
        mv.addObject("getPositions", positions);
        mv.addObject("getDepartments", departments);
        mv.addObject("getMember", memberData);
        return mv;
    }

    @RequestMapping(value = "/addMember.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addMember(
            MemberData memberData
    )
	{
        ModelAndView mv = new ModelAndView("pageJsonReport");

        try
		{
            memberSv.addMember(memberData);

			mv.addObject("success", true);
        }
        catch (Exception e)
		{
            e.printStackTrace();

			mv.addObject("success", false);
        }

        return mv;
    }

    @RequestMapping(value = "/modifyMember.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String modifyMember(
            @RequestParam(value = "memberId", required = false) String memberId,
            @RequestParam(value = "pw", required = false) String pw,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "positionNo", required = false) int positionNo,
            @RequestParam(value = "spotNo", required = false) int spotNo,
            @RequestParam(value = "departmentNo", required = false) int departmentNo,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "entryDate", required = false) Date entryDate,
            @RequestParam(value = "used", required = false) Boolean used,
            @RequestParam(value = "securityRating", required = false) int securityRating,
            @RequestParam(value = "businessNo", required = false) String businessNo
    ) {
        MemberData memberData = memberSv.getMember(memberId);
        memberSv.modifyMember(memberData);
        return "redirect:/org/member/memberList.do";
    }

    @RequestMapping(value = "/deleteMember.do", method = RequestMethod.GET)
    public String deleteMember(
            @RequestParam(value = "memberId", required = false) String memberId
    ) {
        memberSv.deleteMember(memberId);
        return "redirect:/org/member/memberList.do";
    }



    @RequestMapping(value = "/addMemberForm.do", method = RequestMethod.GET)
    public ModelAndView addMemberForm() {
        ModelAndView mv = new ModelAndView("/org/member/addMember");
        List<SpotData> spots = spotSv.getSpots();
        List<PositionData> positions = positionSv.getPositions();
        List<DepartmentData> departments = departmentSv.getDepartments();
        mv.addObject("getSpots", spots);
        mv.addObject("getPositions", positions);
        mv.addObject("getDepartments", departments);
        return mv;
    }

    public void setPaging(int pageNo,int pageSize){

    }

}
