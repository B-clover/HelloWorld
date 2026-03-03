package JUC;

import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {
//        List<Object> arrayList = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<Object> arrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                //同时读写会报错ConcurrentModificationException，线程不安全 解决:Collections.synchronizedList()包装
                //或者直接使用JUC提供的线程安全类CopyOnWriteArrayList()【推荐】
                arrayList.add("a");
                System.out.println(arrayList);
            }).start();
        }
    }
}
