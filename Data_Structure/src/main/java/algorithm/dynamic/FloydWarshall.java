package algorithm.dynamic;
/** * @author  wenchen 
 * @date 创建时间：2017年12月2日 下午1:50:16 
 * @version 1.0 
 * 动态规划）——带权有向图中任意两点间的最短路径
 * 问题描述：
 * 	输入： 带权有向图的M*N矩阵W(其中W[i][j]表示从i到j的权值，若是无法到达则为Interger.MAXVALUE)
 * 	输出：对任意的两个点之间的最短距离。
 * 分析：
 * 	设G=<V,E>的两个不同的顶点i,j属于V={1,2,..,N},p是从i到j其间不经过{k+1,...,n}的最短路径
 * 最优子结构：
 * 	1.若p不经过k点，则说明p也是i到j其间不经过{k,k+1,...,n}的最短路径
 * 	2.若p经过k点，则p1也是从i到k其间不经过{k,k+1,...n}的最短路径，p2也是k到j其间不经过{k,k+1,...,n}的最短路径
 * @parameter */
public class FloydWarshall {

	private static final int MAX_VALUE=10000;
	
	public static void floydWarshall (int[][] w,int [][] d){
		//d用来保存最短路径的前驱节点，当前只是初始化。得到的并不是最短路径的前驱节点值
		for (int i=0;i<w.length;i++){
			for (int j=0;j<w.length;j++){
				if (i==j||w[i][j]==MAX_VALUE){
					d[i][j]=0;
				} else {
					d[i][j] = i+1;
				}
			}
		}
		for (int k=0;k<w.length;k++){
			for (int i=0;i<w.length;i++){
				for (int j=0;j<w[i].length;j++){
					if (w[i][j]>w[i][k]+w[k][j]){
						//说明此处的最短吧路径并不是i到j,而是i到k,k到j的路径之和
						w[i][j] = w[i][k]+w[k][j];
						//之所以是k到j的前驱是因为我们要找的i到j的最短路径是由i到k和k到j这两个最短路径组成
						//而由于我们是要找j的前驱节点，所以我们可将问题转换成找k到j的前驱节点
						d[i][j] = d[k][j];
					}
				}
			}
		}
	}
	
	public static void printPath (int[][] d,int i,int j){
		if (i==j){
			System.out.print(i+"——");
		} else if (d[i][j]==0){
			System.out.println("No Path form"+i+"to"+j);
		} else {
			printPath(d, i, d[i][j]-1);
			System.out.println(j);
		}
	}
	
	public static void main(String[] args) {
		int [][] w = new int[5][5];
		for (int i=0;i<w.length;i++){
			for (int j=0;j<w[i].length;j++){
				if (i==j){
					w[i][j] = 0;
				}
			}
		}
		final int max = 1000;
		w[0][1]=3;w[0][2]=8;w[0][3]=MAX_VALUE;w[0][4]=-4;
		w[1][0]=MAX_VALUE;w[1][2]=MAX_VALUE;w[1][3]=1;w[1][4]=7;
		w[2][0]=MAX_VALUE;w[2][1]=4;w[2][3]=MAX_VALUE;w[2][4]=MAX_VALUE;
		w[3][0]=2;w[3][1]=MAX_VALUE;w[3][2]=-5;w[3][4]=MAX_VALUE;
		w[4][0]=MAX_VALUE;w[4][1]=MAX_VALUE;w[4][2]=MAX_VALUE;w[4][3]=6;
		for (int i=0;i<w.length;i++){
			for (int j=0;j<w[i].length;j++){
				System.out.print(w[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("——————————————————————");
		int[][] d = new int[w.length][w.length];
		floydWarshall(w,d);
		for (int i=0;i<w.length;i++){
			for (int j=0;j<w[i].length;j++){
				System.out.print(w[i][j]+"\t\t");
			}
			System.out.println();
		}
		System.out.println("——————————————————————");
		for (int i=0;i<d.length;i++){
			for (int j=0;j<d[i].length;j++){
				System.out.print(d[i][j]+"\t\t");
			}
			System.out.println();
		}
		printPath(d, 0, 4);
	}
	
}
