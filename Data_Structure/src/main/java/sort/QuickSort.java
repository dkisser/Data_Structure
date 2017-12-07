package sort;

import java.util.Arrays;

/** * @author  wenchen 
 * @date 创建时间：2017年4月24日 下午8:16:18 
 * @version 1.0 
 * @parameter */
public class QuickSort {

	    //找到排序后的位置
	    public int partition (int[] array ,int head,int tail) {
	        int key = array[head];
	        while(head < tail) {
	            while(array[tail]>=key&&head<tail){
	                tail--;
	            }
	            array[head] = array[tail];
	            while(array[head]<=key&&head<tail) {
	                head++;
	            }
	            array[tail] = array[head];
	        }
	        array[tail] = key;
	        return tail;
	    }

	    //排序
	    public void quickSort (int[] array,int head,int tail) {
	        if (head >= tail) {
	            return ;
	        }
	        int index = partition(array,head,tail);
	        quickSort(array,head,index-1);
	        quickSort(array,index+1,tail);
	    }
	    public static void main (String[] args) {
	    	QuickSort quickSort = new QuickSort();
	        int[] numbers = new int[]{3,2,1,1,5,4,7,9,8,6,6};
	        quickSort.quickSort(numbers,0,numbers.length-1);
	        System.out.println(Arrays.toString(numbers));
	    }

}
