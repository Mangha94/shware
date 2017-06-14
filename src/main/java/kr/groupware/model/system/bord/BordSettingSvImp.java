package kr.groupware.model.system.bord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BordSettingSvImp implements BordSettingSv {
    @Autowired BordSettingRepository bordSettingRepository;
    //추가수정삭제 리스트
    @Override
    public List<BordSettingData>getBordSettings(){
        return bordSettingRepository.getBordSettings();
    }
    @Override
    public BordSettingData getBordSetting(int bordNo){
        return bordSettingRepository.getBordSetting(bordNo);
    }
    @Override
    public void addBordSetting(BordSettingData bordSettingData){
        bordSettingRepository.addBordSetting(bordSettingData);
    }
    @Override
    public void modifyBordSetting(BordSettingData bordSettingData){
        bordSettingRepository.modifyBordSetting(bordSettingData);
    }
    @Override
    public void deleteBordSetting(int bordNo){
        bordSettingRepository.deleteBordSetting(bordNo);
    }

}
