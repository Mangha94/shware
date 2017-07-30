package kr.groupware.model.reservationSystem;

import java.util.Date;
import java.util.List;

public interface ReservationRepository {
    /**
     * @return 모든 예약 현황을 가져온다
     */
    List<ReservationData> getReservations();

    /**
     * 그 날에 해당하는 예약을 가져온다
     */
    List<ReservationData>getReservation(Date date);

    /**
     * 예약을 한다
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
