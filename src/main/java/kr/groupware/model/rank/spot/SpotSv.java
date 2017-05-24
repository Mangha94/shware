package kr.groupware.model.rank.spot;

import java.util.List;

/**
 * Created by Lsh on 2017-05-23.
 */
public interface SpotSv {

    //    리스트 뿌리기
    List<SpotData> getSpots();

    //    직책추가
    void addSpot(SpotData spotData);

    //    직책수정
    void modifySpot(SpotData spotData);

    //    직책삭제
    void deleteSpot(int spotNo);
}
