package kr.groupware.model.memo;

import lombok.Data;

import java.util.Date;

@Data
public class MemoData {
    private int memoNo;
    private String memberId;
    private String memo;
    private Date writeDate;
}
