package kr.groupware.model.reservationSystem.reservation;


import java.util.Date;
import java.util.List;

public interface ReservationSv {

    /**
     * @return 모든 예약 현황을 가져온다
     */
    List<ReservationData>getReservations();

    /**
     * 그 날에 해당하는 예약을 가져온다
     */
    List<ReservationData>getReservation(Date date);

    /**
     * 해당 시작 시간 보다 작은 예약 중에 가장큰놈을 가져온다
     */
    ReservationData getMaxReservation(Date StartTime);

    /**
     *  @return 예약을 한다
     */
    void insertReservation(ReservationData reservationData);


    /**
     * 예약을 수정한다
     */
    void modifyReservation(ReservationData reservationData);

    /**
     * 예약을 취소한다
     */
    void deleteReservation(int reservationNo);
}
