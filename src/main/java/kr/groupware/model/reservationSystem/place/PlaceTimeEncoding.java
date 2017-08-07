package kr.groupware.model.reservationSystem.place;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by LSH on 2017-08-07.
 */
@Data
public class PlaceTimeEncoding {
    private int placeNo;
    private String place;
    private Date startTime;
    private Date endTime;
}
