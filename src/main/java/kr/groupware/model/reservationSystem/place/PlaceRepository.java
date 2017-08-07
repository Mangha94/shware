package kr.groupware.model.reservationSystem.place;

import java.util.List;

/**
 * Created by Lsh on 2017-07-30.
 */
public interface PlaceRepository {
    /**
     *예약 장소정보를 가져온다
     */
    List<PlaceData> getPlaces();

    /**
     * 이름에 해당하는 예약 장소정보를 가져온다
     */
    PlaceData getPlace(int placeNo);

    /**
     *예약 장소정보를 등록한다
     */
    void insertPlace(PlaceData placeData);

    /**
     * 예약 장소정보를 수정한다
     */
    void modifyPlace(PlaceData placeData);

    /**
     * 예약 장소정보를 삭제한다
     */
    void deletePlace(int placeNo);
}
