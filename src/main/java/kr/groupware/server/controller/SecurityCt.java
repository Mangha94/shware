package kr.groupware.server.controller;

import kr.groupware.model.member.MemberSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class SecurityCt {
    @Autowired
    private MemberSv memberSv;


    public ModelAndView memberSecurityCt(HttpSession session){
        ModelAndView mv = new ModelAndView("pageJsonReport");
        if(1==(int)session.getAttribute("securityRating")){
            mv.addObject("success", true);
        }
        else
            mv.addObject("success",false);

        return mv;
    }
}
