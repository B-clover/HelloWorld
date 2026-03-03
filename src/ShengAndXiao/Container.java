package ShengAndXiao;

import java.util.concurrent.locks.ReentrantLock;

public class Container {
    private Hamburger[] hamburgers = new Hamburger[6];
    public int index = 0;

    public synchronized void push(Hamburger hamburger){
        while (this.index == hamburgers.length){
            try {
                System.out.println("没有空间了，请等待");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hamburgers[this.index] = hamburger;
        this.index++;
        System.out.println("生成了新汉堡:"+hamburger);
        this.notify();
    }

    public synchronized Hamburger pop(){
        while (this.index == 0){
            try {
                System.out.println("没有汉堡了，请等待");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.index--;
        Hamburger hamburger = hamburgers[this.index];
        System.out.println("取出了汉堡:"+hamburger);
        this.notify();
        return hamburger;
    }
}
