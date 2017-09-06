package kr.groupware.model.member;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MemberData {
    private String memberId;
    private String pw;
    private String name;
    private int positionNo;

    private String positionName;


    private int spotNo;

    private String spotName;

    private int departmentNo;

    private String departmentName;

    private String email;
    private Date entryDate;
    private Date modifyDate;
    private Date registrationDate;
    private Date lastAccessTime;
    private boolean used;
    private int securityRating;
    private String businessNo;
    private String jibunAddr;
    private String zipCode;
    private String streetAddr;
}
