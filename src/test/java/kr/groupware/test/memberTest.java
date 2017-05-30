package kr.groupware.test;

import kr.groupware.model.member.MemberData;
import kr.groupware.model.member.MemberSv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "classpath:common.xml",
                "classpath:db.xml"
        }
)
public class memberTest {
    @Autowired MemberSv memberSv;
    @Test
    public void Test(){
//        MemberData memberData=new MemberData();
//        memberData.setMemberId("test");
//        memberData.setPw("1234");
//        memberData.setName("test");
//        memberData.setPositionNo(1);
//        memberData.setSpotNo(1);
//        memberData.setDepartmentNo(1);
//        memberData.setEmail("test@test.com");
//        memberData.setEntryDate(new Date());
//        memberData.setModifyDate(new Date());
//        memberData.setRegistrationDate(new Date());
//        memberData.setLastAccessTime(new Date());
//        memberData.setUsed(true);
//        memberData.setSecurityRating(3);
//        memberData.setBusinessNo("2017-0529");
//        memberSv.addMember(memberData);

        System.out.println(memberSv.getMembers());

        MemberData memberData=memberSv.getMember("test");
        memberData.setPw("123456");
        memberData.setName("test");
        memberData.setPositionNo(3);
        memberData.setSpotNo(3);
        memberData.setDepartmentNo(3);
        memberData.setEmail("test1@test1.com");
        memberData.setEntryDate(new Date());
        memberData.setModifyDate(new Date());
        memberData.setRegistrationDate(new Date());
        memberData.setLastAccessTime(new Date());
        memberData.setUsed(false);
        memberData.setSecurityRating(3);
        memberData.setBusinessNo("2017-0530");
        memberSv.modifyMember(memberData);

        System.out.println(memberSv.getMember("test"));

        memberSv.deleteMember("test");
        System.out.println(memberSv.getCount());
    }
}