package kr.groupware.model.reservationSystem.place;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lsh on 2017-07-30.
 */
@Repository
public class PlaceRepositoryImp extends SqlSessionDaoSupport implements PlaceRepository{
    @Override
    public List<PlaceData>getPlaces(){
        return getSqlSession().selectList("place.getPlaces");
    }

    @Override
    public PlaceData getPlace(String place){
        return getSqlSession().selectOne("place.getPlace",place);
    }

    @Override
    public void insertPlace(PlaceData placeData){
        getSqlSession().insert("place.insertPlace",placeData);
    }

    @Override
    public void modifyPlace(PlaceData placeData){
        getSqlSession().update("place.modifyPlace",placeData);
    }

    @Override
    public void deletePlace(int placeNo){
        getSqlSession().delete("place.deletePlace",placeNo);
    }
}
