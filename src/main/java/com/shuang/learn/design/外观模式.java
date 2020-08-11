package com.shuang.learn.design;

/**
 * 外观模式结构比较简单，主要定义了一个高层的接口。它包含了对各个子系统的引用，客户端可以通过它访问各个子系统的功能。
 */
public class 外观模式 {
    public static void main(String[] args) {
        AbstractFacade facade = new Facade2();
        facade.method1();
    }
}
//抽象外观角色 - 为了不违背开闭原则，增加抽象外观角色
abstract class AbstractFacade {
    public abstract void method1();
    public abstract void method2();
}
//具体外观角色
class Facade1 extends AbstractFacade {
    private System01 system01 = new System01();
    private System02 system02 = new System02();
    private System03 system03 = new System03();
    @Override
    public void method1() {
        // TODO Auto-generated method stub
        system01.run();
        system02.run();
    }

    @Override
    public void method2() {
        // TODO Auto-generated method stub
        system02.run();
        system03.run();
    }
}

// 具体外观角色
class Facade2 extends AbstractFacade {
    private System01 system01 = new System01();
    private System02 system02 = new System02();
    private System03 system03 = new System03();
    @Override
    public void method1() {
        // TODO Auto-generated method stub
        system01.run();
        system02.run();
        system03.run();
    }

    @Override
    public void method2() {
        // TODO Auto-generated method stub
        system03.run();
    }

}

// 子系统 01
 class System01 {
    public void run(){
        System.out.println("子系统_01被调用...");
    }
}

//子系统 02
 class System02 {
    public void run(){
        System.out.println("子系统_02被调用...");
    }
}
//子系统 03
 class System03 {
    public void run(){
        System.out.println("子系统_03被调用...");
    }
}
