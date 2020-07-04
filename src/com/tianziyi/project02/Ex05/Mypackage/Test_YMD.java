package com.tianziyi.project02.Ex05.Mypackage;

import java.util.Calendar;

public class Test_YMD {
    private int year,month,day;

    public static void main(String[] args) {}

    public Test_YMD(int year, int month, int day) {
        this.year = year;
        this.month = ((month>0)&&(month<13))?month:1;
        this.day = ((day>0)&&(day<32))?day:1;
    }

    public Test_YMD() {
    }

    public static int thisYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public int getYear(){
        return this.year;
    }

    public String toString(){
        return year+"-"+month+"-"+day;
    }

}
