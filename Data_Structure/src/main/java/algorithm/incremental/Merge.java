package algorithm.incremental;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import algorithm.incremental.order.DESC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月22日 上午10:30:17 
 * @version 1.0 
 * 将两个有序序列合并成一个
 * 问题描述：
 * 	序列A[p,....,r]。其中,子序列A[p,...,q]和A[q+1,....,r]是有序的。
 * A[p,...,r]所有元素重排，使之有序。
 * @parameter */
public class Merge {
	
	/**
	 * 将两个有序序列合并成一个
	 * 问题描述：
	 * 	序列A[p,....,r]。其中,子序列A[p,...,q]和A[q+1,....,r]是有序的。
	 * A[p,...,r]所有元素重排，使之有序。
	 * @param a 待排序数组
	 * @param q 第一个有序数组的最后一个元素的位置
	 * @param com 指定排序方式(升序还是降序。com的顺序必须和子数组中的排序方式一样。比如
	 * 比如子数组中是升序，则该出必须为升序)
	 */
	public static void merge(List<Comparable> a,int q,Comparator<Comparable> com) {
		//定义三个初始量。i,j。i,j分别指向两个有序数组的开始位置
		int i=0,j=0;
		//注意：此处不能直接用List a1 = a.subList(0, q+1);
		//因为改方法返回的list是不能修改的，若被修改，则原list也会被修改，会导致程序出错
		List<Comparable> a1 = new ArrayList<Comparable>();
		a1.addAll(a.subList(0, q+1));
		List<Comparable> a2 = new ArrayList<Comparable>();
		a2.addAll(a.subList(q+1, a.size()));
		System.out.println("arr1为："+a1);
		System.out.println("arr2为："+a2);
		for (int k=0;k<a.size();k++) {
			if (i<a1.size()&&j<a2.size()) {
				if (com.compare(a1.get(i),a2.get(j))<0) {
					a.set(k, a1.get(i));
					i++;
				} else {
					a.set(k, a2.get(j));
					j++;
				}
			} else {
				//将两个数组中剩下的一个数组中的元素加入到a中
				while(i<a1.size()){
					a.set(k, a1.get(i));
					i++;
					k++;
				}
				while(j<a2.size()){
					a.set(k,a2.get(j));
					j++;
					k++;
				}
			}
		}
	}
	public static void main(String[] args) {
		List<Comparable> arr = new ArrayList<Comparable>();
		arr.add(9);
		arr.add(7);
		arr.add(4);
		arr.add(1);
		arr.add(0);
		arr.add(8);
		arr.add(6);
		arr.add(5);
		arr.add(3);
		arr.add(2);
		System.out.println("排序前的数组为："+arr);
		merge(arr, 4,new DESC());
		System.out.println("排序后的数组为："+arr);
	}
}
