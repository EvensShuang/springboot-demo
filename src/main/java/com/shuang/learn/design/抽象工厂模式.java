package com.shuang.learn.design;

//车工厂 （轿车，卡车） 抽象产品（轮子 发动机） 具体产品（轿车轮子 卡车轮子 轿车发动机 卡车发动机）

public class 抽象工厂模式 {
    public static void main(String[] args) {
        Factory  factory= new TruckFactory();
        factory.wheel().createWheel();
        factory.engine().createEngine();
        Factory  carFactory= new CarFactory();
        carFactory.wheel().createWheel();
        carFactory.engine().createEngine();
    }
}


//具体工厂
class TruckFactory implements Factory{

    @Override
    public Wheel wheel() {
        return new TruckWheel();
    }

    @Override
    public Engine engine() {
        return new TruckEngine();
    }
}

//具体工厂
class CarFactory implements Factory{

    @Override
    public Wheel wheel() {
        return new CarWheel();
    }

    @Override
    public Engine engine() {
        return new CarEngine();
    }
}

//抽象工厂
interface Factory{
    Wheel wheel();
    Engine engine();
}

//抽象产品
interface  Wheel{
    void createWheel();
}

interface Engine{
    void createEngine();
}

//具体产品
class CarEngine implements Engine{

    @Override
    public void createEngine() {
        System.out.println("开始建轿车发动机");
    }
}

//具体产品
class TruckWheel implements Wheel{
    @Override
    public void createWheel() {
        System.out.println("开始建卡车车轮");
    }
}

//具体产品
class TruckEngine implements Engine{

    @Override
    public void createEngine() {
        System.out.println("开始建卡车发动机");
    }
}

//具体产品
class CarWheel implements Wheel{
    @Override
    public void createWheel() {
        System.out.println("开始建轿车车轮");
    }
}

