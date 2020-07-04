package com.tianziyi.project03;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try{
            if(input.equals("XYZ")) throw new Exception();
        }catch(Exception e){
            System.out.println("This is a XYZ");
        }
    }
}
