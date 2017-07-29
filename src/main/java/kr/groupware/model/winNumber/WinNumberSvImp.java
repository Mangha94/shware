package kr.groupware.model.winNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WinNumberSvImp implements WinNumberSv {
    @Autowired
    private WinNumberRepository winNumberRepository;

    /**
     * 당첨 번호 목록을 가져온다
     * @return 당첨 번호 목록
     */
    @Override
    public List<WinNumberData>getWinNumbers(){
        return winNumberRepository.getWinNumbers();
    }

    /**
     * 회차에 해당하는 당첨번호를 가져온다
     * @param times 회차
     * @return 당첨번호
     */
    @Override
    public WinNumberData getWinNumber(int times){
        return winNumberRepository.getWinNumber(times);
    }

    /**
     * 당첨번호를 입력한다
     * @param winNumberData 당첨번호
     */
    @Override
    public void setWinNumber(WinNumberData winNumberData){
        winNumberRepository.setWinNumber(winNumberData);
    }
}
