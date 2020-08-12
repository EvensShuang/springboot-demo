package com.shuang.learn.design;

import java.util.ArrayList;
import java.util.List;

public class 透明式组合模式 {
}
//抽象构件角色
 interface Compent {
    public void add(Compent c);
    public void remove(Compent c);
    public Compent getChild(int i);
    public void operation();
}
// 树枝组建角色
class Branch implements Compent{
    private List<Compent> children = new ArrayList<Compent>();
    @Override
    public void add(Compent c) {
        // TODO Auto-generated method stub
        children.add(c);
    }
    @Override
    public void remove(Compent c) {
        // TODO Auto-generated method stub
        children.remove(c);
    }
    @Override
    public Compent getChild(int i) {
        // TODO Auto-generated method stub
        return children.get(i);
    }
    @Override
    public void operation() {
        // TODO Auto-generated method stub
        for(Compent o : children){
            o.operation();
        }
    }
}

 class Leaf implements Compent{
    private String name;
    @Override
    public void add(Compent c) {
        // TODO Auto-generated method stub
    }
    @Override
    public void remove(Compent c) {
        // TODO Auto-generated method stub
    }
    @Override
    public Compent getChild(int i) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void operation() {
        // TODO Auto-generated method stub
        System.out.println("树叶"+name+"：被访问！");
    }

    public Leaf(String name) {
        super();
        this.name = name;
    }

}