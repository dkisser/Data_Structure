package algorithm.incremental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** * @author  wenchen 
 * @date 创建时间：2017年11月21日 下午2:51:10 
 * @version 1.0 
 * 插入排序——实际应用
 * @parameter */
public class InsertSortPractice {

	/**
	 * 问题描述：
	 * 求一个数组中的逆序数
	 * （逆序数：若A[1,....,n]中，i<j且A[i]>A[j],则数偶（i，j）称为A的一个逆序。
	 * 如在数组2，3，8，6，1中，<2,1><3,1><8,1><6,1>是A的逆序）
	 * 问题转换：
	 * 	该问题其实就是要比较下标和与下标对应的数之间的关系。
	 * 一般思路：
	 * 	使用两层循环，采用遍历的方式来进行比较。
	 * 插入排序的好处：
	 * 	我们插入的数组都是有序的，意思就是说，若当前待比较元素>有序数组的最后一个元素的值，则进入下一次循环(概数与以有数组中的所有元素都不存在逆序数)。
	 * 若当前待比较元素<有序数组的最后一个元素的值(存在一个及以上的逆序数)，则继续比较，知道找到比当前元素小的值为止。（减少了循环次数）
	 */
	public static int getInversion (List<Comparable> arr) {
		int count = 0;
		for (int i = 0;i<arr.size()-1;i++) {
			count +=findInversion(arr,i+1);
			System.out.println();
		}
		return count;
	}
	
	private static int findInversion (List<Comparable> arr, int pre) {
		int count = 0;
		for (int i = pre-1;i>=0;i--) {
			//若当前元素小于有序数组的最后一个数则交换,否则就进入下一次比较
			if (arr.get(i).compareTo(arr.get(i+1))>0) {
				System.out.print(arr.get(i)+"-"+arr.get(i+1)+"\t");
				Collections.rotate(arr.subList(i, i+2), 1);
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	public static void main(String[] args) {
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
		System.out.println("数组"+arr2+"中的逆序数如下————————");
		int count = getInversion(arr2);
		System.out.println("共"+count+"个");
	}
	
}
