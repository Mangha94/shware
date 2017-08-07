package kr.groupware.server.controller.reservation.dto;

import lombok.Data;

public class PlaceDto {
    @Data
    static public class AddPlaceDto
    {
        private int placeNo;
        private String place;
        private String startTime;
        private String endTime;
    }

}
