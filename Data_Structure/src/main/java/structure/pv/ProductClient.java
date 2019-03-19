package structure.pv;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者客户端
 */
public class ProductClient implements Runnable{

    private AtomicInteger maxStored;//仓库总容量

    private AtomicInteger current;//当前仓库容量

    private Semaphore maxThreadNum ;//允许进入的最大线程数

    private Random random  = new Random(1000);

    public ProductClient(AtomicInteger maxStored, AtomicInteger current) {
        this.maxStored = maxStored;
        this.current = current;
    }

    public ProductClient(AtomicInteger maxStored, AtomicInteger current, Semaphore maxThreadNum) {
        this.maxStored = maxStored;
        this.current = current;
        this.maxThreadNum = maxThreadNum;
    }

    @Override
    public void run() {
        //当仓库满时阻塞
        while (true){
            while (current.get() >= maxStored.get()){
                synchronized (current){
                    System.out.println("wharehousr present size is max!");
                    try {
                        current.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (current.get() < maxStored.get()){
                int curNum = current.incrementAndGet();
                System.out.println("producting,wharehouse present size  is:"+curNum);
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
