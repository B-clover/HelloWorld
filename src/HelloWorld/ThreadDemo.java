package HelloWorld;

public class ThreadDemo {
    public static void main(String[] args) {
        //匿名内部类穿参数，实现Runnable接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("==========="+ i + "===============");

                }
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("+++++++++++"+ i + "+++++++++++");

                }
            }
        };

        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }
}
