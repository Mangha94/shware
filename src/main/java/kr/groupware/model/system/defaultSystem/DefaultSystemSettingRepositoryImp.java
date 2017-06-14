package kr.groupware.model.system.defaultSystem;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultSystemSettingRepositoryImp extends SqlSessionDaoSupport implements DefaultSystemSettingRepository {

    @Override
    public List<DefaultSystemSettingData>getDefaultSystemSettings(){
        return getSqlSession().selectList("defaultSystemSetting.getDefaultSystemSettings");
    }

    @Override
    public void modifyBrowserTitle(DefaultSystemSettingData defaultSystemSettingData){
        getSqlSession().update("defaultSystemSetting.modifyBrowserTitle",defaultSystemSettingData);
    }
}
