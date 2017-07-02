package kr.groupware.model.system.board;

import java.util.List;

/**
 * Created by Lsh on 2017-06-14.
 */
public interface BoardSettingSv {
    //    리스트 뿌리기
    List<BoardSettingData> getBoardSettings();
    //    하나 가져오기
    BoardSettingData getBoardSetting(int boardNo);
    //    게시판 추가
    void addBoardSetting(BoardSettingData boardSettingData);
    //    게시판수정
    void modifyBoardSetting(BoardSettingData boardSettingData);
    //    게시판삭제
    void deleteBoardSetting(int boardNo);
    //
    boolean upBoardSeq(int boardNo);

    boolean downBoardSeq(int boardNo);
}
