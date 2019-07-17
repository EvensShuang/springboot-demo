package com.shuang.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 *
 * @Author: shuang.zhang
 * @Email: shuang.zhang@rograndec.com
 * @CreateTime: 2019-7-15
 * @Version: 1.0
 */
public class NewCacheThreadPoolTest {
    //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + index);
                }
            });
        }
    }
}
