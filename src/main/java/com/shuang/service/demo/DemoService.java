package com.shuang.service.demo;

import com.shuang.service.demo.entity.Demo;

import java.util.List;

/**
 * @Author: shuang.zhang
 * @Email: shuang.zhang@rograndec.com
 * @CreateTime: 2019-7-19
 * @Version: 1.0
 */
public interface DemoService {
    public Integer addDemoRequired(List<Demo> demoList);
    public Integer addDemoRequiredNew();
    public Integer updateDemoRequiredNew1();
    public Integer supports();
    public Integer supports1();
    public Integer updateDemoNotSupported();
    public Integer updateDemoNotSupported1();
    public Integer mandatory();
    public Integer nested();
    public Integer nested1();
    public Integer never();
}
