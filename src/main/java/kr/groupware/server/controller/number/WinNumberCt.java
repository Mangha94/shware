package kr.groupware.server.controller.number;

import kr.groupware.model.number.NumberSv;
import kr.groupware.model.winNumber.WinNumberData;
import kr.groupware.model.winNumber.WinNumberSv;
import kr.groupware.server.controller.MenuSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/lotto/winNumber")
public class WinNumberCt {
    @Autowired
    private WinNumberSv winNumberSv;
    @Autowired
    private NumberSv numberSv;
    @Autowired
    private MenuSetting menuSetting;

    @RequestMapping(value = "/winNumberList.do",method = RequestMethod.GET)
    public ModelAndView winNumber(){
        ModelAndView mv=new ModelAndView("/lotto/winNumber/winNumberList");
        List<WinNumberData>winNumberList=winNumberSv.getWinNumbers();

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        mv.addObject("winNumberList",winNumberList);
        return mv;
    }

    @RequestMapping(value = "/setWinNumber",method = RequestMethod.POST)
    public String setWinNumber(
            WinNumberData winNumberData
    ){
        winNumberSv.setWinNumber(winNumberData);
        numberSv.setRank(winNumberData.getTimes());

        return "redirect:/lotto/winNumber/winNumberList.do";
    }

    @RequestMapping(value = "reloadWinNumberList",method = RequestMethod.GET)
    public ModelAndView reloadWinNumberList(){
        ModelAndView mv=new ModelAndView("/lotto/winNumber/reloadWinNumberList");
        List<WinNumberData>winNumberList=winNumberSv.getWinNumbers();

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        mv.addObject("winNumberList",winNumberList);
        return mv;
    }


}
