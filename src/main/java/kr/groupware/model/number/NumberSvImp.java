package kr.groupware.model.number;

import kr.groupware.model.winNumber.WinNumberData;
import kr.groupware.model.winNumber.WinNumberSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by LSH on 2017-07-18.
 */
@Service
public class NumberSvImp implements NumberSv {
    @Autowired
    private NumberRepository numberRepository;
    @Autowired
    private WinNumberSv winNumberSv;

    /**
     * 뽑은 목록들을 가져온다
     * @return 6개의 숫자와 보너스 숫자 1개의 리스트
     */
    @Override
    public List<NumberData>getNumbers(String memberId){
        return numberRepository.getNumbers(memberId);
    }

    /**
     * 회차에 해당하는 뽑은 목록을 가져온다
     * @param times 회차
     * @return 회차에 해당하는 뽑은 목록
     */
    @Override
    public List<NumberData>getNumber_times(int times){
        return numberRepository.getNumber_times(times);
    }

    /**
     * 랜덤한 6개의 숫자와 보너스 숫자 1개를 구한다
     */
    @Override
    public NumberData pickNumbers(String memberId){
        NumberData numberData=new NumberData();
        int[]num=new int[6];
        Random randomNum=new Random();

        for(int i=0;i<=5;i++){
            num[i]=randomNum.nextInt(61)+1;
            for(int j=0;j<i;j++){
                if(num[i]==num[j] || num[i]==0){
                    i--;
                }
            }
        }
        Arrays.sort(num);

        numberData.setNum1(num[0]);
        numberData.setNum2(num[1]);
        numberData.setNum3(num[2]);
        numberData.setNum4(num[3]);
        numberData.setNum5(num[4]);
        numberData.setNum6(num[5]);
        numberData.setPickDate(new Date());
        numberData.setRank(0);

        int times=765;
        LocalDateTime firstTime=LocalDateTime.of(2017,7,22,20,00);
        LocalDateTime pickTime=LocalDateTime.now();
        long weekDf=ChronoUnit.WEEKS.between(firstTime,pickTime);
        if(weekDf>=1){
            times=times+(int)weekDf;
        }
        numberData.setTimes(times);

        numberData.setMemberId(memberId);

        numberRepository.pickNumbers(numberData);

        return numberData;
    }

    @Override
    public List<NumberData>showPickNumber(String memberId){
        return numberRepository.showPickNumber(memberId);
    }


    /**
     * 회차에 해당하는 번호들을 조회하여 해당 회차 당첨번호와 비교하여
     * 등수를 매긴다
     * @param times 회차
     */
    @Override
    public void setRank(int times){

        WinNumberData winNumberData=winNumberSv.getWinNumber(times);
        int[]winNumber=winNumberData.getNumArr();
        List<NumberData> numberData=getNumber_times(times);

        NumberSetRankData numberSetRankData=new NumberSetRankData();

        for(NumberData number : numberData){
            int count;
            boolean bonusChk=false;
//            System.out.println(number);
//            for (int i : winNumber)
//            {
//                if (number.checkNum(winNumber[i]))
//                    count++;
//            }

            count = (int) Arrays.stream (winNumber).filter(number::checkNum).count();

            if(count==5 && number.checkNum(winNumberData.getBonusNum())){
                bonusChk = true;
            }

            numberSetRankData.setRank (calcRank(count, bonusChk));
            numberSetRankData.setNo(number.getNo());

            numberRepository.setRank(numberSetRankData.makeMap());
        }

    }

    private int calcRank(int count, boolean bonusChk) {
        if(count==6){
            return 1;
        }
        else if(count==5 && bonusChk){
            return 2;
        }
        else if(count==5){
            return 3;
        }
        else if(count==4){
            return 4;
        }
        else if(count==3){
            return 5;
        }
        else{
            return 0;
        }
    }
}
