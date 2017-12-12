package algorithm.greedy;

import java.awt.Point;
import java.util.Arrays;

import algorithm.divide.PrioQueue;
import algorithm.incremental.order.ASC;

/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月8日 下午1:50:41 
 * @version 1.0 
 * 问题：
 * 	要将北方哨所用两种无线技术实践通信连接。P个哨所(每个哨所用坐标标识)中有S个可以使用卫星通信，卫星通信不受地理位置的限制。无线电通信接收器的功率越大，
 * 通信半径越大，费用越高。为了方便维护与管理，要用统一型号的无线收发机配置各所。使任意两个哨所之间进行直接或间接的通信，并使装备费用最低。
 * 抽象：
 * 	输入：
 * 		P个哨所的坐标:A={(X1,Y1),(X2,Y2),...,(Xp,Yp)}。可以使用卫星通信的哨所数S。
 * 	输出：
 * 		连接所有哨所的通信网络中所配备无限收发器的最小覆盖半径D。
 * 分析：
 * 	我们可以将每一个哨所视为一个图的顶点，哨所间的距离作为两顶点间边的权值。这样将得到一个具有P个顶点的带权完全图。我们只需要求出最小生成树即可。
 * 但是，在最小生成树中要有S个点(S-1条边)是使用卫星通信的，所以我们要在最小生成树中对最长的S-1条边配置卫星通信，然后再在剩下的最小生成树中求
 * 最长的边。但是要注意，最小生成树的权值虽然唯一，但是最小生成树并不唯一。所以我们要先将所有的最小生成树求出来，在遍历，然后去掉最长的S-1条边。
 * 用一个变量记录最小的覆盖半径D。当遍历完成即可求得D。
 * @parameter
 */
public class ArticNetwork {

	public static double articNetwork (Point[] a,int s){
		double[][] w = getGraphEdge(a);
		double d = Double.POSITIVE_INFINITY;//d=∞，d表示各个最小生成树中最长的权边对应的值。
		for (int i=0;i<a.length;i++){
			Tree tree = null; 
			try {
				tree = MST.Prim(w, i);//得到最小生成树
			} catch (Exception e) {
				e.printStackTrace();
			}
			int n = s;
			//将得到的最小生成树的各个边都放到一个最大优先队列中
			Vertex[] key = tree.getKey();
			PrioQueue que = new PrioQueue(new ASC());
			for (int j=0;j<key.length;j++){
				que.enQueue(key[j]);
			}
			boolean[] poped_u=new boolean [n];//标记U是否出队
			boolean[] poped_v =new boolean [n];//标记V是否出队
			Arrays.fill(poped_u, false);
			Arrays.fill(poped_v, false);
			//将最长的S-1条边给逐一出队
			while(n>1){
				Vertex pre = null;
				try {
					pre = (Vertex) que.deQueue();
				} catch (Exception e) {
					e.printStackTrace();
				}
				int u = pre.getIndex();
				int v = 0;
				//找到长度对应的两个u,v端点
				for (int j=0;j<w.length;j++){
					if (w[u][j]==pre.getWeight()){
						v= j;
					}
				}
				if (!poped_u[u]){
					n--;
				}
				if (!poped_v[v]){
					n--;
				}
			}
			//将剩余的队列中最长的一个边得到
			Vertex pre = null;
			try {
				pre = (Vertex) que.deQueue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			int u = pre.getIndex();
			int v = 0;
			//找到长度对应的两个u,v端点
			for (int j=0;j<w.length;j++){
				if (w[u][j]==pre.getWeight()){
					v= j;
					break;
				}
			}
			if (w[u][v]<d){
				d = w[u][v];
			}
		}
		return d;
	}
	
	//根据传入的点的数组得到两点之间的权边的数组
	public static double[][] getGraphEdge (Point[] a){
		int n = a.length;
		double[][] result = new double[n][n];
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				result[i][j] = a[i].distance(a[j]);
			}
		}
		return result;
	}
	
}
