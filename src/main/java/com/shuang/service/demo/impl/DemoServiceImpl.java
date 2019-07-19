package com.shuang.service.demo.impl;

import com.shuang.service.demo.DemoService;
import com.shuang.service.demo.dao.write.DemoWriteDao;
import com.shuang.service.demo.entity.Demo;
import com.shuang.transaction.TransactionSupport;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: shuang.zhang
 * @Email: shuang.zhang@rograndec.com
 * @CreateTime: 2019-7-19
 * @Version: 1.0
 */
@Service
public class DemoServiceImpl extends TransactionSupport implements DemoService {

    @Autowired
    private DemoWriteDao demoWriteDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addDemoRequired(List<Demo> demoList) {
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            demoWriteDao.addDemo(demoList.get(0));
            demoWriteDao.addDemo(demoList.get(1));
            this.commitTransaction(status);
            return 1;
        } catch (Exception e) {
            this.rollbackTransaction(status);
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addDemoRequiredNew() {
        Demo demo = new Demo();
        demo.setAid(3);
        demo.setAuthor("33");
        demo.setTitle("33");
        demoWriteDao.addDemo(demo);
//            SpringContextUtils.getBean(DemoService.class).updateDemoRequiredNew();
        ((DemoService) AopContext.currentProxy()).updateDemoRequiredNew1();
        // 抛出异常，doB()的事务事务回滚
//            this.commitTransaction(status);
//            return 1;
//        } catch (Exception e) {
//            e.printStackTrace();
//            this.rollbackTransaction(status);
//        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateDemoNotSupported() {
//        TransactionStatus status =this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
//        try {

        Demo demo = new Demo();
        demo.setAid(3);
        demo.setAuthor("33");
        demo.setTitle("33");
        demoWriteDao.addDemo(demo);
        ((DemoService) AopContext.currentProxy()).updateDemoNotSupported1();

//            SpringContextUtils.getBean(DemoService.class).updateDemoNotSupported();
//            this.commitTransaction(status);
//        }catch (Exception e){
//            e.printStackTrace();
//            this.rollbackTransaction(status);
//        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer updateDemoRequiredNew1() {
//        TransactionStatus status =this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        try {
        Demo demo = new Demo();
        demo.setAid(1);
        demo.setAuthor("aaaaaaaaaaaaaaaa");
        demo.setTitle("aaaaaaaaaaaaaaaa");
        demoWriteDao.updateDemo(demo);
        int i = 1 / 0;
//            this.commitTransaction(status);
//            return 1;
//        }catch (Exception e) {
//            this.rollbackTransaction(status);
//        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer supports() {
        Demo demo = new Demo();
        demo.setAid(3);
        demo.setAuthor("33");
        demo.setTitle("33");
        demoWriteDao.addDemo(demo);
        ((DemoService) AopContext.currentProxy()).supports1();
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer supports1() {
        Demo demo = new Demo();
        demo.setAid(1);
        demo.setAuthor("ttttttttttt");
        demo.setTitle("ttttttttttt");
        demoWriteDao.updateDemo(demo);
        int i = 1 / 0;
        return i;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Integer updateDemoNotSupported1() {
//        TransactionStatus status =this.createTransactionStatus(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
//        try {
        Demo demo = new Demo();
        demo.setAid(1);
        demo.setAuthor("bbbbbbbbbbbbbbbb");
        demo.setTitle("bbbbbbbbbbbbbbbb");
        demoWriteDao.updateDemo(demo);
        int i = 1 / 0;
//            this.commitTransaction(status);
//            return 1;
//        }catch (Exception e) {
//            this.rollbackTransaction(status);
//        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer mandatory() {
        Demo demo = new Demo();
        demo.setAid(1);
        demo.setAuthor("ccccccccccccc");
        demo.setTitle("cccccccccccccc");
        demoWriteDao.updateDemo(demo);
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer nested() {
        Demo demo = new Demo();
        demo.setAid(3);
        demo.setAuthor("33");
        demo.setTitle("33");
        demoWriteDao.addDemo(demo);
        ((DemoService) AopContext.currentProxy()).nested1();
        int i = 1 / 0;
        return i;
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public Integer nested1() {
        Demo demo = new Demo();
        demo.setAid(1);
        demo.setAuthor("dddddddddddd");
        demo.setTitle("ddddddddddddd");
        demoWriteDao.updateDemo(demo);
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Integer never() {
        Demo demo = new Demo();
        demo.setAid(3);
        demo.setAuthor("33");
        demo.setTitle("33");
        return demoWriteDao.addDemo(demo);
    }

}
