package kr.groupware.server.controller.org;

import kr.groupware.model.rank.position.PositionData;
import kr.groupware.model.rank.position.PositionSv;
import kr.groupware.model.rank.spot.SpotData;
import kr.groupware.model.rank.spot.SpotSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lsh on 2017-05-23.
 */
@Controller
@RequestMapping(value = "/org/rank/")
public class RankCt {
    @Autowired
    PositionSv positionSv;
    @Autowired
    SpotSv spotSv;

    @RequestMapping(value = "/positionList.do",method=RequestMethod.GET)
    public ModelAndView getPositions(){
        ModelAndView mv=new ModelAndView("org/rank/positionList");
        List<PositionData> positionList=positionSv.getPositions();
        mv.addObject("positionList",positionList);
        return mv;
    }

    @RequestMapping(value = "/positonList.do",method=RequestMethod.GET)
    public ModelAndView getPosition(
            @RequestParam(value = "positionNo",required = false)int positionNo
    ){
        ModelAndView mv=new ModelAndView("org/rank/positionList");
        PositionData getPosition=positionSv.getPosition(positionNo);
        mv.addObject("getPosition",getPosition);
        return mv;
    }

    @RequestMapping(value = "/reloadPosition.do",method = RequestMethod.GET)
    public ModelAndView reloadPosition(){
        ModelAndView mv=new ModelAndView("org/rank/reloadPosition");
        List<PositionData> positionList=positionSv.getPositions();
        mv.addObject("positionList",positionList);
        return mv;
    }

    @RequestMapping(value = "/addPosition.do",method = RequestMethod.POST)
    public ModelAndView addPosition(
            @RequestParam(value = "positionName", required = false) String positionName,
            @RequestParam(value = "ranking", required = false) int ranking
    ){
        PositionData positionData=new PositionData();
        positionData.setPositionName(positionName);
        positionData.setRanking(ranking);
        positionSv.addPosition(positionData);
        return new ModelAndView("redirect:/org/rank/positionList.do");
    }

    @RequestMapping(value = "/deletePosition.do",method = RequestMethod.GET)
    public ModelAndView deletePosition(
            @RequestParam(value = "positionNo",required = false) int positionNo
    ){
        positionSv.deletePosition(positionNo);
        return new ModelAndView("redirect:/org/rank/positionList.do");
    }

    @RequestMapping(value = "/modifyPosition.do",method = RequestMethod.POST)
    public ModelAndView modifyPosition(
            @RequestParam(value = "positionNo",required = false) int positionNo,
            HttpServletRequest request
    ){
        PositionData positionData=positionSv.getPosition(positionNo);
        positionData.setPositionName(request.getParameter("positionName_"+positionNo));
        positionData.setRanking(Integer.parseInt(request.getParameter("ranking_"+positionNo)));
        positionSv.modifyPosition(positionData);

        return new ModelAndView("redirect:/org/rank/positionList.do");
    }

    @RequestMapping(value = "/spotList.do",method = RequestMethod.GET)
    public ModelAndView positionList(){
        ModelAndView mv=new ModelAndView("org/rank/spotList");
        List<SpotData> spotList=spotSv.getSpots();
        mv.addObject("spotList",spotList);
        return mv;
    }

    @RequestMapping(value = "/reloadSpot.do",method = RequestMethod.GET)
    public ModelAndView reloadSpot(){
        ModelAndView mv=new ModelAndView("org/rank/reloadSpot");
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
            HttpServletRequest request
    ){
        SpotData spotData=spotSv.getSpot(spotNo);
        spotData.setRanking(Integer.parseInt(request.getParameter("ranking_" + spotNo)));
        spotData.setSpotName(request.getParameter("spotName_"+spotNo));
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
