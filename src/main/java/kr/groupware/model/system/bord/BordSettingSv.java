package kr.groupware.model.system.bord;

import java.util.List;

/**
 * Created by Lsh on 2017-06-14.
 */
public interface BordSettingSv {
    //    리스트 뿌리기
    List<BordSettingData> getBordSettings();
    //    하나 가져오기
    BordSettingData getBordSetting(int bordNo);
    //    게시판 추가
    void addBordSetting(BordSettingData bordSettingData);
    //    게시판수정
    void modifyBordSetting(BordSettingData bordSettingData);
    //    게시판삭제
    void deleteBordSetting(int bordNo);
    //
    void upBordSeq(int bordNo);

    void downBordSeq(int bordNo);
}
