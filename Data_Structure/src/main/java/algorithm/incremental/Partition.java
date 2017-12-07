package algorithm.incremental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algorithm.incremental.order.ASC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月22日 上午10:30:33 
 * @version 1.0 
 * 
 * 将一个序列分解成两个子序列
 * 问题描述：
 * 	序列A[p,....,r]。其中,子序列A[p,...,q]和A[q+1,....,r]是有序的。
 * A[p,...,r]所有元素重排，使之子序列A[p,...,q-1]小于A[q],子序列A[q+1,....,r]>A[q]。
 * @parameter */
public class Partition {
	
	/**
	 * 将一个序列分解成两个子序列
	 * 问题描述：
	 * 	序列A[p,....,r]。其中,子序列A[p,...,q]和A[q+1,....,r]是有序的。
	 * A[p,...,r]所有元素重排，使之子序列A[p,...,q-1]小于A[q],子序列A[q+1,....,r]>A[q]。
	 * @param a 待排序数组
	 * @param com 指定排序方式(升序还是降序。com的顺序必须和子数组中的排序方式一样。比如
	 * 比如子数组中是升序，则该出必须为升序)
	 */
	public static void partition (List<Comparable> a,Comparator<Comparable> com) {
		int i=0;
		Comparable mid = a.get(a.size()-1);
		for (int j=0;j<a.size();j++) {
			if (com.compare(a.get(j), mid)<=0) {
				Collections.swap(a, i, j);
				i++;
			}
		}
	}
	public static void main(String[] args) {
		List<Comparable> arr2 = new ArrayList<Comparable>();
		arr2.add(8);
		arr2.add(9);
		arr2.add(7);
		arr2.add(1);
		arr2.add(2);
		arr2.add(5);
		arr2.add(0);
		arr2.add(3);
		arr2.add(4);
		arr2.add(6);
		System.out.println("分解前的数组为："+arr2);
		partition(arr2, new ASC());
		System.out.println("分解后的数组为："+arr2);
	}
	
}
