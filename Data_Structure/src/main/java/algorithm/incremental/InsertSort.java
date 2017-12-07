package algorithm.incremental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algorithm.incremental.order.ASC;
import algorithm.incremental.order.DESC;



/** * @author  wenchen 
 * @date 创建时间：Nov 18, 2017 2:40:28 PM 
 * @version 1.0 
 * 渐增型算法——插入排序
 * 时间复杂度为： o(n的平方)
 * @parameter */
public class InsertSort {
	
	/**
	 * 可将实现了Comparable接口的所有的类型的数据进行快速排序
	 * com是你要选择的排序类型（升序或降序）
	 * @param arr 
	 * @return
	 */
	public static Comparable[] executeSort(Comparable[] arr,Comparator<Comparable> com){
		
		for (int i = 0;i<arr.length-1;i++) {
			//将当前int变量的后面一个数放到该变量之前的正确位置
			findPosition(arr,i+1,com);
		}
		return arr;
	}
	
	private static void findPosition(Comparable[] arr, int pre ,Comparator<Comparable> com) {
		for (int i = pre-1;i>=0;i--) {
			if (com.compare(arr[i], arr[i+1])>0) {
				Comparable temp = arr[i+1];
				arr[i+1]=arr[i];
				arr[i]=temp;
			} else {
				break;
			}
		}
	}
	
	/**
	 * 可将int数组内的元素进行快速排序
	 * @param arr
	 * @return
	 */
	public static int[] executeSort(int[] arr){
		
		for (int i = 0;i<arr.length-1;i++) {
			//将当前int变量的后面一个数放到该变量之前的正确位置
			findPosition(arr,i+1);
		}
		return arr;
	}
	
	private static void findPosition(int[] arr, int pre ) {
		for (int i = pre-1;i>=0;i--) {
			if (arr[i]>arr[i+1]) {
				int temp = arr[i+1];
				arr[i+1]=arr[i];
				arr[i]=temp;
			} else {
				break;
			}
		}
	}
	/**
	 * 可将List<Comparable>内的元素进行排序（即List里面全部是实现了Comparable接口的元素）
	 * com是你要选择的排序类型（升序或降序）
	 * @param arr
	 * @return
	 */
	public static List<Comparable> executeSort(List<Comparable> arr,Comparator<Comparable> com){
		
		for (int i = 0;i<arr.size()-1;i++) {
			//将当前int变量的后面一个数放到该变量之前的正确位置
			findPosition(arr,i+1,com);
		}
		return arr;
	}
	
	private static void findPosition(List<Comparable> arr, int pre,Comparator<Comparable> com ) {
		for (int i = pre-1;i>=0;i--) {
			if (com.compare(arr.get(i), arr.get(i+1))>0) {
				//交换位置
				Collections.rotate(arr.subList(i, i+2), 1);
			} else {
				break;
			}
		}
	}
	
	public static void main (String[] args) {
		Integer[] arr = {5,1,9,4,6,2,0,3,8,7};
		List<Comparable> arr2 = new ArrayList<Comparable>();
		arr2.add(5);
		arr2.add(1);
		arr2.add(9);
		arr2.add(4);
		arr2.add(6);
		arr2.add(2);
		arr2.add(0);
		arr2.add(3);
		arr2.add(8);
		arr2.add(7);
		executeSort(arr2, new DESC());
		executeSort(arr,new ASC());
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		for (Comparable c:arr2) {
			System.out.println(c);
		}
	}
	
	
}
