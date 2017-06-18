package kr.groupware.server.controller.system;

import kr.groupware.model.system.bord.BordSettingData;
import kr.groupware.model.system.bord.BordSettingSv;
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
public class bordSettingCt {
    @Autowired
    private BordSettingSv bordSettingSv;
    @Autowired
    private MenuSetting menuSetting;

    @RequestMapping(value = "/bordSetting.do", method = RequestMethod.GET)
    public ModelAndView getBordSetting() {
        ModelAndView mv = new ModelAndView("/system/bordSetting");

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        List<BordSettingData> getBordSettingList = bordSettingSv.getBordSettings();
        mv.addObject("bordSettingList", getBordSettingList);
        return mv;
    }

    @RequestMapping(value = "/addBordSetting.do", method = RequestMethod.POST)
    public String addBordSetting(
            BordSettingData bordSettingData
    ) {
        bordSettingSv.addBordSetting(bordSettingData);
        return "redirect:/system/bordSetting.do";
    }

    @RequestMapping(value = "modifyBordSetting.do", method = RequestMethod.POST)
    public String modifyBordSetting(
            BordSettingData bordSettingData
    ) {
        bordSettingSv.modifyBordSetting(bordSettingData);
        return "redirect:/system/bordSetting.do";
    }

    @RequestMapping(value = "deleteBordSetting.do", method = RequestMethod.GET)
    public String deleteBordSetting(
            @RequestParam(value = "bordNo", required = false) int bordNo
    ) {
        bordSettingSv.deleteBordSetting(bordNo);
        return "redirect:/system/bordSetting.do";
    }

    @RequestMapping(value = "upBordSeq.do", method = RequestMethod.POST)
    public ModelAndView upBordSeq(
            @RequestParam(value = "bordNo", required = false) int bordNo
    ) {
        ModelAndView mv = new ModelAndView("pageJsonReport");

        mv.addObject("success", bordSettingSv.upBordSeq(bordNo));
        return mv;
    }

    @RequestMapping(value = "downBordSeq.do", method = RequestMethod.POST)
    public ModelAndView downBordSeq(
            @RequestParam(value = "bordNo", required = false) int bordNo
    ) {
        ModelAndView mv = new ModelAndView("pageJsonReport");


        mv.addObject("success", bordSettingSv.downBordSeq(bordNo));
        return mv;
    }

    @RequestMapping(value = "reloadBordSetting.do", method = RequestMethod.GET)
    public ModelAndView reloadBordSetting() {
        ModelAndView mv = new ModelAndView("/system/reloadBordSetting");

        List<BordSettingData>BordSettingList=bordSettingSv.getBordSettings();
        mv.addObject("bordSettingList",BordSettingList);
        return mv;
    }
}
