package kr.groupware.model.system.bord;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BordSettingRepositoryImp extends SqlSessionDaoSupport implements BordSettingRepository {
    @Override
    public List<BordSettingData> getBordSettings(){
        return getSqlSession().selectList("bordSetting.getBordSettings");
    }
    @Override
    public BordSettingData getBordSetting(int bordNo){
        return getSqlSession().selectOne("bordSetting.getBoredSetting",bordNo);
    }
    @Override
    public void addBordSetting(BordSettingData bordSettingData){
        getSqlSession().insert("bordSetting.addBordSetting",bordSettingData);
    }
    @Override
    public void modifyBordSetting(BordSettingData bordSettingData){
        getSqlSession().update("bordSetting.modifyBordSetting",bordSettingData);
    }
    @Override
    public void deleteBordSetting(int bordNo){
        getSqlSession().delete("bordSetting.deleteBordSetting",bordNo);
    }
}