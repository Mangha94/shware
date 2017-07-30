package kr.groupware.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import kr.groupware.model.system.board.BoardSettingData;
import kr.groupware.model.system.board.BoardSettingSv;
import kr.groupware.model.system.defaultSystem.DefaultSystemSettingData;
import kr.groupware.model.system.defaultSystem.DefaultSystemSettingSv;

/**
 * Created by Lsh on 2017-05-21.
 */
@Controller
public class IndexCt {
    @Autowired
    private BoardSettingSv boardSettingSv;
    @Autowired
    private DefaultSystemSettingSv defaultSystemSettingSv;

    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public ModelAndView menuSetting(
    ){
        ModelAndView mv=new ModelAndView("index");

        List<BoardSettingData>boardSettings= boardSettingSv.getBoardSettings();
        mv.addObject("boardSettings",boardSettings);

        List<DefaultSystemSettingData>getBrowserName=defaultSystemSettingSv.getDefaultSystemSettings();
        mv.addObject("browserTitle",getBrowserName);
        return mv;
    }
}
