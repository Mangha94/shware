package kr.groupware.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import kr.groupware.model.member.MemberData;
import kr.groupware.model.member.MemberSv;

@Controller
public class LoginCt {
    @Autowired
    private MemberSv memberSv;

    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public ModelAndView loginPage(){
        ModelAndView mv=new ModelAndView("/loginPage");
        return mv;
    }

    @RequestMapping(value = "/login.do",method = {RequestMethod.POST})
    public ModelAndView login(
            HttpSession session,
            @RequestParam(value = "memberId",required = false) String memberId,
            @RequestParam(value = "pw",required = false) String pw
            ){
        ModelAndView mv = new ModelAndView("pageJsonReport");
        System.out.println(memberId);
        System.out.println(pw);
        Optional<MemberData> memberData=memberSv.getMember(memberId);

        if(memberData.isPresent()){
            if(memberData.get().getPw().equals(pw)){

                session.setAttribute("memberId",memberId);
                mv.addObject("success", true);
            }
        }
        else
            mv.addObject("success", false);

        return mv;
    }

    @RequestMapping(value = "/logout.do",method = RequestMethod.GET)
    public String logout(HttpSession session){

        session.setAttribute("memberId","");
        session.invalidate();

        return "redirect:/login.do";
    }
}