package kr.groupware.model.member;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ModifyMemberData
{
    private String memberId;
    private String pw;
    private String name;
    private Integer positionNo;

    private String positionName;


    private Integer spotNo;

    private String spotName;

    private Integer departmentNo;

    private String departmentName;

    private String email;
    private Date entryDate;

    private Boolean used;
    private Integer securityRating;
    private String businessNo;
}
