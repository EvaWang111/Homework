package com.example.Homework.week04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class ThreadHomeWork {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            Future<Integer> future = executorService.submit(() -> {
                throw new RuntimeException("executorService.submit()");
            });
            int b = sum();
            System.out.println(b);
        } catch (Exception ex) {
            System.out.println("catch submit");
            ex.printStackTrace();
        }
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
