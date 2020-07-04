package com.tianziyi.project02;

class Vehicle{
    int wheels;
    double weight;

    public int getWheels() {
        return wheels;
    }

    public double getWeight() {
        return weight;
    }
}

class Car extends Vehicle{
    int loader;

    public int getLoader() {
        return loader;
    }
}

class Truck extends Vehicle{
    double payload;

    public double getPayload() {
        return payload;
    }
}

public class Ex03 {
}
