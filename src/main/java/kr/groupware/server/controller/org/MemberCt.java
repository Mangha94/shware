package kr.groupware.server.controller.org;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.groupware.model.memo.MemoData;
import kr.groupware.model.memo.MemoSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.groupware.lib.StrLib;
import kr.groupware.model.Paging;
import kr.groupware.model.PagingList;
import kr.groupware.model.member.MemberData;
import kr.groupware.model.member.MemberSearchData;
import kr.groupware.model.member.MemberSv;
import kr.groupware.model.member.ModifyMemberData;
import kr.groupware.model.member.exception.MemberAddException;
import kr.groupware.model.rank.department.DepartmentData;
import kr.groupware.model.rank.department.DepartmentSv;
import kr.groupware.model.rank.position.PositionData;
import kr.groupware.model.rank.position.PositionSv;
import kr.groupware.model.rank.spot.SpotData;
import kr.groupware.model.rank.spot.SpotSv;
import kr.groupware.server.controller.MenuSetting;

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
    private
    MenuSetting menuSetting;
    @Autowired
    private
    MemoSv memoSv;

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
            Paging paging = new Paging(pageNo, 10, pageSize);

            PagingList<MemberData> pagingList = memberSv.searchMember(paging, searchData);

            mv.addObject("paging", pagingList.getPaging());
            mv.addObject("pagingList", pagingList);
            mv.addObject("orderVal", orderVal);
            mv.addObject("orderAsc", orderAsc);



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
        ModifyMemberData modifyMemberData
    ) {
        memberSv.modifyMember(modifyMemberData);

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

    @RequestMapping(value = "/simplyModify.do",method = {RequestMethod.POST})
    public String simplyModify(
            @RequestParam("datas") String datas
    ) {
        ObjectMapper om = new ObjectMapper ();

        String [] datas2 = datas.split ("###");

        for (String data : datas2)
        {
            System.out.println (data);

            try
            {
                System.out.println (URLDecoder.decode (data, "UTF-8"));

                ModifyMemberData modifyMemberData = om.readValue (URLDecoder.decode (data, "UTF-8"), ModifyMemberData.class);

                memberSv.modifyMember(modifyMemberData);
            }
            catch (IOException e)
            {
                e.printStackTrace ();
            }
        }

        return "redirect:/org/member/memberList.do";
    }

//        @RequestParam(value = "chkMember") String [] chkMember,
//		HttpServletRequest request
//    ){
//        Arrays.stream (chkMember).forEach ((memberID) -> {
//
//        	ModifyMemberData modifyMemberData = new ModifyMemberData ();
//
//			modifyMemberData.setMemberId (memberID);
//			modifyMemberData.setUsed ("true".equals (request.getParameter ("used_" + memberID)));
//			modifyMemberData.setSecurityRating(Integer.parseInt(request.getParameter("securityRating_"+memberID)));
//
//			memberSv.modifyMember (modifyMemberData);
//		});
//
//        return "redirect: /org/member/memberList.do";
//    }

    @RequestMapping(value = "simplyDelete.do",method = RequestMethod.GET)
    public String simplyDelete(
            @RequestParam("datas") String datas
    ) {
        ObjectMapper om = new ObjectMapper ();

        String [] datas2 = datas.split ("###");

        for (String data : datas2)
        {
            System.out.println (data);

            try
            {
                System.out.println (URLDecoder.decode (data, "UTF-8"));

                ModifyMemberData modifyMemberData = om.readValue (URLDecoder.decode (data, "UTF-8"), ModifyMemberData.class);

                memberSv.deleteMember(modifyMemberData.getMemberId());
            }
            catch (IOException e)
            {
                e.printStackTrace ();
            }
        }

        return "redirect:/org/member/memberList.do";
    }

    @RequestMapping(value = "getMemoList.do",method = RequestMethod.GET)
    public ModelAndView getMemoList(
            @RequestParam(value = "memberId",required = false)String memberId
    ){
        List<MemoData> memoList=memoSv.getMemo(memberId);

        ModelAndView mv=new ModelAndView("/org/member/memberList");

        mv.addObject("memoList",memoList);
        return mv;
    }

    @RequestMapping(value="insertMemo.do",method = RequestMethod.POST)
    public ModelAndView insertMemo(
            MemoData memoData,
            @RequestParam(value = "memberId",required = false)String memberId
    ){
        ModelAndView mv=new ModelAndView("pageJsonReport");

        memoData.setMemberId(memberId);

        if(memoSv.insertMemo(memoData)){
            mv.addObject("success",true);
        }
        else
            mv.addObject("success",false);

        return mv;
    }
}
