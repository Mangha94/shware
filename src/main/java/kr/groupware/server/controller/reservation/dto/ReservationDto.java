package kr.groupware.server.controller.reservation.dto;

import lombok.Data;

/**
 * Created by Lsh on 2017-08-07.
 */
public class ReservationDto {
    @Data
    static public class AddReservationDto
    {
        private int reservationNo;
        private String place;
        private String memberId;
        private String date;
        private String startTime;
        private String endTime;
    }
}
