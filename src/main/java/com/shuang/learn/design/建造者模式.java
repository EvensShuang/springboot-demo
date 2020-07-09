package com.shuang.learn.design;

public class 建造者模式 {
    public static void main(String[] args) {
        Builder builder = new BusCar();
        Manager manager = new Manager(builder);
        Car parlour = manager.decorate();
        parlour.show();
    }
}

// 轿车
class Car{
    private String wheel;
    private String engine;
    private String glass;
    public void show(){
        System.out.println("展示轿车的组成....");
        System.out.println(wheel);
        System.out.println(engine);
        System.out.println(glass);
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }
}

// 抽象的建造者
abstract class Builder{
    public Car car =new Car();
    //构建组件
    public abstract void buildWheel();

    //构建组件
    public abstract void buildEngine();

    //构建组件
    public abstract void buildGlass();

    // 获取结果
    public Car getResult(){
        return car;
    }
}

// 具体的建造者
class BusCar extends Builder {

    private String des = "建造者Bus,开始构建";


    @Override
    public void buildWheel() {
        System.out.println(des +"Wheel");
        car.setWheel("Bus-Wheel");
    }

    @Override
    public void buildEngine() {
        System.out.println(des +"Engine");
        car.setEngine("Bus-Engine");
    }

    @Override
    public void buildGlass() {
        System.out.println(des +"Glass");
        car.setGlass("Bus-Glass");
    }
}

// 具体的建造者
class TruckCar extends Builder {

    private String des = "建造者Truck,开始构建";


    @Override
    public void buildWheel() {
        System.out.println(des +"Wheel");
        car.setWheel("Truck-Wheel");
    }

    @Override
    public void buildEngine() {
        System.out.println(des +"Engine");
        car.setEngine("Truck-Engine");
    }

    @Override
    public void buildGlass() {
        System.out.println(des +"Glass");
        car.setGlass("Truck-Glass");
    }
}

class Manager{
    private Builder builder;

    public Manager(Builder builder) {
        this.builder = builder;
    }

    public Car decorate(){
        builder.buildWheel();
        builder.buildEngine();
        builder.buildGlass();
        return builder.getResult();
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
}
