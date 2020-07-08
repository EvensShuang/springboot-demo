package com.shuang.learn.design;

/**
 * 原型模式
 */
public class 原型模式浅克隆 implements Cloneable{
    private String name = "";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public 爱好 getA() {
        return a;
    }

    public void setA(爱好 a) {
        this.a = a;
    }

    private 爱好 a;

    public 原型模式浅克隆(String name, 爱好 a) {
        this.name = name;
        this.a = a;
    }

    public void display() {
        System.out.println(name + a.getName());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (原型模式浅克隆)super.clone();
    }
}

 class 爱好 {
    private String name = "";

    public String getName() {
        return name;
    }

     public void setName(String name) {
         this.name = name;
     }

     public 爱好(String name) {
        this.name = name;
    }
}

 class Main{
     public static void main(String[] args) throws CloneNotSupportedException {
         爱好 a=new 爱好("打球");
         原型模式浅克隆 b=new 原型模式浅克隆("张爽",a);
         b.display();
         原型模式浅克隆 citation2 = (原型模式浅克隆)b.clone();
         citation2.setName("李四");
         //克隆完成之后，重新设置address为shanghai,发现张三的地址也变了，也就是指向的元素地址是指向的原来张三的地址，也就是引用对象还是用的原来的地址
         citation2.getA().setName("嫖娼");
         citation2.display();
         b.display();
     }
}



