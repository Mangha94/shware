package kr.groupware.model.number;

import lombok.Data;

import java.util.Date;

@Data
public class NumberData {

    private int no;
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private int num6;
    private int rank;
    private int times;
    private Date pickDate;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getNum5() {
        return num5;
    }

    public void setNum5(int num5) {
        this.num5 = num5;
    }

    public int getNum6() {
        return num6;
    }

    public void setNum6(int num6) {
        this.num6 = num6;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Date getPickDate() {
        return pickDate;
    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    public int getNum(int idx)
    {
        if (idx == 1)
            return num1;
        else if (idx == 2)
            return num2;
        else if (idx == 3)
            return num3;
        else if (idx == 4)
            return num4;
        else if (idx == 5)
            return num5;
        else if (idx == 6)
            return num6;
        else
            return 0;
    }

    public void setNum(int idx,int no)
    {
        if (idx == 1)
            num1=no;
        else if (idx == 2)
            num2=no;
        else if (idx == 3)
            num3=no;
        else if (idx == 4)
            num4=no;
        else if (idx == 5)
            num5=no;
        else if (idx == 6)
            num6=no;
    }

    public boolean checkNum (int num)
    {
        for (int j = 0; j <= 5; j++) {
            if (getNum(j + 1) == num) {
                return true;
            }
        }

        return false;
    }
}
