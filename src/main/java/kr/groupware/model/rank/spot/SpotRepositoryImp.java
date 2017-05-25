package kr.groupware.model.rank.spot;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpotRepositoryImp extends SqlSessionDaoSupport implements SpotRepository {
    @Override
    public List<SpotData> getSpots(){
        return getSqlSession().selectList("spot.getSpots");
    }

    @Override
    public SpotData getSpot(int spotNo){
        return getSqlSession().selectOne("spot.getSpot",spotNo);
    }

    @Override
    public void addSpot(SpotData spotData){
        getSqlSession().insert("spot.addSpot",spotData);
    }

    @Override
    public void modifySpot(SpotData spotData){
        getSqlSession().update("spot.modifySpot",spotData);
    }

    @Override
    public void deleteSpot(int spotNo){
        getSqlSession().delete("spot.deleteSpot",spotNo);
    }
}
