package kr.groupware.model.memo;


import java.util.List;

public interface MemoSv {
    List<MemoData> getMemoList();

    List<MemoData> getMemo(String memberId);

    boolean insertMemo(MemoData memoData);

    void modifyMemo(MemoData memoData);

    void deleteMemo(int memoNo);
}
