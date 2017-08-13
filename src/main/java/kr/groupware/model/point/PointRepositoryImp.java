package kr.groupware.model.point;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LSH on 2017-08-13.
 */
@Repository
public class PointRepositoryImp extends SqlSessionDaoSupport implements PointRepository {
    @Override
    public List<PointData> getHistory(String memberId){
        return getSqlSession().selectList("point.getHistory",memberId);
    }

    @Override
    public void insertUseHistory(PointData pointData){
        getSqlSession().insert("point.insertUseHistory",pointData);
    }

    @Override
    public void insertChargeHistory(PointData pointData){
        getSqlSession().insert("point.insertChargeHistory",pointData);
    }
}
