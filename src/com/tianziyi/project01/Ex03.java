package com.tianziyi.project01;

public class Ex03 {
    public static void main(String[] args) {
        for(int i = 100 ; i<200 ; i++ ){
            if(myFun(i)) System.out.print(i+" ");
        }
    }

    public static boolean myFun(Integer n) {
        for(int i = 2 ; i * i < n ; i++ ){
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
