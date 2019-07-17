package com.shuang.learn.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，支持定时及周期性任务执行。
 *
 * @Author: shuang.zhang
 * @Email: shuang.zhang@rograndec.com
 * @CreateTime: 2019-7-15
 * @Version: 1.0
 */
public class NewScheduledThreadPoolTest {

    //创建一个定长线程池，支持定时及周期性任务执行。
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
