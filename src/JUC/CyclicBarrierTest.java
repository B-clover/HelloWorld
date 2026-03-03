package JUC;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        //CyclicBarrier  JUC加法计时器
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{
            System.out.println("开始执行");
        });
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(()->{
                System.out.println("线程:"+ finalI);
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
