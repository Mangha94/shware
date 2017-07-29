package kr.groupware.model.number;

import java.util.List;
import java.util.Map;

/**
 * Created by LSH on 2017-07-18.
 */
public interface NumberRepository {

    /**
     * 뽑은 번호 목록을 가져온다
     * @return 번호 목록 리스트
     */
    List<NumberData>getNumbers();

    /**
     * 회차에 해당하는 뽑은 번호 목록을 가져온다
     * @param times 회차
     * @return 회차에 해당하는 뽑은 번호 목록
     */
    List<NumberData>getNumber_times(int times);

    /**
     * 랜덤한 번호 6개를 뽑아 리스트에 저장
     */
    void pickNumbers(NumberData numberData);

    /**
     * 가장 최근 회차를 구한다
     * @return 최근 회차
     */
    int getMaxTimes();

    List<NumberData>showPickNumber();

    /**
     * 회차에 해당하는 번호들을 조회하여 해당 회차 당첨번호와 비교하여
     * 등수를 매긴다
     * @param numberData 등수가 입력된 데이터
     */
    void setRank(Map<String, Object> numberData);
}
