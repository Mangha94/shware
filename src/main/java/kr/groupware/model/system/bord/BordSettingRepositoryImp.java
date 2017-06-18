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
        return getSqlSession().selectOne("bordSetting.getBordSetting",bordNo);
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

    //내릴 게시판의 bordNo를 리턴
    @Override
    public Integer getDownBordNo(int bordNo){
        return getSqlSession().selectOne("bordSetting.findMaxBordNo",bordNo);
    }

    /**
     * 올릴 게시판의 bordNo를 리턴
     * @param bordNo
     * @return
     */
    @Override
    public Integer getUpBordNo(int bordNo){
        return getSqlSession().selectOne("bordSetting.findMinBordNo",bordNo);
    }
}
