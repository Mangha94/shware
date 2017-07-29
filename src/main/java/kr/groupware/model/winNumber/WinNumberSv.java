package kr.groupware.model.winNumber;

import java.util.List;

public interface WinNumberSv {
    /**
     * 당첨번호 리스트를 가져온다
     * @return 당첨번호 리스트
     */
    List<WinNumberData>getWinNumbers();

    /**
     * 회차에 해당하는 당첨번호를 가져온다
     * @param times 회차
     * @return 회차에 해당하는 당첨번호
     */
    WinNumberData getWinNumber(int times);

    /**
     * 당첨번호를 입력한다
     */
    void setWinNumber(WinNumberData winNumberData);

}
