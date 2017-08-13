package kr.groupware.model.memo;

import java.util.List;


public interface MemoRepository {
    List<MemoData> getMemoList();

    List<MemoData> getMemo(String memberId);

    void insertMemo(MemoData memoData);

    void modifyMemo(MemoData memoData);

    void deleteMemo(int memoNo);
}
