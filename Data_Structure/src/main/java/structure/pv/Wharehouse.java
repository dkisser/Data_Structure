package structure.pv;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 仓库类
 * 功能：
 *  主要存放公共数据源
 */
public class Wharehouse {

    private AtomicInteger maxStored;//仓库总容量

    private AtomicInteger current = new AtomicInteger(0);//当前仓库容量

    private Semaphore  maxThreadNum ;//允许进入的最大线程数

    public Wharehouse(int maxStored) {
        this.maxStored = new AtomicInteger(maxStored);
    }

    public Wharehouse(int maxStored, int  maxThreadNum) {
        this.maxStored = new AtomicInteger(maxStored);
        this.maxThreadNum = new Semaphore(maxThreadNum);
    }

    public AtomicInteger getMaxStored() {
        return maxStored;
    }

    public void setMaxStored(AtomicInteger maxStored) {
        this.maxStored = maxStored;
    }

    public AtomicInteger getCurrent() {
        return current;
    }

    public void setCurrent(AtomicInteger current) {
        this.current = current;
    }

    public Semaphore getMaxThreadNum() {
        return maxThreadNum;
    }

    public void setMaxThreadNum(Semaphore maxThreadNum) {
        this.maxThreadNum = maxThreadNum;
    }

    public static void main (String[] args){
        Wharehouse wharehouse  = new Wharehouse(100);
        ConsumerClient consumer = new ConsumerClient(wharehouse.getMaxStored(),wharehouse.getCurrent());
        ProductClient product = new ProductClient(wharehouse.getMaxStored(),wharehouse.getCurrent());
        for (int i=0;i<25;i++){
            new  Thread(product).start();
        }
        for (int i=0;i<20;i++){
            new  Thread(consumer).start();
        }
    }
}
