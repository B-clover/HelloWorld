package JUC;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        // CountDownLatch设置一个倒计时，当倒计时结束之后才会执行其他的线程
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println("1111111111111111111");
                countDownLatch.countDown();
            }
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println("222222222222222222222");
        }
    }
}
