package kr.groupware.server.controller.number;

import kr.groupware.model.number.NumberData;
import kr.groupware.model.number.NumberSv;
import kr.groupware.model.winNumber.WinNumberData;
import kr.groupware.model.winNumber.WinNumberSv;
import kr.groupware.server.controller.MenuSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/lotto/number")
public class NumberCt {
    @Autowired
    private NumberSv numberSv;
    @Autowired
    private WinNumberSv winNumberSv;

    @Autowired
    private MenuSetting menuSetting;

    @RequestMapping(value = "/pickNumber.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pickNumber(
            HttpSession session
    ) {
        ModelAndView mv = new ModelAndView("/lotto/number/pickNumber");
        String memberId = (String) session.getAttribute("memberId");
        List<NumberData> numberList = numberSv.showPickNumber(memberId);

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        mv.addObject("numberList", numberList);
        return mv;
    }

    @RequestMapping(value = "/pickNum.do", method = RequestMethod.GET)
    public ModelAndView pickNum(
            HttpSession session
    ) {
        String memberId = (String) session.getAttribute("memberId");
        NumberData numberData = numberSv.pickNumbers(memberId);

        ModelAndView mv = new ModelAndView("/lotto/number/showPickNumber");

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        mv.addObject("numberData", numberData);
        return mv;
    }

    @RequestMapping(value = "/numberList.do", method = RequestMethod.GET)
    public ModelAndView numberList(
            HttpSession session
    ) {
        ModelAndView mv = new ModelAndView("/lotto/number/numberList");

        String memberId = (String) session.getAttribute("memberId");
        List<NumberData> numberList = numberSv.getNumbers(memberId);
        List<WinNumberData> winNumberList = winNumberSv.getWinNumbers();

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        mv.addObject("numberList", numberList);
        mv.addObject("winNumberList", winNumberList);
        return mv;
    }

    @RequestMapping(value = "/showPickNumber.do", method = RequestMethod.GET)
    public ModelAndView showPickNumber(
            HttpSession session
    ) {

        ModelAndView mv = new ModelAndView("/lotto/number/showPickNumber");
        String memberId = (String) session.getAttribute("memberId");
        List<NumberData> numberList = numberSv.showPickNumber(memberId);

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        mv.addObject("numberList", numberList);
        return mv;
    }
}
