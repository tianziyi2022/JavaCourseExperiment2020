package com.tianziyi.project02;

import static java.lang.Math.pow;

interface Shape{
    abstract Double getArea();
    abstract Double getPerimeter();
}

class Coordinates{
    long x;
    long y;
    Coordinates(long x, long y) {
        this.x=x;
        this.y=y;
    }
}

class Rectangle extends Coordinates implements Shape{

    Double a;
    Double b;

    Rectangle(long x, long y) {
        super(x, y);
    }

    @Override
    public Double getArea() {
        return a*b;
    }

    @Override
    public Double getPerimeter() {
        return 2*(a+b);
    }
}

class Circle extends Coordinates implements Shape{

    Double r;

    Circle(long x, long y) {
        super(x, y);
    }

    @Override
    public Double getArea() {
        return Math.PI*r*r;
    }

    @Override
    public Double getPerimeter() {
        return 2*Math.PI*r;
    }
}

class Triangle extends Coordinates implements Shape{

    Double a;
    Double b;
    Double c;

    Triangle(long x, long y) {
        super(x, y);
    }

    @Override
    public Double getArea() {
        double p=(a+b+c)/2;
        return pow(p*(p-a)*(p-b)*(p-c),0.5);
    }

    @Override
    public Double getPerimeter() {
        return a+b+c;
    }
}

public class Ex04 {
}
