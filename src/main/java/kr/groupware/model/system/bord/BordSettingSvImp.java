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

    @Override
    public void upBordSeq(int bordNo){
        BordSettingData upBord=getBordSetting(bordNo);
        Integer downBordNo=bordSettingRepository.getDownBordNo(bordNo);
        if(downBordNo!=null) {
            BordSettingData downBord = getBordSetting(downBordNo);
            int upBordSeq = upBord.getSequence();
            upBord.setSequence(downBord.getSequence());
            downBord.setSequence(upBordSeq);

            bordSettingRepository.modifyBordSetting(upBord);
            bordSettingRepository.modifyBordSetting(downBord);
        }
    }

    @Override
    public void downBordSeq(int bordNo){
        BordSettingData downBord=getBordSetting(bordNo);
        Integer upBordNo=bordSettingRepository.getUpBordNo(bordNo);
        if(upBordNo!=null) {
            BordSettingData upBord = getBordSetting(upBordNo);
            int downBordSeq = downBord.getSequence();
            downBord.setSequence(upBord.getSequence());
            upBord.setSequence(downBordSeq);

            bordSettingRepository.modifyBordSetting(downBord);
            bordSettingRepository.modifyBordSetting(upBord);
        }

    }
}
