package com.tianziyi.project02.Ex05.Mypackage;

import com.tianziyi.project02.Ex05.Mypackage.Test_YMD;

public class YMD_2 {
    private String name;
    private Test_YMD birth;

    public YMD_2(String name,int year,int month,int day) {
        this.name = name;
        this.birth = new Test_YMD(year,month,day);
    }

    public int getAge(){
        return Test_YMD.thisYear()-birth.getYear();
    }
    public void output(){
        System.out.println("姓名："+this.name);
        System.out.println("出生日期："+birth.toString());
        System.out.println("现在年龄："+getAge());
    }

    public static void main(String[] args) {
        YMD_2 a = new YMD_2("田梓毅",2000,7,12);
        a.output();
    }

}
