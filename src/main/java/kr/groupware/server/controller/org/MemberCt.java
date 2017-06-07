package kr.groupware.server.controller.org;

import kr.groupware.model.Paging;
import kr.groupware.model.SetPagingData;
import kr.groupware.model.member.MemberData;
import kr.groupware.model.member.MemberSearchData;
import kr.groupware.model.member.MemberSv;
import kr.groupware.model.rank.department.DepartmentData;
import kr.groupware.model.rank.department.DepartmentSv;
import kr.groupware.model.rank.position.PositionData;
import kr.groupware.model.rank.position.PositionSv;
import kr.groupware.model.rank.spot.SpotData;
import kr.groupware.model.rank.spot.SpotSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/org/member")
public class MemberCt {
    @Autowired
    MemberSv memberSv;
    @Autowired
    SpotSv spotSv;
    @Autowired
    PositionSv positionSv;
    @Autowired
    DepartmentSv departmentSv;

    @RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
    public ModelAndView getMembers(
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        ModelAndView mv = new ModelAndView("org/member/memberList");
        List<MemberData> memberList = memberSv.getMembers();

        int totalCount = memberSv.getCount();
        Paging paging = new Paging();
        paging.setPageNo(pageNo);
        paging.setPageSize(pageSize);
        paging.setTotalCount(totalCount);

        mv.addObject("memberList", memberList);
        mv.addObject("firstPageNo", paging.getFirstPageNo());
        mv.addObject("prevPageNo", paging.getPrevPageNo());
        mv.addObject("startPageNo", paging.getStartPageNo());
        mv.addObject("currentPageNo", paging.getPageNo());
        mv.addObject("endPageNo", paging.getEndPageNo());
        mv.addObject("nextPageNo", paging.getNextPageNo());
        mv.addObject("finalPageNo", paging.getFinalPageNo());
        mv.addObject("pageNo",pageNo);
        return mv;
    }

    @RequestMapping(value = "/reloadMember.do", method = RequestMethod.GET)
    public ModelAndView reloadMember(
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        ModelAndView mv = new ModelAndView("org/member/reloadMember");

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
    public String addMember(
            MemberData memberData
    ) {
        memberSv.addMember(memberData);
        return "redirect:/org/member/memberList.do";
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
        memberData.setPw(pw);
        memberData.setName(name);
        memberData.setPositionNo(positionNo);
        memberData.setSpotNo(spotNo);
        memberData.setDepartmentNo(departmentNo);
        memberData.setEmail(email);
        memberData.setEntryDate(entryDate);
        memberData.setUsed(used);
        memberData.setSecurityRating(securityRating);
        memberData.setBusinessNo(businessNo);
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

    @RequestMapping(value = "/searchMember.do", method = RequestMethod.GET)
    public ModelAndView searchMember(
            @RequestParam(value = "searchFrom", required = false, defaultValue = "") String searchFrom,
            @RequestParam(value = "searchVal", required = false, defaultValue = "") String searchVal
    ) {
        MemberSearchData msd = new MemberSearchData();
        if (searchFrom.equals("memberId")) {
            msd.setMemberId(searchVal);
        } else if (searchFrom.equals("name")) {
            msd.setName(searchVal);
        } else if (searchFrom.equals("email")) {
            msd.setEmail(searchVal);
        }
        List<MemberData> searchList = memberSv.searchMember(msd);
        ModelAndView mv = new ModelAndView("/org/member/memberList");
        mv.addObject("memberList", searchList);
        return mv;
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


}
