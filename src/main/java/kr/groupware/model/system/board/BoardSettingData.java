package kr.groupware.model.system.board;

import lombok.Data;

@Data
public class BoardSettingData {
    private int boardNo;
    private int sequence;
    private boolean used;
    private String boardName;
}
