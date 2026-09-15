package com.zhl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-12-18 9:39
 */
public class ScheduledTest {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

    @Test
    public void testThreadPool(){

    }


    @Test
    public void testScheduledThreadPool2() throws IOException, ExecutionException, InterruptedException {
        logger.info("开始测试定时任务");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        // 1.1 schedule 方法 参数值是 Runnable , delay, TimeUnit
//        scheduledThreadPoolExecutor.schedule(() -> {
//            logger.info("ScheduledTest.testScheduledThreadPool2");
//        }, 5, TimeUnit.SECONDS);

        // 1.2  schedule 方法 参数值是 Callable , delay, TimeUnit
//        ScheduledFuture<String> future = scheduledThreadPoolExecutor.schedule(() -> {
//            logger.info("{} ScheduledTest.testScheduledThreadPool2.schedule  ---> Callable...", Thread.currentThread());
//            return "执行成功";
//        }, 5, TimeUnit.SECONDS);
//        String futureResult = future.get();
//        logger.info("{} futureResult : {}",Thread.currentThread(), futureResult);

        // 2.1 scheduleAtFixedRate 方法 Runnable，initialDelay，period，TimeUnit
        //
        scheduledThreadPoolExecutor.scheduleAtFixedRate(()->{
            logger.info("{} ScheduledTest.testScheduledThreadPool2.scheduleAtFixedRate  ---> Runnable... 次数 ：{}", Thread.currentThread(), ATOMIC_INTEGER.getAndIncrement());
        }, 5, 10, TimeUnit.SECONDS);

        try {
            logger.info("开始处理业务逻辑");
            Thread.sleep(20000);
            logger.info("结束处理业务逻辑");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 2.2 scheduleWithFixedDelay 方法 参数值是 Runnable，initialDelay，delay，TimeUnit
        //
//        scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{
//            logger.info("{} ScheduledTest.testScheduledThreadPool2.scheduleWithFixedDelay  ---> Runnable... 次数 ：{}", Thread.currentThread(), ATOMIC_INTEGER.getAndIncrement());
//            logger.info("开始处理业务逻辑");
//            try {
//                Thread.sleep(20000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            logger.info("结束处理业务逻辑");
//        }, 5, 10, TimeUnit.SECONDS);

        System.out.println(System.in.read());
//        scheduledThreadPoolExecutor.shutdown();
    }

    @Test
    public void testScheduledThreadPool(){
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
//        scheduledThreadPoolExecutor.submit();
        scheduledThreadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                logger.info("{}  开始执行", Thread.currentThread());
                logger.info("{}  SpringTest.run", Thread.currentThread());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                logger.info("{}  执行结束", Thread.currentThread());
            }
        });
        logger.info("{}  开始执行", Thread.currentThread());
        logger.info("{} ScheduledTest.testScheduledThreadPool", Thread.currentThread());
        logger.info("{}  执行结束", Thread.currentThread());
    }

}
