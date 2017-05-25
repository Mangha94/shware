package kr.groupware.test;

import kr.groupware.model.rank.spot.SpotData;
import kr.groupware.model.rank.spot.SpotSv;
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
public class spotTest {
    @Autowired
    SpotSv spotSv;
    @Test
    public void test(){
        SpotData spotData=new SpotData();
//
//        spotData.setSpotName("test1");
//        spotData.setRanking(1);
//        spotSv.addSpot(spotData);

        System.out.println(spotSv.getSpots());

        spotData=spotSv.getSpot(3);
        spotData.setSpotName("test2");
        spotData.setRanking(2);
        spotSv.modifySpot(spotData);

        System.out.println(spotSv.getSpots());

        spotSv.deleteSpot(1);
    }
}