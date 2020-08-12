package com.shuang.learn.design;

public class 策略模式 {
    public static void main(String[] args) {
        Strategy strategy = new JuTiStrategyA();
        Context context = new Context();
        context.setStrategy(strategy);
        context.strategyMethod();

        Strategy b = new JuTiStrategyB();
        context.setStrategy(b);
        context.strategyMethod();
    }
}
// 抽象类 - 抽象策略类
 interface Strategy {
    //策略方法
    public void strategyMethod();
}
//具体策略类- A
class JuTiStrategyA implements Strategy{
    @Override
    public void strategyMethod() {
        // TODO Auto-generated method stub
        System.out.println("具体策略A的策略方法被访问！");
    }
}

class JuTiStrategyB implements Strategy{
    @Override
    public void strategyMethod() {
        // TODO Auto-generated method stub
        System.out.println("具体策略B的策略方法被访问！");
    }
}

class Context implements Strategy{

    public Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }

    @Override
    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
