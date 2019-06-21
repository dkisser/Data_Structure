package algorithm.sort;

import java.util.Arrays;

/** * @author  wenchen 
 * @date 创建时间：2017年4月26日 下午1:44:46 
 * @version 1.0 
 * @parameter */
public class InsertSort {

	public void sort (int[] array) {
		for (int i = 1;i<array.length;i++) {
			int j =i;
			int temp = array[i];
			while (j > 0 && temp<array[j-1]) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
		}
	}
	public static void main(String[] args) {
		InsertSort insertSort = new InsertSort();
		int[] array = new int[]{3,2,1,1,5,4,7,9,8,6,6};
		insertSort.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
