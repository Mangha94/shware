package kr.groupware.server.controller.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.groupware.model.rank.position.PositionData;
import kr.groupware.model.rank.position.PositionSv;
import kr.groupware.model.rank.spot.SpotData;
import kr.groupware.model.rank.spot.SpotSv;

@Controller
@RequestMapping(value = "/org/rank/")
public class PositionCt {
    @Autowired
    PositionSv positionSv;

    @RequestMapping(value = "/positionList.do",method=RequestMethod.GET)
    public ModelAndView getPositions(
    ){
        ModelAndView mv=new ModelAndView("org/rank/positionList");
        List<PositionData> positionList=positionSv.getPositions();

        mv.addObject("positionList",positionList);

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
            PositionData positionData
    ){
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
    public String modifyPosition(
            @RequestParam(value = "positionNo",required = false) int positionNo,
			@RequestParam(value = "positionName", required = false) String positionName,
			@RequestParam(value = "ranking", required = false) int ranking
    ){
        PositionData positionData=positionSv.getPosition(positionNo);
        positionData.setPositionName(positionName);
        positionData.setRanking(ranking);
        positionSv.modifyPosition(positionData);

        return "redirect:/org/rank/positionList.do";
    }
}
