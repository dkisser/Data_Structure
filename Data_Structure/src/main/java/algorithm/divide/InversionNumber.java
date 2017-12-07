package algorithm.divide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algorithm.incremental.order.ASC;

/** * @author  wenchen 
 * @date 创建时间：2017年11月23日 下午4:04:12 
 * @version 1.0 
 * @parameter */
public class InversionNumber {
	
	/**
	 * 功能：用插入排序解决寻找逆序数的问题
	 * @param list 
	 * @return
	 */
	public static int getInversionsByInsert(List<Comparable> list,Comparator<Comparable> com) {
		int count =0;
		for (int i=1;i<list.size();i++){
			count += findPosition(list, i,com);
		}
		return count;
	}

	/**
	 * 将i元素放在已有正确数组的正确位置
	 * @param list
	 * @param i 表示正在找位置的元素对应的下标
	 */
	private static int findPosition(List<Comparable> list,int i,Comparator<Comparable> com) {
		 int count=0;
		 for (;i>0;i--) {
			 if (com.compare(list.get(i), list.get(i-1))<0) {
				 Collections.swap(list, i, i-1);
				 count++;
			 } else {
				 break;
			 }
		 }
		 return count;
	}
	
	/**
	 * 功能：用归并排序解决寻找逆序数的问题
	 * @param list
	 * @param p
	 * @param r
	 * @param com
	 * @return
	 */
	public static int getInversionsByMerge (List<Comparable> list,int p,int r,Comparator<Comparable> com){
		int count = 0;
		if (p<r) {
			int q = (p+r)/2;
			count+=getInversionsByMerge(list, p, q, com);
			count+=getInversionsByMerge(list, q+1, r, com);
			count+=merge(list, p, q, r, com);
		}
		return count;
	}
	
	private static int merge (List<Comparable> list,int p,int q,int r,Comparator<Comparable> com){
		int count=0;
		int i=0,j=0,k=p;
		List<Comparable> a1 = new ArrayList<Comparable>();
		a1.addAll(list.subList(p, q+1));
		List<Comparable> a2 = new ArrayList<Comparable>();
		a2.addAll(list.subList(q+1, r+1));
		int n1=a1.size(),n2=a2.size();
		for (;i<n1&&j<n2;) {
			if (com.compare(a1.get(i), a2.get(j))<0) {
				list.set(k++, a1.get(i++));
			} else if(com.compare(a1.get(i), a2.get(j))>0){
				list.set(k++, a2.get(j++));
				count += n1-i;
			} 
		}
		while (i<n1) {
			list.set(k++, a1.get(i++));
		}
		while (j<n2) {
			list.set(k++, a2.get(j++));
		}
		return count;
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
		System.out.println("Count="+getInversionsByMerge(arr,0,9,new ASC()));
		System.out.println("排序后的数组为："+arr);
	}
}
