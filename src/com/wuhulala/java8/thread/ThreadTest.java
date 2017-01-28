package com.wuhulala.java8.thread;

import org.junit.Test;

import java.util.TimeZone;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/28/17
 */
public class ThreadTest {
    @Test
    public void testLambdaRunnable(){
        Runnable runnable = () -> {
            System.out.println("Hello	"	+	Thread.currentThread().getName());
        };
        runnable.run();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Done");

    }

    /**
     * 测试Executor
     */
    @Test
    public void testLambdaExecutor(){
        ExecutorService executor	=	Executors.newFixedThreadPool(3);
        executor.submit(()	->	{
            String	threadName	=	Thread.currentThread().getName();
            System.out.println("Hello	"	+	threadName);
        });

        Future<String> future =  executor.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            return UUID.randomUUID().toString();
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
