package com.tianziyi.project02;

import java.util.Scanner;

class MyDate {
    int year,month,day;

    public MyDate(int year, int month, int day) {
        try {
            if (!isValid(year, month, day)) throw new Exception();
            this.year = year;
            this.month = month;
            this.day = day;
            System.out.print("Construct Success!");
        }catch(Exception e) {
            System.out.print("您的输入有误，该日期不存在！");
        }
    }

    static boolean myFun1(int year){
        if( year%100==0 || year%400!=0 ) return false;
        else if( year%4==0 ) return true;
        else return false;
    }

    static boolean isValid(int year,int month,int day) {
        switch (month) {
            case (1):
            case (3):
            case (5):
            case (7):
            case (8):
            case (10):
            case (12):
                if (day > 0 && day < 32) return true;
                else return false;
            case (4):
            case (6):
            case (9):
            case (11):
                if (day > 0 && day < 31) return true;
                else return false;
            case (2):
                if (day > 0 && !myFun1(year) && day < 29) return true;
                else if (day > 0 && myFun1(year) && day < 30) return true;
                else return false;
        }
        return false;
    }

}

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = scanner.nextInt();
        System.out.print("请输入月份：");
        int month = scanner.nextInt();
        System.out.print("请输入日期：");
        int day = scanner.nextInt();
        MyDate myDate = new MyDate(year,month,day);
    }
}
