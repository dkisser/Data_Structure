package algorithm.dynamic;

import java.util.Arrays;

import algorithm.incremental.order.DESC;


/** * @author  wenchen 
 * @date 创建时间：2017年11月30日 下午2:22:42 
 * @version 1.0 
 * 问题：
 * 	(最长公共子序列问题)注：最长子序列不一定是连续的，但还是必须是有序的。如<B,A,D,C,A>和<B,B,D,C,A>的最长公共子序列是<B,D,C,A>而不是<A,B,C,D>
 * 	在很多应用中需要比较两个串的相似性。通过求两个串的最长子串的长度，即可求得相似度
 * 分析：
 * 	这也是组合优化问题。抽象出来其实就是在一堆公共子序列(可行解)中计算出最长公共子序列(最优解)
 * 最优子结构：
 * 	两个序列分别为X<X1,x2,...,xm>和Y<y1,y2,...,yn>。设Z<z1,z2,...,zk>为这两个序列的最长公共子序列
 * 	Xi表示X序列的前4个同理Yj也是一样
 * 	分三种情况
 * 	1.Xm=Yn即两个序列的长度相同时，则zk-1也为xm-1和yn-1的最长公共子序列。
 * 	2.Xm!=Yn就要找xm-1和Yn的LCS和Xm和Yn-1的LCS中最长的一个
 * 	3.若i=0或j=0则公共子序列为0
 * 子结构的重叠性：
 * 	根据公式再带入两个实际的M和N，我们可以看到有很多问题的解都依赖重复的子问题的解。
 * @parameter */
public class LCS {
	
	public static int[][] getLCS (Comparable [] x,Comparable [] y){
		int m = x.length,n=y.length;
		int [][]result = new int [m+1][n+1];
		//将i=0或j=0的列全部置0
		for (int i=0;i<m+1;i++){
			result[i][0] = 0; 
		}
		for (int i=0;i<n+1;i++){
			result[0][i] = 0; 
		}
		//根据函数规则写循环
		for (int i=1;i<m+1;i++){
			for (int j=1;j<n+1;j++){
				//判断xi与yj是否相等
				if (x[i-1].compareTo(y[j-1])==0){
					result[i][j] = result[i-1][j-1]+1;
				} else if (result[i-1][j]>=result[i][j-1]){
					result[i][j] = result[i-1][j];
				} else {
					result[i][j] = result[i][j-1];
				}
			}
		}
		return result;
	}

	public static void printLCS (int[][] result,Comparable[] x,Comparable[] y,int i,int j){
		if (i==0||j==0){
			return ;
		}
		if (x[i-1].compareTo(y[j-1])==0){
			printLCS(result, x, y, i-1, j-1);
			System.out.print(x[i-1]+"\t");//因为输出的是x中的第i个，而在数组中要-1
		} else if (result[i-1][j] >= result[i][j-1]){
			printLCS(result, x, y, i-1, j);
		} else {
			printLCS(result, x, y, i, j-1);
		}
		
	}
	
	public static int[][] shootEagle (Comparable[] x){
		Comparable[] x1 = Arrays.copyOf(x, x.length);
		Arrays.sort(x1, new DESC());
		return getLCS(x, x1);
	}
	
	public static void main(String[] args) {
		Integer[] a = {389,207,155,300,299,170,158,65};
		Comparable[] x1 = Arrays.copyOf(a, a.length);
		int [][] result = shootEagle(a);
		for (int i=0;i<result.length;i++){
			for (int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
		Arrays.sort(x1,new DESC());
		printLCS(result, a, x1, 8, 8);
	}
	
}
