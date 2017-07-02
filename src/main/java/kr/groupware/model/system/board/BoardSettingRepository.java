package kr.groupware.model.system.board;


import java.util.List;

public interface BoardSettingRepository {
    //추가수정삭제 리스트
    List<BoardSettingData> getBoardSettings();

    BoardSettingData getBoardSetting(int boardNo);

    void addBoardSetting(BoardSettingData boardSettingData);

    void modifyBoardSetting(BoardSettingData boardSettingData);

    void deleteBoardSetting(int boardNo);

    Integer getMostSeqBoardNo();

    /**
     * 게시판 순서 올릴때
     * @param boardNo
     * @return
     *
     */

    Integer getDownBoardNo(int boardNo);

    /**
     * 게시판 순서 내릴때
     * @param boardNo
     * @return
     */
    Integer getUpBoardNo(int boardNo);
}
