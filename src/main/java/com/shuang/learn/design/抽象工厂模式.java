package com.shuang.learn.design;

//车工厂 （轿车，卡车） 抽象产品（轮子 发动机） 具体产品（轿车轮子 卡车轮子 轿车发动机 卡车发动机）

public class 抽象工厂模式 {
    public static void main(String[] args) {
        Factory1  factory= new TruckFactory1();
        factory.wheel().createWheel();
        factory.engine().createEngine();
        Factory1  carFactory= new CarFactory1();
        carFactory.wheel().createWheel();
        carFactory.engine().createEngine();
    }
}


//具体工厂
class TruckFactory1 implements Factory1{

    @Override
    public Wheel1 wheel() {
        return new TruckWheel1();
    }

    @Override
    public Engine1 engine() {
        return new TruckEngine1();
    }
}

//具体工厂
class CarFactory1 implements Factory1{

    @Override
    public Wheel1 wheel() {
        return new CarWheel1();
    }

    @Override
    public Engine1 engine() {
        return new CarEngine1();
    }
}

//抽象工厂
interface Factory1{
    Wheel1 wheel();
    Engine1 engine();
}

//抽象产品
interface  Wheel1{
    void createWheel();
}

interface Engine1{
    void createEngine();
}

//具体产品
class CarEngine1 implements Engine1{

    @Override
    public void createEngine() {
        System.out.println("开始建轿车发动机");
    }
}

//具体产品
class TruckWheel1 implements Wheel1{
    @Override
    public void createWheel() {
        System.out.println("开始建卡车车轮");
    }
}

//具体产品
class TruckEngine1 implements Engine1{

    @Override
    public void createEngine() {
        System.out.println("开始建卡车发动机");
    }
}

//具体产品
class CarWheel1 implements Wheel1{
    @Override
    public void createWheel() {
        System.out.println("开始建轿车车轮");
    }
}

