package kr.groupware.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Lsh on 2017-05-21.
 */
@Controller
public class IndexCt {
    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView mv=new ModelAndView("index");
        String s="작동됨";
        mv.addObject("test",s);

        return mv;
    }
}
