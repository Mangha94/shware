package kr.groupware.server.controller.org;

import kr.groupware.lib.StrLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import kr.groupware.model.Paging;
import kr.groupware.model.PagingList;
import kr.groupware.model.member.MemberData;
import kr.groupware.model.member.MemberSearchData;
import kr.groupware.model.member.MemberSv;
import kr.groupware.model.member.exception.MemberAddException;
import kr.groupware.model.rank.department.DepartmentData;
import kr.groupware.model.rank.department.DepartmentSv;
import kr.groupware.model.rank.position.PositionData;
import kr.groupware.model.rank.position.PositionSv;
import kr.groupware.model.rank.spot.SpotData;
import kr.groupware.model.rank.spot.SpotSv;
import kr.groupware.server.controller.MenuSetting;

import javax.servlet.http.HttpSession;

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
    @Autowired
    private MenuSetting menuSetting;

    @RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
    public ModelAndView searchMember(
            @RequestParam(value = "se_name", required = false, defaultValue = "") String se_name,
            @RequestParam(value = "se_memberId", required = false, defaultValue = "") String se_memberId,
            @RequestParam(value = "se_email", required = false, defaultValue = "") String se_email,
            @RequestParam(value = "orderAsc", required = false, defaultValue = "ASC") String orderAsc,
            @RequestParam(value = "orderVal", required = false, defaultValue = "memberId") String orderVal,
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            HttpSession session
    ) {
        ModelAndView mv = new ModelAndView("/org/member/memberList");
        if(1==(int)session.getAttribute("securityRating")) {

            //메뉴셋팅
            menuSetting.menuSetting(mv);


            MemberSearchData searchData = new MemberSearchData();

            if (!StrLib.isEmptyStr(se_name)) {
                searchData.setName(se_name);
            }
            if (!StrLib.isEmptyStr(se_memberId)) {
                searchData.setMemberId(se_memberId);
            }
            if (!StrLib.isEmptyStr(se_email)) {
                searchData.setEmail(se_email);
            }

            mv.addObject("se_name", se_name);
            mv.addObject("se_memberId", se_memberId);
            mv.addObject("se_email", se_email);

            if (orderVal != null && orderAsc != null) {
                searchData.setOrderVal(orderVal);
                searchData.setOrderAsc(orderAsc);
            }

//		if (searchFrom.equals("memberId")) {
//			searchData.setMemberId(searchVal);
//		} else if (searchFrom.equals("name")) {
//			searchData.setName(searchVal);
//		} else if (searchFrom.equals("email")) {
//			searchData.setEmail(searchVal);
//		}


            Paging paging = new Paging(pageNo, 10, pageSize);

            PagingList<MemberData> pagingList = memberSv.searchMember(paging, searchData);

            mv.addObject("paging", pagingList.getPaging());
            mv.addObject("pagingList", pagingList);
            mv.addObject("orderVal", orderVal);
            mv.addObject("orderAsc", orderAsc);



        }
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
        Optional<MemberData> member = memberSv.getMember(memberId);
        ModelAndView mv = new ModelAndView("org/member/modifyMember");

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        List<SpotData> spots = spotSv.getSpots();
        List<PositionData> positions = positionSv.getPositions();
        List<DepartmentData> departments = departmentSv.getDepartments();
        mv.addObject("getSpots", spots);
        mv.addObject("getPositions", positions);
        mv.addObject("getDepartments", departments);
        mv.addObject("getMember", member.get());
        return mv;
    }

    @RequestMapping(value = "memberDetail.do",method = RequestMethod.GET)
    public ModelAndView memberDetail(
            @RequestParam(value = "memberId",required = false)String memberId
    ){
        Optional<MemberData> member = memberSv.getMember(memberId);
        ModelAndView mv=new ModelAndView("org/member/memberDetail");
        menuSetting.menuSetting(mv);

        List<SpotData> spots = spotSv.getSpots();
        List<PositionData> positions = positionSv.getPositions();
        List<DepartmentData> departments = departmentSv.getDepartments();
        mv.addObject("getSpots", spots);
        mv.addObject("getPositions", positions);
        mv.addObject("getDepartments", departments);
        mv.addObject("member", member.get());
        return mv;
    }

    @RequestMapping(value = "/addMember.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addMember(
            MemberData memberData
    ) {
        ModelAndView mv = new ModelAndView("pageJsonReport");

        try {
            memberSv.addMember(memberData);

            mv.addObject("success", true);
        } catch (MemberAddException e) {
            e.printStackTrace();

            mv.addObject("success", false);

            if (e.getExceptionType() == MemberAddException.MemberAddExceptionType.ID_NOT_INPUT)
                mv.addObject("message", "아이디를 입력해주세요");
            else if (e.getExceptionType() == MemberAddException.MemberAddExceptionType.NAME_NOT_INPUT)
                mv.addObject("message", "이름을 입력해주세요");
            else if (e.getExceptionType() == MemberAddException.MemberAddExceptionType.EXIST_MEMBER)
                mv.addObject("message", "아이디가 존재합니다");
        }

        return mv;
    }

    @RequestMapping(value = "/modifyMember.do", method = RequestMethod.POST)
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

        Optional<MemberData> member = memberSv.getMember(memberId);

        member.ifPresent((memberData) -> {
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
        });

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

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        List<SpotData> spots = spotSv.getSpots();
        List<PositionData> positions = positionSv.getPositions();
        List<DepartmentData> departments = departmentSv.getDepartments();
        mv.addObject("getSpots", spots);
        mv.addObject("getPositions", positions);
        mv.addObject("getDepartments", departments);
        return mv;
    }

    @RequestMapping(value = "simplyModify.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String simplyModify(
            MemberData memberData
    ){
        memberSv.modifyMember(memberData);
        return "redirect: /org/member/memberList.do";
    }

    @RequestMapping(value = "simplyDelete.do",method = RequestMethod.GET)
    public String simplyDelete(
            @RequestParam(value = "memberId",required = false)String memberId
    ){
        String[]memberIdArr=memberId.split(",");
        for(String member : memberIdArr){
            memberSv.deleteMember(member);
        }
        return "redirect: /org/member/memberList.do";
    }
}
