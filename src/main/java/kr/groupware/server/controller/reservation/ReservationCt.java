package kr.groupware.server.controller.reservation;

import kr.groupware.model.reservationSystem.place.PlaceData;
import kr.groupware.model.reservationSystem.place.PlaceSv;
import kr.groupware.model.reservationSystem.reservation.ReservationSv;
import kr.groupware.server.controller.MenuSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/reservation/reservation")
public class ReservationCt {
    @Autowired
    private ReservationSv reservationSv;
    @Autowired
    private PlaceSv placeSv;
    @Autowired
    private MenuSetting menuSetting;

    @RequestMapping(value = "/reservationList.do",method = RequestMethod.GET)
    public ModelAndView getReservations(){
        ModelAndView mv=new ModelAndView("/reservation/reservation/reservationList");

        menuSetting.menuSetting(mv);

        List<PlaceData> placeData=placeSv.getPlaces();

        mv.addObject("place",placeData);

        return mv;
    }
}
