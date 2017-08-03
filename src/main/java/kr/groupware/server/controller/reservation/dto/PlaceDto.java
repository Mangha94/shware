package kr.groupware.server.controller.reservation.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by Lsh on 2017-08-03.
 */
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
