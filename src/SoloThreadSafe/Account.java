package SoloThreadSafe;

public class Account {

    private static Account instance;

    private Account(){
        System.out.println("创建了一个对象");
    } // 私有化构造方法,防止外部构建多个实例【线程安全的单例模式】

    public static synchronized Account getInstance() { // 静态方法，返回单例对象,synchronized为了保证多线程只会有一个访问该方法
        if (instance == null) {
            instance = new Account();
        }
        return instance;
    }
}
