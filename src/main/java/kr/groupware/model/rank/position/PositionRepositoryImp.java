package kr.groupware.model.rank.position;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionRepositoryImp extends SqlSessionDaoSupport implements PositionRepository {

    @Override
    public List<PositionData> getPositions(){
        return getSqlSession().selectList("position.getPositions");
    }

    @Override
    public PositionData getPosition(int positionNo){
        return getSqlSession().selectOne("position.getPosition",positionNo);
    }
    @Override
    public void addPosition(PositionData positionData){
        getSqlSession().insert("position.addPosition",positionData);
    }

    @Override
    public void modifyPosition(PositionData positionData){
        getSqlSession().update("position.modifyPosition",positionData);
    }

    @Override
    public void deletePosition(int positionNo){
        getSqlSession().delete("position.deletePosition",positionNo);
    }
}
