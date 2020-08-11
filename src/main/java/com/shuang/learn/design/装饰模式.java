package com.shuang.learn.design;

/**
 * 分析：在《恶魔战士》中，游戏角色“莫莉卡·安斯兰”的原身是一个可爱少女，
 * 但当她变身时，会变成头顶及背部延伸出蝙蝠状飞翼的女妖，
 * 当然她还可以变为穿着漂亮外衣的少女。这些都可用装饰模式来实现，在本实例中的“莫莉卡”原身有 setImage(String t) 方法决定其显示方式，而其 变身“蝙蝠状女妖”和“着装少女”可以用 setChanger() 方法来改变其外观，原身与变身后的效果用 display() 方法来
 *
 * 抽象构件角色：莫莉卡·安斯兰
 * 具体构件角色：原身
 * 抽象装饰角色：变形
 * 具体装饰角色：女妖
 */
public class 装饰模式 {
    public static void main(String[] args) {
        Morrigan morrigan = new Original();
        morrigan.display();
        System.out.println("--------开始进行装饰------------");

        Change change = new Girl(morrigan);
        change.display();

    }
}

//抽象构件角色：morrigan
interface Morrigan {
    public void display();
}

//具体装饰角色：原身
class Original implements Morrigan{
    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("莫丽卡原身...");
    }
    public Original() {
        System.out.println("莫丽卡初始化原身...");
    }
}
// 抽象装饰角色：change
class Change implements Morrigan{
    private Morrigan morrigan;
    @Override
    public void display() {
        // TODO Auto-generated method stub
        morrigan.display();
    }
    public Change(Morrigan morrigan) {
        this.morrigan = morrigan;
    }
    public Morrigan getMorrigan() {
        return morrigan;
    }
    public void setMorrigan(Morrigan morrigan) {
        this.morrigan = morrigan;
    }
}

class Girl extends Change{
    public Girl(Morrigan morrigan) {
        super(morrigan);
    }
    @Override
    public void display() {
        // TODO Auto-generated method stub
        super.display();
        setChange();
    }
    //为具体的构建添加一些责任
    public void setChange(){
        System.out.println("你是一个漂亮的美女");
    }
}

