package com.shuang.learn.design;

public interface 工厂模式 {
    void show();
}

interface Factory {
    public 工厂模式 createCar();
}


class CarFactory implements Factory {

    @Override
    public 工厂模式 createCar() {
        System.out.println("进入轿车模式");
        return new Car();
    }
}

class BusFactory implements Factory {

    @Override
    public 工厂模式 createCar() {
        System.out.println("进入大卡车模式");
        return new Bus();
    }
}

class Car implements 工厂模式 {
    @Override
    public void show() {
        System.out.println("小轿车");
    }
}

class Bus implements 工厂模式 {
    @Override
    public void show() {
        System.out.println("大卡车");
    }
}

class Main2 {
    public static void main(String[] args) {
        Factory a = null;
        工厂模式 b = null;
        a = new CarFactory();
        b = a.createCar();
        b.show();

        a = new BusFactory();
        b = a.createCar();
        b.show();
    }
}


