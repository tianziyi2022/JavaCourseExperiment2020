package com.tianziyi.project01;

public class Ex04 {

    public static void main(String[] args) {
        for(int i = 1 ; i<1000 ; i++ ){
            if(myFun(i)) System.out.print(i+" ");
        }
    }

    public static boolean myFun(Integer n) {
        int sum=0;
        for(int i = 1 ; i < n ; i++ ){
            if (n%i==0) {
                sum+=i;
            }
        }
        if(sum==n) return true;
        else return false;
    }
}
