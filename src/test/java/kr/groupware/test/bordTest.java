package kr.groupware.test;

import kr.groupware.model.system.bord.BordSettingData;
import kr.groupware.model.system.bord.BordSettingSv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "classpath:common.xml",
                "classpath:db.xml"
        }
)
public class bordTest {
    @Autowired
    BordSettingSv bordSettingSv;
    @Test
    public void test(){
        List<BordSettingData> test=bordSettingSv.getBordSettings();
        System.out.println(test);

        BordSettingData upTest=bordSettingSv.getBordSetting(3);
        System.out.println(upTest);

        bordSettingSv.upBordSeq(3);

        bordSettingSv.downBordSeq(3);

        System.out.println(upTest);



    }
}
