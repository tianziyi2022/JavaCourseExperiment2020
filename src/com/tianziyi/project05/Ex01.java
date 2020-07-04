package com.tianziyi.project05;

import static java.lang.Thread.sleep;

class NumberThread extends Thread{
    private int first;
    public NumberThread(String name, int first) {
        super(name);
        this.first = first;
    }
    public void run(){
        System.out.println("\n"+this.getName()+": ");
        for(int i=first;i<50;i+=2){
            System.out.print(i+" ");
        }
        System.out.println("\n"+this.getName()+" ends.");
    }
}

public class Ex01{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("currentThread="+Thread.currentThread().getName());
        NumberThread thread_odd = new NumberThread("odd",1);
        NumberThread thread_even = new NumberThread("even",2);
        thread_odd.start();
        thread_even.start();
        System.out.println("activeCount="+Thread.activeCount());
    }
}
