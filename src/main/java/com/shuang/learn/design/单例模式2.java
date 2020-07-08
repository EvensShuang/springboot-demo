package com.shuang.learn.design;

/**
 * 懒汉模式
 */
public class 单例模式2 {
    private volatile static 单例模式2 a=null;
    private 单例模式2(){}
    public static synchronized 单例模式2 getInstance(){
        if(a==null){
            a=new 单例模式2();
        }
        return a;
    }
}
