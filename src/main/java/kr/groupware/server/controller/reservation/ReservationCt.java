package kr.groupware.server.controller.reservation;

import kr.groupware.model.reservationSystem.place.PlaceData;
import kr.groupware.model.reservationSystem.place.PlaceSv;
import kr.groupware.model.reservationSystem.reservation.ReservationData;
import kr.groupware.model.reservationSystem.reservation.ReservationSv;
import kr.groupware.server.controller.MenuSetting;
import kr.groupware.server.controller.reservation.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

        List<ReservationData> reservationList=reservationSv.getReservations();

        mv.addObject("place",placeData);
        mv.addObject("reservationList",reservationList);

        return mv;
    }

    @RequestMapping(value = "/reloadReservation.do",method = RequestMethod.GET)
    public ModelAndView reloadReservation(){
        ModelAndView mv=new ModelAndView("/reservation/reservation/reloadReservation");

        menuSetting.menuSetting(mv);

        List<PlaceData> placeData=placeSv.getPlaces();

        List<ReservationData> reservationList=reservationSv.getReservations();

        mv.addObject("place",placeData);
        mv.addObject("reservationList",reservationList);

        return mv;
    }

    @RequestMapping(value = "/insertReservation.do",method = RequestMethod.POST)
    public String insertReservation(
            ReservationDto.AddReservationDto reservationData,
            HttpSession session
    ){
        ReservationData reservation=new ReservationData();

        reservation.setMemberId((String)session.getAttribute("memberId"));
        reservation.setPlace(reservationData.getPlace());

        String[]startTimeAry=reservationData.getStartTime().split(":");

        LocalDate startDate=LocalDate.parse(reservationData.getDate());
        LocalTime startTime=LocalTime.of(Integer.parseInt(startTimeAry[0]),Integer.parseInt(startTimeAry[1]));
        LocalDateTime start=LocalDateTime.of(startDate,startTime);
        reservation.setStartTime(Date.from(start.atZone(ZoneId.systemDefault()).toInstant()));

        String[]endTimeAry=reservationData.getEndTime().split(":");
        LocalDate endDate=LocalDate.parse(reservationData.getDate());
        LocalTime endTime=LocalTime.of(Integer.parseInt(endTimeAry[0]),Integer.parseInt(endTimeAry[1]));
        LocalDateTime end=LocalDateTime.of(endDate,endTime);
        reservation.setEndTime(Date.from(end.atZone(ZoneId.systemDefault()).toInstant()));

        reservationSv.insertReservation(reservation);

        return "redirect:/reservation/reservation/reservationList.do";
    }

//    @RequestMapping(value = "modifyReservation.do",method = RequestMethod.POST)
//    public String modifyReservation(
//            ReservationDto.AddReservationDto reservationDto
//    ){
//        ReservationData reservationData=reservationSv.getReservation()
//    }

    @RequestMapping(value = "deleteReservation.do",method = RequestMethod.GET)
    public String deleteReservation(
            @RequestParam(value = "reservationNo",required = false)int reservationNo
    ){
        reservationSv.deleteReservation(reservationNo);

        return "redirect:/reservation/reservation/reservationList.do";
    }
}
