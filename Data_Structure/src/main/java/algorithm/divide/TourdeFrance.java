package algorithm.divide;

import java.util.Arrays;

import algorithm.incremental.order.ASC;


/** * @author  wenchen 
 * @date 创建时间：2017年11月28日 上午11:21:28 
 * @version 1.0 
 * Tour de France 问题:
 * 	自行车的驱动系统包含很多齿轮。齿轮通常分成两组：前端齿轮和后端齿轮。
 * 自行车就是通过链接一个前端齿轮和一个后端齿轮来驱动的。设有f个前端齿轮，r个后端齿轮，
 * 每个前端齿轮i有m[i]个齿，i=1,...,f。每个后端齿轮j有n[j]个齿，j=1，....，r。
 * 共有f*r个可能的驱动率d[k]=n[j]:m[i]。
 * 若d1<d2且不存在d3使d1<d3<d2。则该驱动率为d2/d1
 * 
 *问题分析：
 *	先遍历(后轮为外层循环)，得到驱动率数组，
 *	然后数组排序得到速度数组，然后再在速度数组中找最大值
 * @parameter */
public class TourdeFrance {
	
	/**
	 * 
	 * @param m 前端齿轮数组
	 * @param n 后端齿轮数组
	 */
	public static void TourdeFrance (int[] m,int[] n){
		int m_length=m.length;
		int n_length=n.length;
		int k=0;
		double[] arr = new double[m_length*n_length];
		//得到驱动率数组
		for (int i=0;i<n_length;i++){
			for (int j=0;j<m_length;j++){
				arr[k++]=((double)n[i])/((double)m[j]);
			}
		}
		//对驱动率数组进行排序
		Arrays.sort(arr);
		//得到速度数组
		Comparable[] speed = new Comparable[arr.length-1];
		for (int i=0;i<arr.length-1;i++){
			speed[i]=arr[i+1]/arr[i];
		}
		//再找最大值
 		System.out.println("Result="+Select.getSelect(Arrays.asList(speed), 0, speed.length-1, speed.length, new ASC()));
	}
	
	public static void main(String[] args) {
		int[] m = {1,2,33,4,55,6};
		int[] n = {7,88,9,11,12,12};
		TourdeFrance(m, n);
	}
}
