package kr.groupware.model.reservationSystem.reservation;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ReservationRepositoryImp extends SqlSessionDaoSupport implements ReservationRepository{

    @Override
    public List<ReservationData>getReservations(){
        return getSqlSession().selectList("reservation.getReservations");
    }

    @Override
    public List<ReservationData>getReservation(Date date){
        return getSqlSession().selectList("reservation.getReservation",date);
    }

    @Override
    public ReservationData getMaxReservation(Date startTime){
        return getSqlSession().selectOne("reservation.getMaxReservation",startTime);
    }

    @Override
    public void insertReservation(ReservationData reservationData){
        getSqlSession().insert("reservation.insertReservation",reservationData);
    }

    @Override
    public void modifyReservation(ReservationData reservationData){
        getSqlSession().update("reservation.modifyReservation",reservationData);
    }

    @Override
    public void deleteReservation(int reservationNo){
        getSqlSession().delete("reservation.deleteReservation",reservationNo);
    }

}
