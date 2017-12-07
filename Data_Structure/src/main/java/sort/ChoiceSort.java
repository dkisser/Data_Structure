package sort;

import java.util.Arrays;

/** * @author  wenchen 
 * @date 创建时间：2017年4月26日 下午1:13:27 
 * @version 1.0 
 * @parameter */
public class ChoiceSort {
	
	public void sort (int[] array) {
		
		if (array == null || array.length ==0) {
			
			return ;
		}
		
		for (int i=0;i<array.length;i++) {
			int min_index = i;//最下值的下标
			for (int j = i+1;j<array.length;j++) {
				if (array[j] < array[min_index]) {
					min_index = j;
				}
			}
			//找到最小值后再交换位子
			if (min_index != i) {
				int temp = array[i];
				array[i] = array[min_index];
				array[min_index] = temp;
			}
		}
	}
	public static void main(String[] args) {
		ChoiceSort choiceSort = new ChoiceSort();
		int[] array = new int[]{3,2,1,1,5,4,7,9,8,6,6};
		choiceSort.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
