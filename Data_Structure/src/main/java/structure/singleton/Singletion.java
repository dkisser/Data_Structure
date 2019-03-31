package structure.singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 双重检验锁方式实现的单例模式
 * 多线程下单例模式
 */
public class Singletion {

    private static volatile Singletion instance;

    private ReentrantLock lock = new ReentrantLock();

    private Singletion() {}

    public static Singletion getInstance() {
        if (instance == null){
            synchronized (Singletion.class){
                if (instance == null){
                    instance = new Singletion();
                }
            }
        }
        return instance;
    }

    public static void main (String[] args){
        for (int i=0;i<20;i++){
            final int j = i;
            new Thread(()->{
                Singletion  a = Singletion.getInstance();
                System.out.println(j+":"+(a==null));
            }).start();
        }
    }
}
