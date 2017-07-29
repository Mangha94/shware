package kr.groupware.model.number;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by LSH on 2017-07-18.
 */
@Repository
public class NumberRepositoryImp extends SqlSessionDaoSupport implements NumberRepository {

    /**
     * 뽑았던 모든 목록을 가져온다
     * @return 뽑았던 목록
     */
    @Override
    public List<NumberData>getNumbers(){
        return getSqlSession().selectList("Number.getNumbers");
    }

    /**
     * 회차에 해당하는 뽑은 번호 목록을 가져온다
     * @param times 회차
     * @return 회차에 해당하는 뽑은 번호 목록
     */
    @Override
    public List<NumberData>getNumber_times(int times){
        return getSqlSession().selectList("Number.getNumber_times",times);
    }

    /**
     * 랜덤 숫자가 들어있는 numberData 를 데이터 베이스에 저장한다
     * @param numberData 랜덤 숫자
     */
    @Override
    public void pickNumbers(NumberData numberData){
        getSqlSession().insert("Number.pickNumbers",numberData);
    }

    public List<NumberData>showPickNumber(){
        return getSqlSession().selectList("Number.showPickNumber");
    }

    public int getMaxTimes(){
        Integer val = (Integer) getSqlSession().selectOne("Number.getMaxTimes");

        if (val == null)
            return 0;
        else
            return val;
    }

    /**
     * 등수가 입력된 데이터를 덮어쓴다
     * @param numberMap 등수가 입력된 데이터
     */
    @Override
    public void setRank(Map<String,Object> numberMap){
        getSqlSession().update("Number.setRank",numberMap);
    }
}
