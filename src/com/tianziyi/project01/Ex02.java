package com.tianziyi.project01;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        int a[]={12,34,9,-23,45,6,90,123,19,45,34};
        Arrays.sort(a);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int n = scanner.nextInt();
        int begin = 0;
        int end = a.length;
        boolean flag = false;
        while(true) {
            if(begin == end-1) {
                break;
            }else if (a[(begin + end)/ 2] == n) {
                System.out.println("查找结束，位置在" + (begin + end)/ 2);
                flag = true;
                break;
            } else if (a[(begin + end)/ 2] < n) {
                begin = (begin + end)/ 2;
            } else {
                end = (begin + end)/ 2;
            }
        }
        if(!flag) System.out.println("未找到该数");
    }
}
