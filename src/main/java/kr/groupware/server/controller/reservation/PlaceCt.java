package kr.groupware.server.controller.reservation;

import kr.groupware.model.reservationSystem.place.PlaceData;
import kr.groupware.model.reservationSystem.place.PlaceSv;
import kr.groupware.server.controller.MenuSetting;
import kr.groupware.server.controller.reservation.dto.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static sun.misc.PerformanceLogger.getStartTime;

@Controller
@RequestMapping(value = "/reservation/place")
public class PlaceCt {
    @Autowired
    private PlaceSv placeSv;
    @Autowired
    private MenuSetting menuSetting;

    @RequestMapping(value = "/placeList.do",method = RequestMethod.GET)
    public ModelAndView placeList(){
        ModelAndView mv=new ModelAndView("/reservation/place/placeList");

        menuSetting.menuSetting(mv);

        List<PlaceData> placeData=placeSv.getPlaces();

        mv.addObject("placeList",placeData);

        return mv;
    }

    @RequestMapping(value = "/reloadPlaceList.do",method = RequestMethod.GET)
    public ModelAndView reloadPlaceList(){
        ModelAndView mv=new ModelAndView("/reservation/place/reloadPlaceList");

        menuSetting.menuSetting(mv);

        List<PlaceData> placeData=placeSv.getPlaces();

        mv.addObject("placeList",placeData);

        return mv;
    }

    @RequestMapping(value = "/insertPlace.do",method = RequestMethod.POST)
    public String insertPlace(
            PlaceDto.AddPlaceDto placeData
    ){
        PlaceData place=new PlaceData();

        place.setPlace(placeData.getPlace());
        String[]startTimeAry=placeData.getStartTime().split(":");
        place.setStartHour(Integer.parseInt(startTimeAry[0]));
        place.setStartMin(Integer.parseInt(startTimeAry[1]));

        String[]endTimeAry=placeData.getEndTime().split(":");
        place.setEndHour(Integer.parseInt(endTimeAry[0]));
        place.setEndMin(Integer.parseInt(endTimeAry[1]));

        placeSv.insertPlace(place);

        return "redirect:/reservation/place/placeList.do";
    }

    @RequestMapping(value = "/modifyPlace.do",method = RequestMethod.POST)
    public String modifyPlace(
            PlaceData placeData
    ){
        placeSv.modifyPlace(placeData);

        return "redirect:/reservation/place/placeList.do";
    }

    @RequestMapping(value = "/deletePlace.do",method = RequestMethod.GET)
    public String deletePlace(
            @RequestParam(value = "placeNo",required = false)int placeNo
    ){
        placeSv.deletePlace(placeNo);

        return "redirect:/reservation/place/placeList.do";
    }
}
