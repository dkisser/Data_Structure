package algorithm.divide;

import java.util.Arrays;
import java.util.Comparator;

import algorithm.incremental.order.ASC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月25日 下午2:00:25 
 * @version 1.0
 * 分冶算法——堆排序
 * 思路：
 * 	利用堆排序的性质(A[0]为数组中最大或最小的数)，在构建一次最大堆之后。将A[0]与最后一个元素的位置交换。
 * 然后再在剩下的数组中再对其进行生成堆，然后递归调用到只剩A[1]为止 
 * @parameter */
public class HeapSort {
	
	public static void HeapSort (Comparable[] arr,Comparator<Comparable> com){
		//先生成最大或最小堆
		int heapSize = arr.length;
		MyHeap.buildHeap(arr, com);
		for (int i=heapSize-1;i>0;i--){
			//交换最后一个数和arr[0]
			MyHeap.swap(arr, 0, i);
			heapSize--;
			//再调整最大或最小堆
			MyHeap.ifyHeap(arr, 0, heapSize, com);
		}
	}
	
	public static void main(String[] args) {
		Comparable[] arr = {16,4,10,14,7,9,3,2,8,1};
		System.out.println("排序前的数组"+Arrays.asList(arr));
		HeapSort(arr, new ASC());
		System.out.println("排序后的数组"+Arrays.asList(arr));
	}
}
