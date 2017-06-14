package kr.groupware.model.system.bord;

import lombok.Data;

@Data
public class BordSettingData {
    private int bordNo;
    private int sequence;
    private boolean used;
    private String bordName;
}
