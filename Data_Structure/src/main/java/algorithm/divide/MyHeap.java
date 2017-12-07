package algorithm.divide;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algorithm.incremental.order.ASC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月25日 下午1:03:46 
 * @version 1.0 
 * 功能:
 * 	构建堆（最大或最小）
 * 
 * 时间复杂度：
 * 	最坏：即左子树比右子树多一层。O(nlogn)(ifyHeap的时间复杂度是logn，循环了n/2次，所以时间复杂度是O(nlogn))
 * @parameter */
public class MyHeap {

	public static int getLeftChild (int i){
		return i*2+1;
	}
	
	public static int getRightChild (int i){
		return i*2+2;
	}
	
	public static int getPatent (int i){
		if (i%2==1) {
			return i/2;
		}
		return i/2-1;
	}
	
	public static void swap (Comparable[] arr,int i,int j){
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 功能:将位于i之后的元素重新构成一个堆
	 * @param arr 要构建最大堆的数组
	 * @param i	要构建的当前元素所在的位置
	 * @param heapSize	用来控制要调整的堆的大小
	 */
	public static void ifyHeap (Comparable[] arr,int i,int heapSize,Comparator<Comparable> com){
		//比较左右子节点和父节点的大小，将最大的与父节点交换，然后再进行递归调用
		int left = getLeftChild(i);
		int right = getRightChild(i);
		int largest = i;
		if (left<heapSize&&com.compare(arr[left], arr[largest])>0) {
			largest = left;
		}
		if (right<heapSize&&com.compare(arr[right], arr[largest])>0){
			largest = right;
		}
		if (largest != i){
			swap(arr, i, largest);
			ifyHeap(arr, largest,heapSize, com);
		}
	}
	/**
	 * 功能:将位于i之后的元素重新构成一个堆
	 * @param arr 要构建最大堆的数组
	 * @param i	要构建的当前元素所在的位置
	 * @param heapSize	用来控制要调整的堆的大小
	 */
	public static void ifyHeap (List<Comparable> arr,int i,int heapSize,Comparator<Comparable> com){
		//比较左右子节点和父节点的大小，将最大的与父节点交换，然后再进行递归调用
		int left = getLeftChild(i);
		int right = getRightChild(i);
		int largest = i;
		if (left<heapSize&&com.compare(arr.get(left), arr.get(largest))>0) {
			largest = left;
		}
		if (right<heapSize&&com.compare(arr.get(right), arr.get(largest))>0){
			largest = right;
		}
		if (largest != i){
			Collections.swap(arr, i, largest);
			ifyHeap(arr, largest,heapSize, com);
		}
	}
	
	/**
	 * 将arr根据com构成一个最大（ASC）或最小（DESC）堆
	 * @param arr
	 * @param com
	 */
	public static void buildHeap (Comparable[] arr,Comparator<Comparable> com){
		int heapSize = arr.length;
		//这里i=heapSize-1也行
		//但是，由于完全二叉树有个特点，就是叶子节点的个数等于(n+1)/2 
		//但是这里的n是从0开始计数，所以叶子节点的个数为n/2.所以非叶子节点的个数也为n/2.我们只需要对非叶子节点构建二叉堆即可
		for (int i=heapSize/2;i>=0;i--) {
			ifyHeap(arr, i,heapSize, com);
		}
	}
	
	/**
	 * 将arr根据com构成一个最大（ASC）或最小（DESC）堆
	 * @param arr
	 * @param com
	 */
	public static void buildHeap (List<Comparable> arr,Comparator<Comparable> com){
		int heapSize = arr.size();
		//这里i=heapSize-1也行
		//但是，由于完全二叉树有个特点，就是叶子节点的个数等于(n+1)/2 
		//但是这里的n是从0开始计数，所以叶子节点的个数为n/2.所以非叶子节点的个数也为n/2
		for (int i=heapSize/2;i>=0;i--) {
			ifyHeap(arr, i,heapSize, com);
		}
	}
	
	public static void main(String[] args) {
		Comparable[] arr = {16,4,10,14,7,9,3,2,8,1};
		buildHeap(arr, new ASC());
		System.out.println("排序好的堆"+Arrays.asList(arr));
	}
	
}
