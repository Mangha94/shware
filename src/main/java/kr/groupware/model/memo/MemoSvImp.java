package kr.groupware.model.memo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemoSvImp implements MemoSv{
    @Autowired
    private MemoRepository memoRepository;

    @Override
    public List<MemoData> getMemoList(){
        return memoRepository.getMemoList();
    }

    @Override
    public List<MemoData> getMemo(String memberId){
        return memoRepository.getMemo(memberId);
    }

    @Override
    public void insertMemo(MemoData memoData){
        memoData.setWriteDate(new Date());
        memoRepository.insertMemo(memoData);
    }

    @Override
    public void modifyMemo(MemoData memoData){
        memoRepository.modifyMemo(memoData);
    }

    @Override
    public void deleteMemo(int memoNo){
        memoRepository.deleteMemo(memoNo);
    }
}
