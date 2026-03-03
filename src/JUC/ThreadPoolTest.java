package JUC;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        // 方式1
        // 创建一个单线程的线程池
        // ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 方式2
        // 创建一个固定线程数量的线程池
        // ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 方式3
        // 创建一个可缓存的线程池【根据电脑配置自动分配线程】
//        ExecutorService executorService = Executors.newCachedThreadPool();

        // 方式4【更常用】
        // 自定义一个线程池
//        public static ExecutorService newCachedThreadPool() {
//            return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                    60L, TimeUnit.SECONDS,
//                    new SynchronousQueue<Runnable>());
        // corePoolSize: 核心池大小
        // maximumPoolSize: 最大线程数  [测试出来的数值]  任务超过这个会开新的线程
        // keepAliveTime: 空闲线程存活时间
        // unit：【TimeUnit.SECONDS】 时间单位
        // workQueue: 工作队列 【最大排队的队列，超过这个就会拒绝】
        // threadFactory: 线程工厂
        // handler: 拒绝策略

        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );


        for (int i = 0; i < 8; i++) {
            int finalI = i;
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ": 用户" + finalI);
            });
        }
        executorService.shutdown();
    }
}
