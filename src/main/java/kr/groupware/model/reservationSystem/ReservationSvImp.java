package kr.groupware.model.reservationSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationSvImp implements ReservationSv{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<ReservationData>getReservations(){
        return reservationRepository.getReservations();
    }

    @Override
    public List<ReservationData>getReservation(Date date){
        return reservationRepository.getReservation(date);
    }

    @Override
    public void insertReservation(ReservationData reservationData){
        reservationRepository.insertReservation(reservationData);
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
