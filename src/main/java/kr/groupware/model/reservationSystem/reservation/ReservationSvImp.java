package kr.groupware.model.reservationSystem.reservation;

import kr.groupware.model.reservationSystem.place.PlaceData;
import kr.groupware.model.reservationSystem.place.PlaceSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationSvImp implements ReservationSv{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private PlaceSv placeSv;

    @Override
    public List<ReservationData>getReservations(){
        return reservationRepository.getReservations();
    }

    @Override
    public List<ReservationData>getReservation(Date date){
        return reservationRepository.getReservation(date);
    }

    @Override
    public ReservationData getMaxReservation(Date startTime){
        return reservationRepository.getMaxReservation(startTime);
    }
    @Override
    public void insertReservation(ReservationData reservationData){
        ReservationData beforeReservation=getMaxReservation(reservationData.getStartTime());
        PlaceData placeData=placeSv.getPlace(reservationData.getPlace());
        if(placeData.getStartTime().compareTo(reservationData.getStartTime())>=0 && placeData.getEndTime().compareTo(reservationData.getEndTime())<=0) {
            if (beforeReservation.getEndTime().compareTo(reservationData.getStartTime()) >= 0) {
                reservationRepository.insertReservation(reservationData);
            }
        }

    }

    @Override
    public void modifyReservation(ReservationData reservationData){
        reservationRepository.modifyReservation(reservationData);
    }

    @Override
    public void deleteReservation(int reservationNo){
        reservationRepository.deleteReservation(reservationNo);
    }
}
