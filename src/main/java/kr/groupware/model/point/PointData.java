package kr.groupware.model.point;

import lombok.Data;

import java.util.Date;

@Data
public class PointData {
    private int pointNo;
    private String memberId;
    private String useHistory;
    private String chargeHistory;
    private int point;
    private Date useDate;
    private Date chargeDate;
}
