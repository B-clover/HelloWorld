package SoloThreadSafe;

public class Test {
    public static void main(String[] args) {
//        Account account = new Account(); // 禁止创建对象
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                Account account = Account.getInstance();

            }).start();
        }
    }
}
