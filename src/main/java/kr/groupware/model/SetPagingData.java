package kr.groupware.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SetPagingData {
    private Integer firstNo;
    private Integer lastNo;

    public Map<String, Integer> makeMap ()
    {
        Map<String, Integer> mapData = new HashMap<>();
            mapData.put ("firstNo", firstNo);
            mapData.put ("lastNo", lastNo);
        return mapData;
    }
}
