package kr.groupware.model.reservationSystem.reservation;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class SearchMaxReservation {
    private Date startTime;
    private String place;

    public Map<String,Object> makeMap(){
        Map<String,Object> mapData=new HashMap<>();
        if(startTime!=null){
            mapData.put("startTime",startTime);
        }
        if(place!=null){
            mapData.put("place",place);
        }
        return mapData;
    }
}
