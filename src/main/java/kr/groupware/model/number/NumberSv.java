package kr.groupware.model.number;

import java.util.List;

/**
 * Created by LSH on 2017-07-18.
 */
public interface NumberSv {
    /**
     * 뽑은 번호 목록을 가져온다
     * @return 번호 목록 리스트
     */
    List<NumberData> getNumbers(String memberId);

    /**
     * 해당 회차에 해당하는 뽑은 번호 목록을 가져온다
     * @param times 회차
     * @return 해당 회차에 해당하는 뽑은 번호 목록
     */
    List<NumberData>getNumber_times(int times);
    /**
     * 랜덤한 번호 6개 +  랜덤한 보너스 번호 1개를 뽑아 리스트에 저장
     */
    NumberData pickNumbers(String memberId);

    /**
     * 당첨번호를 조회하여 해당 회차에 뽑은 번호들의 등수를 매긴다
     * @param times 회차에 해당하는 번호
     */
    void setRank(int times);

    List<NumberData> showPickNumber(String memberId);
}
