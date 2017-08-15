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

import javax.servlet.http.HttpSession;

/**
 * Created by Lsh on 2017-05-21.
 */
@Controller
public class IndexCt {
    @Autowired
    private BoardSettingSv boardSettingSv;
    @Autowired
    private DefaultSystemSettingSv defaultSystemSettingSv;
    @Autowired
    private MenuSetting menuSetting;

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public ModelAndView menuSetting(
    ) {
        ModelAndView mv = new ModelAndView("index");

        menuSetting.menuSetting(mv);

        List<BoardSettingData> boardSettings = boardSettingSv.getBoardSettings();
        mv.addObject("boardSettings", boardSettings);

        List<DefaultSystemSettingData> getBrowserName = defaultSystemSettingSv.getDefaultSystemSettings();
        mv.addObject("browserTitle", getBrowserName);
        return mv;
    }

    @RequestMapping(value = "/securityChk_org.do", method = RequestMethod.GET)
    public ModelAndView securityChk(
            HttpSession session
    ) {
        ModelAndView mv = new ModelAndView("pageJsonReport");

        if ((int) session.getAttribute("securityRating") <= 2) {
            mv.addObject("success", false);
        } else
            mv.addObject("success", true);

        return mv;
    }
}
