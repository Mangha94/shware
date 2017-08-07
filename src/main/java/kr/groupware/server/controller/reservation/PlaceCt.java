package kr.groupware.server.controller.reservation;

import kr.groupware.model.reservationSystem.place.PlaceData;
import kr.groupware.model.reservationSystem.place.PlaceSv;
import kr.groupware.model.reservationSystem.place.PlaceTimeEncoding;
import kr.groupware.server.controller.MenuSetting;
import kr.groupware.server.controller.reservation.dto.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


        List<PlaceTimeEncoding> timeList=new ArrayList<>();

        for(PlaceData a : placeData) {
            PlaceTimeEncoding time=new PlaceTimeEncoding();

            LocalDate today=LocalDate.now();
            LocalTime start = LocalTime.of(a.getStartHour(),a.getStartMin());
            LocalDateTime startTime=LocalDateTime.of(today,start);

            Date s=Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant());

            LocalTime end = LocalTime.of(a.getEndHour(),a.getEndMin());
            LocalDateTime endTime=LocalDateTime.of(today,end);

            Date e=Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant());

            System.out.println(startTime);
            System.out.println(endTime);

            time.setPlaceNo(a.getPlaceNo());
            time.setPlace(a.getPlace());
            time.setStartTime(s);
            time.setEndTime(e);
            timeList.add(time);
        }

        mv.addObject("placeList",timeList);

        return mv;
    }

    @RequestMapping(value = "/reloadPlace.do",method = RequestMethod.GET)
    public ModelAndView reloadPlaceList(){
        ModelAndView mv=new ModelAndView("/reservation/place/reloadPlaceList");

        menuSetting.menuSetting(mv);

        List<PlaceData> placeData=placeSv.getPlaces();

        List<PlaceTimeEncoding> timeList=new ArrayList<>();

        for(PlaceData a : placeData) {
            PlaceTimeEncoding time=new PlaceTimeEncoding();

            LocalDate today=LocalDate.now();
            LocalTime start = LocalTime.of(a.getStartHour(),a.getStartMin());
            LocalDateTime startTime=LocalDateTime.of(today,start);

            Date s=Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant());

            LocalTime end = LocalTime.of(a.getEndHour(),a.getEndMin());
            LocalDateTime endTime=LocalDateTime.of(today,end);

            Date e=Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant());

            System.out.println(startTime);
            System.out.println(endTime);

            time.setPlaceNo(a.getPlaceNo());
            time.setPlace(a.getPlace());
            time.setStartTime(s);
            time.setEndTime(e);
            timeList.add(time);
        }

        mv.addObject("placeList",timeList);

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
            PlaceDto.AddPlaceDto placeData
    ){
        PlaceData place=placeSv.getPlace(placeData.getPlaceNo());

        place.setPlace(placeData.getPlace());
        String[]startTimeAry=placeData.getStartTime().split(":");
        place.setStartHour(Integer.parseInt(startTimeAry[0]));
        place.setStartMin(Integer.parseInt(startTimeAry[1]));

        String[]endTimeAry=placeData.getEndTime().split(":");
        place.setEndHour(Integer.parseInt(endTimeAry[0]));
        place.setEndMin(Integer.parseInt(endTimeAry[1]));
        placeSv.modifyPlace(place);

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
