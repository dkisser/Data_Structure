package sort;

import java.util.Arrays;

import org.apache.taglibs.standard.lang.jstl.ArraySuffix;

/** * @author  wenchen 
 * @date 创建时间：2017年4月25日 下午4:50:37 
 * @version 1.0 
 * @parameter */
public class MergeSort {

	public void sort(int[] array,int head,int tail) {
		
		int mid = (head+tail)/2;
		
		if (head < tail) {
			//左边递归排序
			sort(array, head, mid);
			//右边递归排序
			sort(array, mid+1, tail);
			//左右归并
			merge(array, head, mid, tail);	
		}
		
	}
	
	public void merge (int[] array,int head,int mid,int tail) {
		
		int i = head,
		j = mid+1,
		k = 0;
		int[] temp = new int[tail-head+1];
		//将两个子数组中较小的先放入temp数组中
		while (i<=mid&&j<=tail) {
			if (array[i]<array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		//将剩下的左边的子数组添加到temp中
		while (i<=mid) {
				temp[k++] = array[i++]; 
		}
		//将剩下的右边的子数组添加到temp中
		while (j<=tail) {
			temp[k++] = array[j++];
		}
		//将temp数组放回到原来的数组中
		for (int l = 0;l<temp.length;l++) {
			array[head+l] = temp[l];
		}
	}
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] array = new int[]{3,2,1,1,5,4,7,9,8,6,6};
		mergeSort.sort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
}
