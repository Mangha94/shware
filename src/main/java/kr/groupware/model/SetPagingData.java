package kr.groupware.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SetPagingData {
    private Integer firstNo;
    private Integer lastNo;

    public Map<Integer, Integer> makeMap ()
    {
        Map<Integer, Integer> mapData = new HashMap<>();

        if (firstNo != null) {
            firstNo = lastNo * firstNo - lastNo;
            mapData.put(firstNo, firstNo);
        }
        else {
            firstNo = 1;
            mapData.put(firstNo, firstNo);
        }

        if (lastNo != null) {
            lastNo = firstNo * lastNo;
            mapData.put(lastNo, lastNo);
        }
        else {
            lastNo=10;
            mapData.put(firstNo, firstNo);
        }

        return mapData;
    }
}
