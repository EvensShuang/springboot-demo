package com.shuang.learn.design;

/**
 * 饿汉模式 是线程安全的
 */
public class 单例模式 {
    private static final 单例模式 a=new 单例模式();
    private 单例模式(){}
    public static 单例模式 getInstance(){
       return a;
    }
}
