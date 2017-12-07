package algorithm.dynamic;



/** * @author  wenchen 
 * @date 创建时间：2017年12月1日 上午11:19:32 
 * @version 1.0 
 * 动态规划——计算基因序列相似度
 * 问题：
 * 	人类基因是由A、C、G、T这4种核苷组成的序列。为比较两个基因序列的相似程度，可在必要的位置上添加“-”,
 * 使得两个基因序列的长度一致，然后按照对应的相似度表来计算相似度
 * 分析：
 * 	可将问题变成两个由{A、C、G、T}中的符号组成的序列X,Y和计分矩阵A。求X,Y的相似度
 * (符合动态规划的特征)
 * 递归式：
 * 设m[i,j]表示Xi和Yj的相似度。而Xi,Yj分别表示X的前i个序列和Y的前j个序列。
 * 	1.i=0且j=0,返回0
 * 	2.i=0且j>0,m[i][j]=m[0][j-1]+A[-][Yj]
 * 	3.i>0且j=0,m[i][j]=m[i-1][0]+A[Xi][-]
 * 	4.i>0且j>0,m[i][j]=max{m[i-1][j-1]+A[Xi][Yj],m[i-1][j]+A[Xi][-],m[i][j-1]+A[-][Yj]}
 * (这个地方分3种情况：
 * 1.X取i对应的序列，Y取j对应的序列--->m[i-1][j-1]+A[Xi][Yj]
 * 2.X取i对应的序列，Y取-  ----->m[i-1][j]+A[Xi][-]
 * 3.X取-，Y取j对应的序列  ----->m[i][j-1]+A[-][Yj])
 * A ---->0
 * C ---->1
 * G ---->2
 * T ---->3
 * - ---->4
 * @parameter */
public class HumanGene {

	public static int[][] getGene (int[] x,int[] y,int[][] arr){
		int m = x.length,n = y.length;
		int[][] result = new int[m+1][n+1];
		//先初始化结果数组
		result[0][0] = 0;
		//i=0的情况
		for (int j=1;j<=n;j++){
			result[0][j] = result[0][j-1]+arr[4][y[j-1]];
		}
		//j=0的情况的初始化
		for (int i=1;i<=m;i++){
			result[i][0] = result[i-1][0]+arr[x[i-1]][4];
		}
		//一般情况
		for (int i=1;i<=m;i++){
			for (int j=1;j<=n;j++){
				int max = result[i-1][j-1]+arr[x[i-1]][y[j-1]];
				if (max < result[i-1][j]+arr[x[i-1]][4]) {
					max = result[i-1][j]+arr[x[i-1]][4];
				}
				if (max < result[i][j-1]+arr[4][y[j-1]]){
					max = result[i][j-1]+arr[4][y[j-1]];
				}
				result[i][j] = max;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		for (int i=0;i<arr.length;i++){
			for (int j=0;j<arr[i].length;j++){
				int a = Math.abs(i-j);
				if (a==0){
					if (i!=4){
						arr[i][j]=5;
					} else {
						arr[i][j]=0;
					}
				}
			}
		}
		//A
		arr[0][1]=-1;arr[0][2]=-2;arr[0][3]=-1;arr[0][4]=-3;
		//C
		arr[1][0]=-1;arr[1][2]=-3;arr[1][3]=-2;arr[1][4]=-4;
		//G
		arr[2][0]=-2;arr[2][1]=-3;arr[2][3]=-2;arr[2][4]=-2;
		//T
		arr[3][0]=-1;arr[3][1]=-2;arr[3][2]=-2;arr[3][4]=-1;
		//-
		arr[4][0]=-3;arr[4][1]=-4;arr[4][2]=-2;arr[4][3]=-1;
		int[] x= {0,2,3,2,0,3,2};
		int[] y = {2,3,3,0,2};
		int[][] result = getGene(x, y, arr);
		for (int i=0;i<result.length;i++){
			for (int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
