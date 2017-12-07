package algorithm.dynamic;
/** * @author  wenchen 
 * @date 创建时间：2017年11月28日 下午1:12:10 
 * @version 1.0 
 * 动态规划——矩阵链乘法
 * 问题：
 * 	给定一个由n个矩阵构成矩阵序列<A1,...,An>,要将它们相乘(假定它们按此序列是乘法相容的：Ai是Pi-1*Pi矩阵，而Ai+1是Pi*Pi+1矩阵)，
 * 计算积： A1,A2,A3...An
 * @parameter */
public class MatrixMutiply {
	
	/**
	 * Ai的行为Pi-1，列为Pi
	 * @param p 代表矩阵的行列数
	 */
	public static MatrixTable matrixChainOrder (int[] p){
		int n = p.length-1,l,j,k,q;//矩阵链的总个数
		//m用来存放m[i,j]从Ai链乘到Aj的所用次数，s用来存放Ai到Aj中中断点括号的位置。
		int[][] m = new int[n+1][n+1],s = new int[n+1][n+1];
		//先初始化，使所有的长度为1的所有矩阵的结果次数为0
		for (int i=0;i<=n;i++){
			m[i][i]=0;
		}
		//用自底向上的方式。先算长度为2的矩阵链...一直算到长度为n
		for (l=2;l<=n;l++){
			//设置矩阵链乘开始的位置,之所以没有从0开始，是因为没有A0。矩阵链都是从A1开始的
			for (int i=1;i<=n-l+1;i++){
				j=i+l-1;//矩阵链乘结束的位置
				m[i][j]=Integer.MAX_VALUE;//先将当前路径即M[i][j]设置为最大值
				//设置断点的位置(断点在i和j之间)
				for (k=i;k<j;k++){
					q = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if (q<m[i][j]){
						m[i][j]=q;
						s[i][j]=k;
					}
				}
			}
		}
		return MatrixTable.newInstance(m, s);
	}
	
	public static void printMatrixTable (MatrixTable table,int i,int j){
		if (i==j){
			System.out.print("A"+i);
		} else {
			int[][] bracket = table.getBracket();
			System.out.print("(");
			printMatrixTable(table, i, bracket[i][j]);
			printMatrixTable(table, bracket[i][j]+1,j);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) {
		int[] p = {30,35,15,5,10,20,25};
		MatrixTable table = MatrixMutiply.matrixChainOrder(p);
		MatrixMutiply.printMatrixTable(table, 0, 6);
		System.out.println();
		System.out.println("A1——A6所需次数为："+table.getMatrix()[1][6]);
		int [][] m = table.getMatrix();
		int [][] b = table.getBracket();
		System.out.println("matrix—————————————————————");
		for (int i=0;i<m.length;i++){
			for (int j=0;j<m[i].length;j++){
				System.out.print(m[i][j]+"		");
			}
			System.out.println();
		}
		System.out.println("bracket————————————————————");
		for (int i=0;i<b.length;i++){
			for (int j=0;j<b[i].length;j++){
				System.out.print(b[i][j]+"		");
			}
			System.out.println();
		}
	}
	
}
