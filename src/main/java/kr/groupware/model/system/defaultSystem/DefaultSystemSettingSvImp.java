package kr.groupware.model.system.defaultSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSystemSettingSvImp implements DefaultSystemSettingSv {
    @Autowired DefaultSystemSettingRepository defaultSystemSettingRepository;

    @Override
    public List<DefaultSystemSettingData> getDefaultSystemSettings(){
        return defaultSystemSettingRepository.getDefaultSystemSettings();
    }

    @Override
    public void modifyBrowserTitle(DefaultSystemSettingData defaultSystemSettingData){
        defaultSystemSettingRepository.modifyBrowserTitle(defaultSystemSettingData);
    }
}
