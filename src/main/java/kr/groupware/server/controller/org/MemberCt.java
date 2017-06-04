package kr.groupware.server.controller.org;

import kr.groupware.model.member.MemberData;
import kr.groupware.model.member.MemberPageData;
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

import java.lang.reflect.Member;
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

    @RequestMapping(value = "/memberList.do",method = RequestMethod.GET)
    public ModelAndView getMembers(
    ){

        List<MemberData> memberList=memberSv.getMembers();
        ModelAndView mv=new ModelAndView("org/member/memberList");
        mv.addObject("memberList",memberList);
        return mv;
    }

    @RequestMapping(value = "/reloadMember.do",method = RequestMethod.GET)
    public ModelAndView reloadMember(){
        List<MemberData> reloadMember=memberSv.getMembers();
        ModelAndView mv=new ModelAndView("org/member/reloadMember");
        mv.addObject("memberList",reloadMember);
        return mv;
    }

    @RequestMapping(value = "/memberList.do",method = RequestMethod.GET)
    public ModelAndView setMemberPage(
            @RequestParam(value = "page",required = false)int page,
            @RequestParam(value = "countList",required = false)int countList
    ){
        //한페이지에 출력될 페이지수
        int countPage = 5;

        int totalCount = memberSv.getCount();

        int totalPage = totalCount / countList;

        if (totalCount % countList > 0) {
            totalPage++;
        }

        if (totalPage < page) {
            page = totalPage;
        }

        int startPage = ((page - 1) / 10) * 10 + 1;

        int endPage = startPage + countPage - 1;

        if (endPage > totalPage) {
            endPage = totalPage;
        }

        if (startPage > 1) {
            page=1;
        }

        if (page > 1) {
            page=page - 1;
        }

        ModelAndView mv=new ModelAndView("org/member/reloadMember");
        MemberPageData memberPageData=new MemberPageData();
        memberPageData.setPage(page);
        memberPageData.setCountList(countList);
        List<MemberData> setMemberPage=memberSv.setMemberPage(memberPageData);
        mv.addObject("setMemberList",setMemberPage);
        mv.addObject("totalPage",totalPage);
        mv.addObject("startPage",startPage);
        mv.addObject("endPage",endPage);
        return mv;
    }

    @RequestMapping(value = "/idCheckForm.do",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView idCheckForm(
            @RequestParam(value = "memberId",required = false)String memberId
    ){
        System.out.println(memberId);
        MemberSearchData msd=new MemberSearchData();
        msd.setMemberId(memberId);
      if(memberSv.searchMember(msd).size()==0){
          ModelAndView mv=new ModelAndView("/org/member/addMember");
          mv.addObject("newMemberId",memberId);
          return mv;
      }
      else
          return new ModelAndView("redirect:/org/member/addMember.do");
    }

    @RequestMapping(value = "/getMember.do",method = RequestMethod.GET)
    public ModelAndView getMember(
            @RequestParam(value = "memberId",required = false)String memberId
    ){
        MemberData memberData=memberSv.getMember(memberId);
        ModelAndView mv=new ModelAndView("org/member/modifyMember");
        List<SpotData> spots=spotSv.getSpots();
        List<PositionData> positions=positionSv.getPositions();
        List<DepartmentData> departments=departmentSv.getDepartments();
        mv.addObject("getSpots",spots);
        mv.addObject("getPositions",positions);
        mv.addObject("getDepartments",departments);
        mv.addObject("getMember",memberData);
        return mv;
    }

    @RequestMapping(value = "/addMember.do",method = {RequestMethod.GET, RequestMethod.POST})
    public String addMember(
            MemberData memberData
    ){
        memberSv.addMember(memberData);
        return "redirect:/org/member/memberList.do";
    }

    @RequestMapping(value = "/modifyMember.do",method = {RequestMethod.GET, RequestMethod.POST})
    public String modifyMember(
            @RequestParam(value = "memberId",required = false)String memberId,
            @RequestParam(value = "pw",required = false)String pw,
            @RequestParam(value = "name",required = false)String name,
            @RequestParam(value = "positionNo",required = false)int positionNo,
            @RequestParam(value = "spotNo",required = false)int spotNo,
            @RequestParam(value = "departmentNo",required = false)int departmentNo,
            @RequestParam(value = "email",required = false)String email,
            @RequestParam(value = "entryDate",required = false)Date entryDate,
            @RequestParam(value = "used",required = false)Boolean used,
            @RequestParam(value = "securityRating",required = false)int securityRating,
            @RequestParam(value = "businessNo",required = false)String businessNo
    ){
        MemberData memberData=memberSv.getMember(memberId);
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

    @RequestMapping(value="/deleteMember.do",method = RequestMethod.GET)
    public String deleteMember(
            @RequestParam(value = "memberId",required = false)String memberId
    ){
        memberSv.deleteMember(memberId);
        return "redirect:/org/member/memberList.do";
    }

    @RequestMapping(value = "/searchMember.do",method = RequestMethod.GET)
    public ModelAndView searchMember(
            @RequestParam(value = "searchFrom",required = false, defaultValue = "")String searchFrom,
            @RequestParam(value = "searchVal",required = false, defaultValue = "")String searchVal
    ){
        MemberSearchData msd=new MemberSearchData();
        if(searchFrom.equals("memberId")){
            msd.setMemberId(searchVal);
        }else if(searchFrom.equals("name")){
            msd.setName(searchVal);
        }else if(searchFrom.equals("email")){
            msd.setEmail(searchVal);
        }
        List<MemberData> searchList=memberSv.searchMember(msd);
        System.out.println(searchList);
        ModelAndView mv=new ModelAndView("/org/member/memberList");
        mv.addObject("memberList",searchList);
        return mv;
    }

    @RequestMapping(value = "/addMemberForm.do",method = RequestMethod.GET)
    public ModelAndView addMemberForm(){
        ModelAndView mv=new ModelAndView("/org/member/addMember");
        List<SpotData> spots=spotSv.getSpots();
        List<PositionData> positions=positionSv.getPositions();
        List<DepartmentData> departments=departmentSv.getDepartments();
        mv.addObject("getSpots",spots);
        mv.addObject("getPositions",positions);
        mv.addObject("getDepartments",departments);
        return mv;
    }


}
