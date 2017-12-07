package algorithm.dynamic;


/** * @author  wenchen 
 * @date 创建时间：2017年11月29日 下午2:41:42 
 * @version 1.0
 * 问题：
 * 	用N*N张扑克牌排成一个方阵。每块牌的点数形成一个N*N的整数网格，
 * 从左下角A[N,1]漫游到右上角A[1,N](共经过2N-1个格子),要求漫游所经路径上各个格子中整数之和最大。
 * 分析：
 * 	对于组合优化问题来讲，我们首先要看该问题是否有最有子结构。
 * 例如：在本题中我们假设A[i,j]是最优路径上的一个点。假设A[N,1]到A[1,N]的最优路径是p
 * 对于该问题来讲，从A[N,1]到A[i,j]的路径和为p1,A[i,j]到A[1,N]的路径和为p2，那么p1,p2一定分别为A[1,N]到
 * A[i,j]和A[i,j]到A[1,N]的最优路径。因为若存在有一条比p1更优的路径p3，则 p3+p2是比p更优的路径，这与假设冲突。同理对p2也成立。
 * 所以该问题具有最优子结构。
 * 	所以该问题的目标值函数如下：
 * 		设f(i,j)为A[N,1]到A[i,j]的最优路径的值之和
 *  		if i=N+1或j=0
 *  			f(i,j)=0
 *  		else 
 *  			f(i,j)=max{f(i+1,j),f(i,j-1)}+A[i,j] 
 *  		(由于这里的牌是只能横着或竖着走，所以只要找到A[N,1]到A[a+1]和A[i,j-1]中最大路径值，再加上A[i,j]即可)
 * 
 * 	接着我们要看其否具有重叠子结构问题。
 * 		根据上面的函数式。假设i=1,j=4.则会发现反复调用到了已经算过的值。
 * @parameter */
public class Solitaire {
	
	
	public static int[][] getSolitaire (int[][] p){
		int n = p.length;
		int[][] result = new int[n+1][n+1];
		//先初始化，避免出现下标为0的情况。(因为卡牌计数是从1开始的)
		for (int i=0;i<n+1;i++){
			result[i][0]=0;
		}
		for (int j=1;j<n+1;j++){
			result[n][j]=0;
		}
		for (int i=n-1;i>=0;i--){
			for (int j=1;j<n+1;j++){
				int q = result[i+1][j];
				if (q<result[i][j-1]){
					q=result[i][j-1];
				}
				result[i][j]=q+p[i][j-1];
			}
		}
		return result;
	}
	
	public static void getMaxRoad (int[][] result,int i,int j){
		System.out.format("到A[%d][%d]的最大路径的值为：%d",i,j,result[i-1][j]);
	}
	
	public static void main(String[] args) {
		int[][] p = new int[4][4];
		for (int i=0;i<p.length;i++){
			for (int j=0;j<p[i].length;j++){
				p[i][j]=p[i].length-j;
			}
		}
		System.out.println("排序前的4*4纸牌为：");
		for (int i=0;i<p.length;i++){
			for (int j=0;j<p[i].length;j++){
				System.out.print(p[i][j]+"\t");
			}
			System.out.println();
		}
		int[][] result = getSolitaire(p);
		System.out.println("结果数组：");
		for (int i=0;i<result.length;i++){
			for (int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
		getMaxRoad(result, 2, 4);
	}
}
