package algorithm.divide;

import java.util.ArrayList;
import java.util.List;

/** * @author  wenchen 
 * @date 创建时间：2017年11月23日 下午3:37:00 
 * @version 1.0 
 * 分冶算法——二分查找
 * 时间复杂度： O(log n)
 * @parameter */
public class BinarySearch {

	/**
	 * 在有序数组中用二分查找找到X
	 * @param arr 有序的数组
	 * @param p
	 * @param r
	 * @param x
	 * @return
	 */
	public static Comparable BinarySearch (List<Comparable> arr,int p,int r, Comparable x) {
		if (p>r){
			return null;
		}
		//先判断中间数与x的大小
		int mid = (p+r)/2;
		if (arr.get(mid).compareTo(x)==0) {
			return mid;
		}
		//若中间数小于X则在中间位置到数组末尾中间再调用二分查找，找到找到该数
		if (arr.get(mid).compareTo(x)<0) {
			return BinarySearch(arr, mid, r, x);
		}
		//若中间数大于X则在数组初始化位置和中间位置再调用二分查找，找到找到该数
		if (arr.get(mid).compareTo(x)>0) {
			return BinarySearch(arr, p, mid, x);
		}
		return null;
	}
	
	public static void main(String[] args) {
		List<Comparable> arr = new ArrayList<Comparable>();
		for (int i=0;i<100;i++) {
			arr.add(i);
		}
		System.out.println("Result="+BinarySearch(arr, 0, arr.size()-1, 55));		
		
	}
	
}
