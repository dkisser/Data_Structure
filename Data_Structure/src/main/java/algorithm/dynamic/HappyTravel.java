package algorithm.dynamic;
/** * @author  wenchen 
 * @date 创建时间：2017年12月2日 上午10:59:41 
 * @version 1.0
 * 问题：
 * 	 一对夫妻外出旅游，带了若干件行李,每件行李都有自己的重量。他们想让彼此的行李总量尽量相等。
 * 分析：
 * 	输入：整数集合A，代表行李重量
 * 	输出：整数集合B1和B2的元素之和W1和W2。其中，B1和B2是A的一个划分，且差值|W1-W2|为最小
 * 抽象：
 * 	可将问题变成0-1背包问题。讲w同时也设为他的价值，将目标值设为W/2。
 * @parameter */
public class HappyTravel {
	
	public static int[][] getWeight(int[] weight,int[] value,int c){
		int m = weight.length;
		int[][] result = new int[m+1][c+1];
		//先初始化i=0的时候的值,即当背包里面为空的时候
		for (int j=0;j<=c;j++){
			result[0][j] = 0;
		}
		//再初始化j=0的时候，即目标值为0的时候
		for (int i=0;i<=m;i++){
			result[i][0] = 0;
		}
		//计算背包的时候的判定条件为wi<=j？
		for (int i=1;i<=m;i++){
			for (int j=1;j<=c;j++){
				if (weight[i-1]>j){
					result[i][j] = result[i-1][j];
				} else {
					//这里看加上i的重量后的值和没加上i的值哪个比较大，去最大值。
					int max = result[i-1][j-weight[i-1]];
					if (max <= result[i-1][j-1]+value[i-1]){
						max = result[i-1][j-1]+value[i-1];
					}
					result[i][j] = max;
				}
			}
		}
		return result;
	}
	
	public static int[] buildSolution (int[][] result,int[] weight,int c){
		int[] arr = new int[weight.length];
		int j= c; 
		for (int i=weight.length;i>0;i--){
			//相等则说明result[i-1][j]为其子问题的最优解
			if (result[i][j]==result[i-1][j]){
				arr[i-1] = 0;
			} else {
				arr[i-1] = 1;
				j -= weight[i-1];
			}
		}
		return arr;
	}
	
	public static void happyTravel (int[] weight){
		int sum = 0;
		for (int i=0;i<weight.length;i++){
			sum+=weight[i];
		}
		int[][] result = getWeight(weight, weight, sum/2);
		int[] arr = buildSolution(result, weight, sum/2);
		System.out.println("————————————————————");
		for (int i=0;i<result.length;i++){
			for (int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("————————————————————");
		for (int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
	}
	
	public static void main(String[] args) {
		int[] a = {11,5,4,3,3,5};
		happyTravel(a);
	}
	
}
