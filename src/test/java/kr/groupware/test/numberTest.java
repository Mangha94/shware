package kr.groupware.test;

import kr.groupware.model.number.NumberData;
import kr.groupware.model.number.NumberSv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "classpath:common.xml",
                "classpath:db.xml"
        }
)
public class numberTest {
    @Autowired
    private NumberSv numberSv;

    @Test
    public void test(){
        NumberData numberData=new NumberData();
        numberData.setMemberId("test");
        numberData.setNum1(1);
        numberData.setNum2(3);
        numberData.setNum3(5);
        numberData.setNum4(7);
        numberData.setNum5(9);
        numberData.setNum6(11);
        numberSv.pickNumbers("");
    }
}
