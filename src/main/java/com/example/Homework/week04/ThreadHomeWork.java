package com.example.Homework.week04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class ThreadHomeWork {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start:" + System.currentTimeMillis());
                    int res = sum();
                    System.out.println("res = " + res);
                    Thread.sleep(1000L);
                    System.out.println("end:" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executorService.execute(runnable);
        executorService.shutdown();
        System.out.println("Main Thread End!");

    }


    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
