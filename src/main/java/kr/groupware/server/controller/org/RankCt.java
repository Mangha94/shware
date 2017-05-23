package kr.groupware.server.controller.org;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Lsh on 2017-05-23.
 */
@Controller
@RequestMapping(value = "/org/rank/")
public class RankCt {
    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView mv=new ModelAndView("org/rank/list");
        String s="작동됨";
        mv.addObject("test",s);

        return mv;
    }
}
