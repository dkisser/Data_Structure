package algorithm.divide;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import algorithm.incremental.order.ASC;
import algorithm.incremental.order.DESC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月25日 下午3:11:15 
 * @version 1.0
 * 优先队列——使用堆创建（最大堆或最小堆） 
 * @parameter */
public class PrioQueue {

	private Vector<Comparable> heap;
	
	private Integer heapSize;
	
	private Comparator com;
	
	public PrioQueue (){
		heap = new Vector<Comparable>();
		heapSize = 0;
		com = new ASC();
	}
	
	public PrioQueue (Comparator com){
		heap = new Vector<Comparable>();
		heapSize = 0;
		this.com = com;
	}
	
	/**
	 * 入队
	 * @param c
	 */
	public void enQueue (Comparable c){
		//用于记录当前新加入的元素的位置
		int i= heapSize++;
		heap.add(c);
		int parent = MyHeap.getPatent(i);
		//与父节点比较，若大，则交换，然后再将父节点的位置赋予i.循环，只到他比父节点小或等于
		//之所以不用MyHeap.ifyHeap是因为，我们不需要判断父节点的另外一个孩子与他的大小
		while (i>0&&com.compare(heap.get(i), heap.get(parent))>0){
			Collections.swap(heap, i, parent);
			i = parent;
		}
	}
	
	/**
	 * 出队
	 * @throws Exception 
	 */
	public Comparable deQueue () throws Exception{
		if (heapSize <1){
			throw new Exception("目前优先队列中没有元素，无法执行出队操作!");
		}
		Comparable top = heap.get(0);
		//将a[0]出队，同时将剩下的堆从新构成一个堆
		heapSize--;
		//将a[0]设置为最后一个元素
		heap.set(0, heap.get(heapSize));
		//移出最后一个元素
		heap.removeElementAt(heapSize);
		//将剩下的堆重新生成新的堆
		MyHeap.ifyHeap(heap, 0, heapSize, com);
		return top;
	}
	
	public boolean isEmpty(){
		return heapSize<1;
	}
	
	/**
	 * 功能：重新构成一个最大堆
	 */
	public void fixQue (){
		for (int i=heapSize/2;i>=0;i--){
			MyHeap.ifyHeap(heap, i, heapSize, com);
		}
	}
	
	public static void main(String[] args) throws Exception {
		PrioQueue que = new PrioQueue(new DESC());
		que.enQueue(11);
		que.enQueue(71);
		que.enQueue(91);
		que.enQueue(51);
		que.enQueue(11);
		System.out.println("原始队列"+que.heap);
		System.out.println(que.isEmpty());
		System.out.println("删除"+que.deQueue());
		System.out.println("删除"+que.deQueue());
		System.out.println("删除后的队列"+que.heap);
		System.out.println("size ="+que.heap.size());
		System.out.println("删除"+que.deQueue());
		System.out.println("删除"+que.deQueue());
		System.out.println("删除后的队列"+que.heap);
		System.out.println("size ="+que.heap.size());
		System.out.println("删除"+que.deQueue());
		System.out.println("删除后的队列"+que.heap);
		que.enQueue(1);
		System.out.println(que.heap);
		System.out.println(que.deQueue());
		System.out.println(que.heap);
	}
	
}
