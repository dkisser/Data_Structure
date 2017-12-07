package algorithm.divide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algorithm.incremental.order.DESC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月21日 下午3:38:50 
 * @version 1.0 
 * 分冶算法——归并排序
 * 时间复杂度:O(nlog n)
 * @parameter */
public class MergeSort {

	/**
	 * 将两个有序序列合并成一个
	 * 问题描述：
	 * 	序列A[p,....,r]。其中,子序列A[p,...,q]和A[q+1,....,r]是有序的。
	 * A[p,...,r]所有元素重排，使之有序。
	 * @param a 待排序数组
	 * @param p 第一个有序数组的第一个元素位置
	 * @param q 两个有序数组中间的一个位置
	 * @param r 第二个有序数组的最后一个元素位置
	 * @param com 指定排序方式(升序还是降序。com的顺序必须和子数组中的排序方式一样。比如
	 * 比如子数组中是升序，则该出必须为升序)
	 */
	public static void merge(List<Comparable> a,int p,int q,int r,Comparator<Comparable> com) {
		//定义三个初始量。i,j。i,j分别指向两个有序数组的开始位置
		int i=0,j=0,k=p;
		//注意：此处不能直接用List a1 = a.subList(0, head+1);
		//因为改方法返回的list是不能修改的，若被修改，则原list也会被修改，会导致程序出错
		List<Comparable> a1 = new ArrayList<Comparable>();
		a1.addAll(a.subList(p, q+1));
		List<Comparable> a2 = new ArrayList<Comparable>();
		a2.addAll(a.subList(q+1, r+1));
		int n1=a1.size(),n2=a2.size();
		while(i<n1&&j<n2){
			if (com.compare(a1.get(i),a2.get(j))<0) {
				a.set(k++, a1.get(i++));
			} else {
				a.set(k++, a2.get(j++));
			}
		}
		if(i<n1){
			for (;i<n1;i++) {
				a.set(k++, a1.get(i));
			}
		}
		if(j<n2) {
			for (;j<n2;j++){
				a.set(k++, a2.get(j));
			}
		}
	}
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
	
	public static void mergeSort(List<Comparable> arr,int p,int r,Comparator<Comparable> com){
		if (p<r) {
			int q = (p+r)/2;
			mergeSort(arr, p, q, com);
			mergeSort(arr, q+1, r, com);
			merge(arr, p , q , r, com);
		}
	}
	
	
	public static void main(String[] args) {
		List<Comparable> arr = new ArrayList<Comparable>();
		arr.add(9);
		arr.add(7);
		arr.add(4);
		arr.add(0);
		arr.add(1);
		arr.add(8);
		arr.add(2);
		arr.add(6);
		arr.add(3);
		arr.add(5);
		System.out.println("排序前的数组为："+arr);
		mergeSort(arr, 0, 9, new DESC());
		System.out.println("排序后的数组为："+arr);
		
	}
	
}
