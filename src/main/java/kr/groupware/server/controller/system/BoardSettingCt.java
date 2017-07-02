package kr.groupware.server.controller.system;

import kr.groupware.model.system.board.BoardSettingData;
import kr.groupware.model.system.board.BoardSettingSv;
import kr.groupware.server.controller.MenuSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/system")
public class BoardSettingCt {
    @Autowired
    private BoardSettingSv boardSettingSv;
    @Autowired
    private MenuSetting menuSetting;

    @RequestMapping(value = "/boardSetting.do", method = RequestMethod.GET)
    public ModelAndView getBoardSetting() {
        ModelAndView mv = new ModelAndView("/system/boardSetting");

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        List<BoardSettingData> getBoardSettingList = boardSettingSv.getBoardSettings();
        mv.addObject("boardSettingList", getBoardSettingList);
        return mv;
    }

    @RequestMapping(value = "/addBoardSetting.do", method = RequestMethod.POST)
    public String addBoardSetting(
            BoardSettingData boardSettingData
    ) {
        boardSettingSv.addBoardSetting(boardSettingData);
        return "redirect:/system/boardSetting.do";
    }

    @RequestMapping(value = "modifyBoardSetting.do", method = RequestMethod.POST)
    public String modifyBoardSetting(
            BoardSettingData boardSettingData
    ) {
        boardSettingSv.modifyBoardSetting(boardSettingData);
        return "redirect:/system/boardSetting.do";
    }

    @RequestMapping(value = "deleteBoardSetting.do", method = RequestMethod.GET)
    public String deleteBoardSetting(
            @RequestParam(value = "boardNo", required = false) int boardNo
    ) {
        boardSettingSv.deleteBoardSetting(boardNo);
        return "redirect:/system/boardSetting.do";
    }

    @RequestMapping(value = "upBoardSeq.do", method = RequestMethod.POST)
    public ModelAndView upBoardSeq(
            @RequestParam(value = "boardNo", required = false) int boardNo
    ) {
        ModelAndView mv = new ModelAndView("pageJsonReport");

        mv.addObject("success", boardSettingSv.upBoardSeq(boardNo));
        return mv;
    }

    @RequestMapping(value = "downBoardSeq.do", method = RequestMethod.POST)
    public ModelAndView downBoardSeq(
            @RequestParam(value = "boardNo", required = false) int boardNo
    ) {
        ModelAndView mv = new ModelAndView("pageJsonReport");


        mv.addObject("success", boardSettingSv.downBoardSeq(boardNo));
        return mv;
    }

    @RequestMapping(value = "reloadBoardSetting.do", method = RequestMethod.GET)
    public ModelAndView reloadBoardSetting() {
        ModelAndView mv = new ModelAndView("/system/reloadBoardSetting");

        List<BoardSettingData>boardSettingList= boardSettingSv.getBoardSettings();
        mv.addObject("boardSettingList",boardSettingList);
        return mv;
    }
}
