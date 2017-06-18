package kr.groupware.server.controller.org;

import kr.groupware.model.rank.spot.SpotData;
import kr.groupware.model.rank.spot.SpotSv;
import kr.groupware.server.controller.MenuSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/org/rank/")
public class SpotCt {
    @Autowired
    private SpotSv spotSv;
    @Autowired
    private MenuSetting menuSetting;
    @RequestMapping(value = "/spotList.do",method = RequestMethod.GET)
    public ModelAndView spotList(){
        ModelAndView mv=new ModelAndView("org/rank/spotList");

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        List<SpotData> spotList=spotSv.getSpots();
        mv.addObject("spotList",spotList);
        return mv;
    }

    @RequestMapping(value = "/reloadSpot.do",method = RequestMethod.GET)
    public ModelAndView reloadSpot(){
        ModelAndView mv=new ModelAndView("org/rank/reloadSpot");

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        List<SpotData> spotList=spotSv.getSpots();
        mv.addObject("spotList",spotList);
        return mv;
    }

    @RequestMapping(value = "/addSpot.do",method = RequestMethod.POST)
    public ModelAndView addSpot(
            @RequestParam(value = "ranking",required = false)int ranking,
            @RequestParam(value = "spotName",required = false)String spotName
    ){
        SpotData spotData=new SpotData();
        spotData.setRanking(ranking);
        spotData.setSpotName(spotName);
        spotSv.addSpot(spotData);
        return new ModelAndView("redirect:/org/rank/spotList.do");
    }

    @RequestMapping(value="/modifySpot.do",method = RequestMethod.POST)
    public ModelAndView modifySpot(
            @RequestParam(value = "spotNo",required = false)int spotNo,
            @RequestParam(value = "ranking",required = false)int ranking,
            @RequestParam(value = "spotName",required = false)String spotName
    ){
        SpotData spotData=spotSv.getSpot(spotNo);
        spotData.setRanking(ranking);
        spotData.setSpotName(spotName);
        spotSv.modifySpot(spotData);
        return new ModelAndView("redirect:/org/rank/spotList.do");
    }

    @RequestMapping(value = "/deleteSpot.do",method = RequestMethod.GET)
    public ModelAndView deleteSpot(
            @RequestParam(value = "spotNo",required = false)int spotNo
    )
    {
        spotSv.deleteSpot(spotNo);
        return new ModelAndView("redirect:/org/rank/spotList.do");
    }
}
