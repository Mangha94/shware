package kr.groupware.server.controller;

import kr.groupware.model.system.bord.BordSettingData;
import kr.groupware.model.system.bord.BordSettingSv;
import kr.groupware.model.system.defaultSystem.DefaultSystemSettingData;
import kr.groupware.model.system.defaultSystem.DefaultSystemSettingSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MenuSetting {
    @Autowired
    private
    BordSettingSv bordSettingSv;
    @Autowired
    private
    DefaultSystemSettingSv defaultSystemSettingSv;

    public void menuSetting(ModelAndView mv){
        List<BordSettingData> getBordNames=bordSettingSv.getBordSettings();
        mv.addObject("BordName",getBordNames);

        List<DefaultSystemSettingData>getBrowserName=defaultSystemSettingSv.getDefaultSystemSettings();
        mv.addObject("browserTitle",getBrowserName);
    }
}
