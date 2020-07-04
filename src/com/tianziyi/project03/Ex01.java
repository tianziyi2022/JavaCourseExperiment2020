package com.tianziyi.project03;

public class Ex01 {
    public static void main(String[] args) {
        int i=0;
        String greeting[]={"Hello","Only","Teat"};
        while(i<4){
            try{
                System.out.println(greeting[i]);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("数组越界！");
            }finally{
                System.out.println("输出结束！");
            }
            i++;
        }
    }
}
