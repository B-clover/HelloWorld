package JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        Cache cache = new Cache();

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                cache.write(temp, String.valueOf(temp));
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                cache.read(temp);
            }).start();
        }

    }
}

class Cache{
    private Map<Integer,String> map = new HashMap<>();
    //读写锁  允许一个人写 但是多个人读
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //写操作
    public void write(Integer key,String value){
        readWriteLock.writeLock().lock();
        System.out.println(key+"开始写入");
        this.map.put(key,value);
        System.out.println(key+"写入完毕");
        readWriteLock.writeLock().unlock();
    }
    //读操作
    public void read(Integer key){
        readWriteLock.readLock().lock();
        System.out.println(key+"开始读取");
        System.out.println(this.map.get(key) + "读取完毕");
        readWriteLock.readLock().unlock();
    }
}