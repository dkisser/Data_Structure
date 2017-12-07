package algorithm.divide;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import algorithm.incremental.order.ASC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月25日 上午11:40:36 
 * @version 1.0
 * 问题描述：
 * 	在一个无序的数组中找第i小的数 
 * 
 * 时间复杂度：
 * 	最坏：O(n平方)
 * 	最好：O(n)
 * 	平均：O(n)
 * @parameter */
public class Select {
	
	public static Comparable getSelect (List<Comparable> list,int p,int r,int i,Comparator<Comparable> com){
		if (p==r) {
			return list.get(p);
		}
		int q = QuickSort.Partition(list, p, r, com);//在已排序后的数组中的位置
		int k = q-p+1;//在已排序后的数组中单位排名
		if (k==i) {
			return list.get(q); 
		} else if (i<k) {
			return getSelect(list, p, q-1, i, com);
		} else {
			return getSelect(list, q+1, r, i-k, com);
		}
	}
	
	public static void main(String[] args) {
		List<Comparable> list = new ArrayList<Comparable>();
		list.add(5);
		list.add(7);
		list.add(2);
		list.add(3);
		list.add(14);
		list.add(11);
		list.add(6);
		list.add(18);
		list.add(9);
		System.out.println("排序前的数组："+list);
		System.out.println("在数组中的数为"+getSelect(list, 0, list.size()-1, 1, new ASC()));
		System.out.println("排序后的数组"+list);
	}
}
