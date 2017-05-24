package kr.groupware.test;

import kr.groupware.model.rank.position.PositionData;
import kr.groupware.model.rank.position.PositionSv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Lsh on 2017-05-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "classpath:common.xml",
                "classpath:db.xml"
        }
)
public class PositionTest {
    @Autowired
    PositionSv positionSv;
    @Test
    public void test1(){
        PositionData positionData=new PositionData();

//        positionData.setPositionName("test1");
//        positionData.setRanking(1);
//        positionSv.addPosition(positionData);

        System.out.println(positionSv.getPositions());
//        positionData=positionSv.getPosition(1);
//
//        positionData.setPositionName("test2");
//        positionData.setRanking(2);
//        positionSv.modifyPosition(positionData);
//        System.out.println(positionData);
//
//        positionSv.deletePosition(1);

    }
}
