package algorithm.divide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import algorithm.incremental.order.DESC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月25日 上午10:43:25 
 * @version 1.0 
 * 分冶算法——快速排序
 * 平均时间复杂度：O(n平方)
 * @parameter */
public class QuickSort {
	
	/**
	 * 思路：
	 * 	每进行一次快排，都会找到一个元素在最终排序中的正确位置
	 * 功能：
	 * 	对p到r之间的随意一个数进行快排，并返回其位置
	 * @param list
	 * @param p 进行快排的初始位置
	 * @param r 进行快排的结束位置
	 */
	public static int Partition (List<Comparable> list,int p,int r,Comparator<Comparable> com){
		int i=0,j=0;
		int ran = p+new Random().nextInt(r-p+1);
		Collections.swap(list, ran, r);
		for (;j<r;j++) {
			//若果list[j]<list[r],交换i,j。并i++
			if (com.compare(list.get(j), list.get(r))<0) {
				Collections.swap(list, i, j);
				i++;
			}
		}
		//将r放到正确的位置
		Collections.swap(list, i, r);
		return i;
	}
	
	public static void QuickSort (List<Comparable> list,int p,int r,Comparator<Comparable> com){
		if (p<r) {
			int q = Partition(list, p, r, com);
			QuickSort(list, p, q, com);
			QuickSort(list, q+1, r, com);
		}
	}
	public static void main(String[] args) {
		List<Comparable> list = new ArrayList<Comparable>();
		list.add(5);
		list.add(7);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(6);
		list.add(8);
		list.add(9);
		System.out.println("排序前的数组："+list);
		QuickSort(list, 0, list.size()-1, new DESC());
		System.out.println("排序后的数组："+list);
	}
}
