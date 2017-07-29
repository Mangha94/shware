package kr.groupware.model.number;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class NumberSetRankData {
    private Integer no;
    private Integer rank;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Map<String,Object> makeMap(){
        Map<String,Object> mapData=new HashMap<>();
        if(no!=null){
            mapData.put("no",no);
        }
        if(rank!=null){
            mapData.put("rank",rank);
        }
        return mapData;
    }

}
