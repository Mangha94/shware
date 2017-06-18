package kr.groupware.model.system.bord;


import java.util.List;

public interface BordSettingRepository {
    //추가수정삭제 리스트
    List<BordSettingData> getBordSettings();

    BordSettingData getBordSetting(int bordNo);

    void addBordSetting(BordSettingData bordSettingData);

    void modifyBordSetting(BordSettingData bordSettingData);

    void deleteBordSetting(int bordNo);

    /**
     * 게시판 순서 올릴때
     * @param bordNo
     * @return
     */
    int upBordSeq(int bordNo);

    int upBordNo(int bordNo);

    /**
     * 게시판 순서 내릴때
     * @param bordNo
     * @return
     */
    int downBordSeq(int bordNo);

    int downBordNo(int bordNo);
}
