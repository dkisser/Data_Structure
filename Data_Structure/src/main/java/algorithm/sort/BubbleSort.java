package algorithm.sort;

import java.util.Arrays;

/** * @author  wenchen 
 * @date 创建时间：2017年4月26日 下午1:23:09 
 * @version 1.0 
 * @parameter */
public class BubbleSort {
	
	public void sort (int[] array) {
		for (int i = 0;i<array.length-1;i++) {
			for (int j = 0;j<array.length-i-1;j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] array = new int[]{3,2,1,1,5,4,7,9,8,6,6};
		bubbleSort.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
