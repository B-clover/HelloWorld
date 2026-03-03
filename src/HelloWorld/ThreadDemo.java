package HelloWorld;

public class ThreadDemo {
    public static void main(String[] args){
        //匿名内部类穿参数，实现Runnable接口
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println("==========="+ i + "===============");
//
//                }
//            }
//        };
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("==========="+ i + "===============");

            }
        });

        
//        thread1.start();
//        thread2.start();

//        MyTest mytest = new MyTest();
//        mytest.test(()->{
//            for (int i = 0; i < 10; i++) {
//                if (i == 5) {
//                    try {
//                        Thread.sleep(1000); //在哪里调用的sleep就让哪个线程停止
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                System.out.println(i);
//            }
//        });

//        MyRunnable2 myRunnable2 = new MyRunnable2();
//        Thread thread3 = new Thread(myRunnable2);
//        thread3.start();
        // 可用lamba表达式简化，like thread2


        for (int i = 0; i < 5; i++) {
            new Thread(()->{
//                ThreadDemo threadDemo = new ThreadDemo();
//                threadDemo.test();
                ThreadDemo.test();
            }).start();
        }
    }

    //synchronized如果锁的是static【资源：包括函数或者变量等】则可以实现线程同步【所有线程都只能有一个线程执行】
    //谁调用了synchronized修饰的资源，就锁谁
    //ReentrantLock重入锁 通过new创建调用 reentrantLock.lock()【trylock()】 *需要上锁的代码* reentrantLock.unlock()更灵活一点
    public synchronized static void test(){
        System.out.println("start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");

    }

    static class MyTest{ // 内部类需要static修饰
        public void test(MyRunnable runnable){ //接口作为参数进行调用
            runnable.test();
        }
    }

    static class MyRunnable2 implements Runnable{
        @Override
        public synchronized void run() {  //synchronized修饰，保证线程安全【执行完该线程才去执行其他线程】

            System.out.println("Runnable2");
        }
    }

    //线程合并join【A调用B的join后，先干B的任务，相当于变成B一个线程】
    //B.join(xxxxx ms) 可以通过参数来控制B的执行时间【否则B会一直执行】
}
