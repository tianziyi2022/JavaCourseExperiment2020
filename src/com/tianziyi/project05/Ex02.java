package com.tianziyi.project05;

class Tortoise extends Thread{
    int sleepTime=0, liveLength=0;
    public Tortoise(String name,int sleepTime, int liveLength){
        this.sleepTime=sleepTime;
        this.liveLength=liveLength;
        this.setName(name);
    }
    public void run(){
        while (true){
            liveLength--;
            System.out.println("@_@");
            try{
                sleep(sleepTime);// 让线程调用sleep()方法进入中断状态
            }
            catch (InterruptedException e) {}
            if (liveLength<=0){
                System.out.println(getName()+"进入死亡状态\n");
	                return;// 结束run()方法的语句
            }
        }
    }
}
class Rabit extends Thread{
    int sleepTime=0, liveLength=0;
    public Rabit(String name,int sleepTime, int liveLength){
        super(name);// 调用父类构造函数，设置线程的名字为name
        this.sleepTime=sleepTime;
        this.liveLength=liveLength;
    }

    public void run()
    {
        while (true )
        {
            liveLength--;
            System.out.println("*_*");
            try{
                sleep( sleepTime);
            }
            catch (InterruptedException e) {}
            if (liveLength<=0 )
            {
                System.out.println(getName()+"进入死亡状态\n");
                break;
            }
        }
    }
}

public class Ex02 {
    public static void main(String a[])
    {
        Rabit rabit;
        rabit = new Rabit("rabit",4,10);  // 新建线程rabit
        Tortoise tortoise = new Tortoise("tortoise",6,10);  // 新建线程tortoise
        rabit.run();// 启动线程tortoise
        tortoise.run();// 启动线程rabit
    }
}