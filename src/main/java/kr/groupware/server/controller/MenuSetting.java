package kr.groupware.server.controller;

import kr.groupware.model.system.board.BoardSettingData;
import kr.groupware.model.system.board.BoardSettingSv;
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
    BoardSettingSv boardSettingSv;
    @Autowired
    private
    DefaultSystemSettingSv defaultSystemSettingSv;

    public void menuSetting(ModelAndView mv){
        List<BoardSettingData> boardSettings= boardSettingSv.getBoardSettings();
        mv.addObject("boardSettings",boardSettings);

        List<DefaultSystemSettingData>defaultSystemSetting=defaultSystemSettingSv.getDefaultSystemSettings();
        mv.addObject("defaultSystemSetting",defaultSystemSetting);
    }
}
