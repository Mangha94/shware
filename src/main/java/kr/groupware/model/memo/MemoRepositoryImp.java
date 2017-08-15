package kr.groupware.model.memo;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoRepositoryImp extends SqlSessionDaoSupport implements MemoRepository{

    @Override
    public List<MemoData> getMemoList(){
        return getSqlSession().selectList("memo.getMemoList");
    }

    @Override
    public List<MemoData> getMemo(String memberId){
        return getSqlSession().selectList("memo.getMemo",memberId);
    }

    @Override
    public boolean insertMemo(MemoData memoData){
        return getSqlSession().insert("memo.insertMemo",memoData)>0;
    }

    @Override
    public void modifyMemo(MemoData memoData){
        getSqlSession().update("memo.modifyMemo",memoData);
    }

    @Override
    public void deleteMemo(int memoNo){
        getSqlSession().delete("memo.deleteMemo",memoNo);
    }
}
