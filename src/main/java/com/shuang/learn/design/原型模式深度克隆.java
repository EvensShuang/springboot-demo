package com.shuang.learn.design;

public class 原型模式深度克隆 implements Cloneable{
    private String name = "";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public 爱好1 getA() {
        return a;
    }

    public void setA(爱好1 a) {
        this.a = a;
    }

    private 爱好1 a;

    public 原型模式深度克隆(String name, 爱好1 a) {
        super();
        this.name = name;
        this.a = a;
    }

    public void display() {
        System.out.println(name + a.getName());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        原型模式深度克隆 b= (原型模式深度克隆)super.clone();
        b.a=(爱好1)this.a.clone();
        return b;
    }
}

class 爱好1 implements Cloneable{
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public 爱好1(String name) {
        super();
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (爱好1)super.clone();
    }
}

class Main1{
    public static void main(String[] args) throws CloneNotSupportedException {
        爱好1 a=new 爱好1("打球");
        原型模式深度克隆 b=new 原型模式深度克隆("张爽",a);
        b.display();
        原型模式深度克隆 citation2 = (原型模式深度克隆)b.clone();
        citation2.setName("李四");
        //克隆完成之后，重新设置address为shanghai,发现张三的地址也变了，也就是指向的元素地址是指向的原来张三的地址，也就是引用对象还是用的原来的地址
        citation2.getA().setName("嫖娼");
        citation2.display();
        b.display();
    }
}
