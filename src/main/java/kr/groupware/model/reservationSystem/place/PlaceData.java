package kr.groupware.model.reservationSystem.place;

import lombok.Data;

import java.util.Date;

@Data
public class PlaceData {
    private int placeNo;
    private String place;
    private Integer startHour;
    private Integer startMin;
    private Integer endHour;
    private Integer endMin;
}
