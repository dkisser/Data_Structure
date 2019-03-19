package structure.pv;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者客户端
 */
public class ConsumerClient implements Runnable{

    private AtomicInteger maxStored;//仓库总容量

    private AtomicInteger current;//当前仓库容量

    private Semaphore maxThreadNum ;//允许进入的最大线程数

    private Random random  = new Random(1000);

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public ConsumerClient(AtomicInteger maxStored, AtomicInteger current) {
        this.maxStored = maxStored;
        this.current = current;
    }

    public ConsumerClient(AtomicInteger maxStored, AtomicInteger current, Semaphore maxThreadNum) {
        this.maxStored = maxStored;
        this.current = current;
        this.maxThreadNum = maxThreadNum;
    }

    @Override
    public void run() {
        //当仓库为空阻塞
        while  (true){
            while (current.get() <= 0){
                synchronized (current){
                    System.out.println("wharehousr present size is zero!");
                    try {
                        current.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(current.get() > 0){
                int curNum = current.decrementAndGet();
                System.out.println("consuming,wharehousr present size is:"+curNum);
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (current){
                    current.notifyAll();
                }
            }
        }
    }
}
