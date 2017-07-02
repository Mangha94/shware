package kr.groupware.model.system.board;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardSettingRepositoryImp extends SqlSessionDaoSupport implements BoardSettingRepository {
    @Override
    public List<BoardSettingData> getBoardSettings(){
        return getSqlSession().selectList("boardSetting.getBoardSettings");
    }
    @Override
    public BoardSettingData getBoardSetting(int boardNo){
        return getSqlSession().selectOne("boardSetting.getBoardSetting",boardNo);
    }
    @Override
    public void addBoardSetting(BoardSettingData boardSettingData){
        getSqlSession().insert("boardSetting.addBoardSetting", boardSettingData);
    }
    @Override
    public void modifyBoardSetting(BoardSettingData boardSettingData){
        getSqlSession().update("boardSetting.modifyBoardSetting", boardSettingData);
    }
    @Override
    public void deleteBoardSetting(int boardNo){
        getSqlSession().delete("boardSetting.deleteBoardSetting",boardNo);
    }

    @Override
    public Integer getMostSeqBoardNo(){
        return getSqlSession().selectOne("boardSetting.getMostSeqBoardNo");
    }
    //내릴 게시판의 boardNo를 리턴
    @Override
    public Integer getDownBoardNo(int boardNo){
        return getSqlSession().selectOne("boardSetting.findMaxBoardNo",boardNo);
    }

    /**
     * 올릴 게시판의 boardNo를 리턴
     * @param boardNo
     * @return
     */
    @Override
    public Integer getUpBoardNo(int boardNo){
        return getSqlSession().selectOne("boardSetting.findMinBoardNo",boardNo);
    }
}
