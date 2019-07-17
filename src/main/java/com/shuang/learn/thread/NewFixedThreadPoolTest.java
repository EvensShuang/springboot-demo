package com.shuang.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 *
 * @Author: shuang.zhang
 * @Email: shuang.zhang@rograndec.com
 * @CreateTime: 2019-7-15
 * @Version: 1.0
 */
public class NewFixedThreadPoolTest {

    //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        for (int i=0;i<10;i++){
            final int index=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+index);
                }
            });
        }
    }
}
