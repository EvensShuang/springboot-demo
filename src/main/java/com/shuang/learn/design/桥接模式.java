package com.shuang.learn.design;

/**
 * 分析：女士皮包有很多种，可以按用途分、按皮质分、按品牌分、按颜色分、按大小分等，存在多个维度的变化，所以采用桥接模式来实现女士皮包的选购比较合适
 * 颜色类：Color是一个维度，定义为实现化角色，它有两个具体实现化角色：黄色和红色，通过 getColor() 方法可以选择颜色
 * 包类：是另一个维度，定义为抽象化角色，它有两个扩展抽象化角色：挎包和钱包，它包含了颜色类对象，通过 getName() 方法可以选择相关颜色的挎包和钱包
 */
public class 桥接模式 {
        public static void main(String[] args) {
            Color color = new RedColor();
            Bag bag = new HandBag();
            bag.setColor(color);
            System.out.println(bag.getName());
            System.out.println(bag.getColor().getColor());
        }
}

interface Color{
    public String getColor();
}

class RedColor implements Color {
    @Override
    public String getColor() {
        // TODO Auto-generated method stub
        String color = "具体实现化角色：red";
        return color;
    }
}

class YellowColor implements Color {
    @Override
    public String getColor() {
        // TODO Auto-generated method stub
        String color = "具体实现化角色：yellow";
        return color;
    }
}

abstract class Bag {
    private Color color;

    public abstract String getName();

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

class HandBag extends Bag {
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        String bag = "手包";
        return bag;
    }
}

class WalletBag extends Bag {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        String bag = "钱包";
        return bag;
    }

}