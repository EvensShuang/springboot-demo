package com.shuang.learn.design;

import java.util.HashMap;
import java.util.Map;

public class 享元模式 {
    public static void main(String[] args) {
        JianZhuFactory factory = new JianZhuFactory();
        for(int i = 0 ; i < 10 ; i++){
            //自始至终总共有10个数据，但是只创建了一个共享对象
            TiYuGuan tiyuguan = factory.getTyg("足球");
            tiyuguan.setName("中国体育馆");
            tiyuguan.setShape("圆形");
            tiyuguan.use();
            System.out.println(factory.getSize());
        }

    }
}
//抽象享元角色 - 建筑
interface JianZhu {
    public void use();
}
//具体享元角色 - 体育场
class TiYuGuan implements JianZhu{
    private String name;
    private String shape;
    private String yundong;

    public TiYuGuan(String yundong) {
        super();
        this.yundong = yundong;
    }
    @Override
    public void use() {
        // TODO Auto-generated method stub
        System.out.println("体育馆被使用来召开运动:("+yundong +")体育场形状为:("+shape+")运动名称为("+name+")");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShape() {
        return shape;
    }
    public void setShape(String shape) {
        this.shape = shape;
    }
    public String getYundong() {
        return yundong;
    }
    public void setYundong(String yundong) {
        this.yundong = yundong;
    }
}

//角色工厂
class JianZhuFactory {
    private static final Map<String,TiYuGuan> factory = new HashMap<String, TiYuGuan>();
    public static TiYuGuan getTyg(String yundong){
        TiYuGuan tyg = factory.get(yundong);
        if(null == tyg){
            tyg = new TiYuGuan(yundong);
            factory.put(yundong, tyg);
        }
        return tyg;
    }

    public static int getSize(){
        return factory.size();
    }
}
