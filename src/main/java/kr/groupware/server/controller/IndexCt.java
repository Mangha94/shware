package kr.groupware.server.controller;

import kr.groupware.model.system.bord.BordSettingData;
import kr.groupware.model.system.bord.BordSettingSv;
import kr.groupware.model.system.defaultSystem.DefaultSystemSettingData;
import kr.groupware.model.system.defaultSystem.DefaultSystemSettingSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Lsh on 2017-05-21.
 */
@Controller
public class IndexCt {
    @Autowired
    BordSettingSv bordSettingSv;
    @Autowired
    DefaultSystemSettingSv defaultSystemSettingSv;

    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView mv=new ModelAndView("index");
        List<BordSettingData>getBordNames=bordSettingSv.getBordSettings();
        mv.addObject("BordName",getBordNames);

        List<DefaultSystemSettingData>getBrowserName=defaultSystemSettingSv.getDefaultSystemSettings();
        mv.addObject("browserTitle",getBrowserName);
        return mv;
    }
}
