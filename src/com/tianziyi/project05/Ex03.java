package com.tianziyi.project05;

class Function extends Thread{
    int ticket;
    int twenty;
    int ten;
    int five;

    public Function(String name, int ticket, int twenty, int ten ,int five) {
        super(name);
        this.ticket = ticket;
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
    }

    public void run(){
        int payment = twenty*20+ten*10+five*5;
        int price = ticket*5;
        if(payment<price){
            System.out.println(this.getName()+": 付款不足");
        }else if(payment==price) {
            System.out.println(this.getName()+": 无需找零");
        }else if(twenty==1&&ten==0&&ticket==1){
            System.out.println(this.getName()+": 找零一张10元，一张5元。");
        }else if(twenty==1&&ten==0&&ticket==2){
            System.out.println(this.getName()+": 找零一张10元。");
        }else if(twenty==1&&ten==0&&ticket==3){
            System.out.println(this.getName()+": 找零一张5元。");
        }else if(twenty==0&&ten==1&&ticket==1){
            System.out.println(this.getName()+": 找零一张5元。");
        }
    }
}

public class Ex03 {
    public static void main(String[] args) {
        Function function1=new Function("赵",2,1,0,0);
        Function function2=new Function("钱",1,1,0,0);
        Function function3=new Function("孙",1,0,1,0);
        Function function4=new Function("李",2,0,1,0);
        Function function5=new Function("周",1,0,0,1);
        function1.run();
        function2.run();
        function3.run();
        function4.run();
        function5.run();
    }
}
