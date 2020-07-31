package com.shuang.learn.design;

public class 代理模式 {
    public static void main(String[] args) {
        CNProxy proxy = new CNProxy();
        proxy.sell();
    }
}

interface SellCar{
    public void sell();
}

class SellCarB implements SellCar{

    @Override
    public void sell() {
        System.out.println("访问卖奔驰车的方法...");
    }
}

//中国大区代理
 class CNProxy implements SellCar{

    private SellCarB sellCarB;
    @Override
    public void sell() {
        if(sellCarB == null){
            sellCarB = new SellCarB();
        }
        addMoney();
        //利用代理类，卖奔驰
        sellCarB.sell();
        afterSell();

    }

    //扩展
    public void addMoney(){
        System.out.println("加价1000$");
    }

    //扩展
    public void afterSell(){
        System.out.println("卖出去之后开始漏油...");
    }

}

