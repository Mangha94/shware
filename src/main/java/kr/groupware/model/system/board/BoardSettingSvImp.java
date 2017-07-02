package kr.groupware.model.system.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardSettingSvImp implements BoardSettingSv {
    @Autowired
    BoardSettingRepository boardSettingRepository;
    //추가수정삭제 리스트
    @Override
    public List<BoardSettingData> getBoardSettings(){
        return boardSettingRepository.getBoardSettings();
    }
    @Override
    public BoardSettingData getBoardSetting(int boardNo){
        return boardSettingRepository.getBoardSetting(boardNo);
    }
    @Override
    public void addBoardSetting(BoardSettingData boardSettingData){
        Integer mostSeq= boardSettingRepository.getMostSeqBoardNo();
        if(mostSeq==null) {
            mostSeq=0;
        }
        boardSettingData.setSequence(mostSeq+1);
        boardSettingRepository.addBoardSetting(boardSettingData);
    }
    @Override
    public void modifyBoardSetting(BoardSettingData boardSettingData){
        boardSettingRepository.modifyBoardSetting(boardSettingData);
    }
    @Override
    public void deleteBoardSetting(int boardNo){
        boardSettingRepository.deleteBoardSetting(boardNo);
    }

    @Override
    public boolean upBoardSeq(int boardNo){
        BoardSettingData upBoard= getBoardSetting(boardNo);
        Integer downBoardNo= boardSettingRepository.getDownBoardNo(boardNo);
        return modifySeq(downBoardNo,upBoard);
    }

    @Override
    public boolean downBoardSeq(int boardNo){
        BoardSettingData downBoard= getBoardSetting(boardNo);
        Integer upBoardNo= boardSettingRepository.getUpBoardNo(boardNo);
        return modifySeq(upBoardNo,downBoard);

    }

    /**
     *
     * @param boardNo 내려지거나 올려질 boardSettingData 의 boardNo
     * @param boardSettingData 올리거나 내릴 boardSetting
     */
    private boolean modifySeq(Integer boardNo,BoardSettingData boardSettingData){
        if(boardNo!=null) {
            BoardSettingData upBoard = getBoardSetting(boardNo);
            int downBoardSeq = boardSettingData.getSequence();
            boardSettingData.setSequence(upBoard.getSequence());
            upBoard.setSequence(downBoardSeq);

            boardSettingRepository.modifyBoardSetting(boardSettingData);
            boardSettingRepository.modifyBoardSetting(upBoard);

            return true;
        }
        else
            return false;
    }
}
