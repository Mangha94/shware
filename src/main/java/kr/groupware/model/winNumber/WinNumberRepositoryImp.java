package kr.groupware.model.winNumber;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LSH on 2017-07-18.
 */
@Repository
public class WinNumberRepositoryImp extends SqlSessionDaoSupport implements WinNumberRepository{

    /**
     * 데이터 베이스에서 당첨번호 목록을 가져온다
     * @return 당첨번호 목록
     */
    @Override
    public List<WinNumberData>getWinNumbers(){
        return getSqlSession().selectList("getWinNumbers");
    }

    /**
     * 회차에 해당하는 당첨번호를 가져온다
     * @param times 회차
     * @return
     */
    @Override
    public WinNumberData getWinNumber(int times){
        return getSqlSession().selectOne("getWinNumber",times);
    }

    /**
     * 당첨번호를 데이터 베이스에 저장한다
     * @param winNumberData 당첨번호
     */
    @Override
    public void setWinNumber(WinNumberData winNumberData){
        getSqlSession().insert("setWinNumber",winNumberData);
    }

}
