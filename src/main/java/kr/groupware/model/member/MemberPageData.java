package kr.groupware.model.member;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MemberPageData {
    private Integer page;
    private Integer countList;

    public Map<Integer, Integer> makeMap ()
    {
        Map<Integer, Integer> mapData = new HashMap<>();

            mapData.put (page, page);

            mapData.put (countList, countList);

        return mapData;
    }
}
