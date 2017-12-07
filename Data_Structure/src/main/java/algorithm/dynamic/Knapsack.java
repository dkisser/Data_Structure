package algorithm.dynamic;


/** * @author  wenchen 
 * @date 创建时间：2017年12月1日 下午2:40:41 
 * @version 1.0 
 * 动态规划——0-1背包问题
 * 问题：
 * 	有N种物品，第i种物品的重量为Wi,价值为Vi,i=1,...,n。给定一个背包，最多能装重为C的物品。
 * 问将哪些物品放到背包中能使得包中所装物品总价值最大？
 * 分析：
 * 	结果可用一个向量来表示x=(x1,x2,..,xi)其中xi=1表示包在其中，xi=0表示包不在其中
 * 最优子结构：
 * 设y=(y1,...,yn)是W=(w1,...,wi)和V=(v1,...,vi)，数值为j的最优解
 * 	1.若wi>j,则说明yi-1是wi-1和vi-1数值为j的最优解
 * 	2.若wi<=j且yi=0，则说明yi-1是wi-1和vi-1数值为j的最优解
 * 	3.若wi<=j且yi=1，则说明yi-1是wi-1和vi-1数值为j-wi的最优解
 * @parameter */
public class Knapsack {

	public static int[][] getMaxValue (int[] w,int[] v,int c){
		int m = w.length;
		int[][] result = new int[m+1][c+1];
		//先设置当c=0时所有都为0
		for (int i=0;i<=m;i++){
			result[i][0] = 0;
		}
		//再设置当i=0时所有都为0
		for (int j=1;j<=c;j++){
			result[0][j] = 0;
		}
		for (int i=1;i<=m;i++){
			for (int j=1;j<=c;j++){
				if (w[i-1]>j){
					result[i][j] = result[i-1][j];
				} else if (w[i-1]<=j){
					int max = v[i-1]+result[i-1][j-w[i-1]];
					if (max < result[i-1][j]){
						max = result[i-1][j];
					}
					result[i][j] = max;
				}
			}
		}
		return result;
	}
	
	public static int[] buildSolution (int[][] result,int c,int[] w){
		int n = w.length;
		int j = c;
		int[] knapsack = new int[n];
		for (int i=n;i>0;i--){
			if (result[i][j]==result[i-1][j]){
				knapsack[i-1] = 0;
			} else {
				knapsack[i-1] = 1;
				j = j-w[i-1];
			}
		}
		return knapsack;
	}
	
	public static int abacus (int[] p,int[] k,int[] c){
		int max = 0;
		int m = c.length;
		int[] newp = null,newk=null;
		for (int i=0;i<m;i++){
			newp = extendP(p, k, c[i]);
			newk = extendK(p, k, c[i]);
			int n = newp.length;
			int[][] result = getMaxValue(newp, newk, c[i]);
			max += result[n][c[i]];
		}
		return max;
	}
	
	private static int[] extendP (int[] p,int[] k,int c){
		int n=p.length;
		int[] newp = null;
		for (int i=0;i<n;i++){
			int min = getMin(p[i], c);
			newp = new int[min];
			for (int j=1;j<=min;j++){
				newp[j-1]=j*p[i];
			}
		}
		int[] p1 = new int[n+newp.length];
		for (int i=0;i<n;i++){
			p1[i] = p[i];
		}
		for (int i=0;i<newp.length;i++){
			p1[n+i] = newp[i];
		}
		return p1;
	} 
	private static int[] extendK (int[] p,int[] k,int c){
		int m = k.length;
		int[] newk=null;
		for (int i=0;i<m;i++){
			int min = getMin(p[i], c);
			newk = new int[min];
			for (int j=1;j<=min;j++){
				newk[j-1]=j*k[i];
			}
		}
		int[] k1 = new int[m+newk.length];
		for (int i=0;i<m;i++){
			k1[i] = k[i];
		}
		for (int i=0;i<newk.length;i++){
			k1[m+i] = newk[i];
		}
		return k1;
	} 
	
	private static int getMin (int p,int c){
		for (int i=1;;i++){
			if (i*(i+1)*p/2>c){
				return i-1;
			} else if (i*(i+1)*p==c){
				return i;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] w = {2,3,4,5};
		int[] v = {3,4,5,7};
		int[][] result = getMaxValue(w, v, 7);
		for (int i=0;i<result.length;i++){
			for (int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
		int[] knapsack = buildSolution(result, 7, w);
		for (int i=0;i<knapsack.length;i++){
			System.out.print(knapsack[i]+"\t");
		}
		System.out.println("最大回扣"+abacus(w, v, new int[]{10,20,30,100}));
	}
	
}
