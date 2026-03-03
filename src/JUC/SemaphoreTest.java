package JUC;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        // Semaphore信号量，控制同时访问的线程数【限流器】
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 15; i++) {
            final int finalI = i;
            new Thread(()->{
                try {
                    semaphore.acquire();//获得许可信号
                    System.out.println(finalI + "进店购物");
                    Thread.sleep(1000);
                    System.out.println(finalI + "离开店");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }, "Thread-" + i).start();
        }
    }
}
