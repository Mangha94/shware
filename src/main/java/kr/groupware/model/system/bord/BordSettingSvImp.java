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
    public boolean upBordSeq(int bordNo){
        BordSettingData upBord=getBordSetting(bordNo);
        Integer downBordNo=bordSettingRepository.getDownBordNo(bordNo);
        return modifySeq(downBordNo,upBord);
    }

    @Override
    public boolean downBordSeq(int bordNo){
        BordSettingData downBord=getBordSetting(bordNo);
        Integer upBordNo=bordSettingRepository.getUpBordNo(bordNo);
        return modifySeq(upBordNo,downBord);

    }

    /**
     *
     * @param bordNo 내려지거나 올려질 bordSettingData 의 bordNo
     * @param bordSettingData 올리거나 내릴 bordSetting
     */
    private boolean modifySeq(Integer bordNo,BordSettingData bordSettingData){
        if(bordNo!=null) {
            BordSettingData upBord = getBordSetting(bordNo);
            int downBordSeq = bordSettingData.getSequence();
            bordSettingData.setSequence(upBord.getSequence());
            upBord.setSequence(downBordSeq);

            bordSettingRepository.modifyBordSetting(bordSettingData);
            bordSettingRepository.modifyBordSetting(upBord);

            return true;
        }
        else
            return false;
    }
}
