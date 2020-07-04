package com.tianziyi.project03;

interface Average{
    abstract Double getAverage();
}

class Average1 implements Average{
    double[] a;
    public Average1(double[] a) {
        this.a = a;
    }
    @Override
    public Double getAverage() {
        Double sum=0.0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        Double aver=sum/a.length;
        return aver;
    }
}

class Average2 implements Average{
    double[] a;
    public Average2(double[] a) {
        this.a = a;
    }
    @Override
    public Double getAverage() {
        Double sum=0.0;
        Double max=Double.MIN_VALUE;
        Double min=Double.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(max<a[i]) max=a[i];
            if(min>a[i]) min=a[i];
        }
        sum-=max;
        sum-=min;
        Double aver=sum/(a.length-2);
        return aver;
    }
}

public class Ex03 {
    public static void main(String[] args) {
        double[] a= new double[]{82.8, 70.5, 32, 65, 65.2, 98.3, 99.6, 100};
        Average1 average1 = new Average1(a);
        Average2 average2 = new Average2(a);
        System.out.println(average1.getAverage());
        System.out.println(average2.getAverage());
    }
}
