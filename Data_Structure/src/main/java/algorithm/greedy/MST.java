package algorithm.greedy;

import java.util.Arrays;

import algorithm.divide.PrioQueue;
import algorithm.incremental.order.DESC;

/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月7日 下午2:56:51 
 * @version 1.0 
 * 贪婪算法——无向连通图的最小生成树
 * 	输入：图G=<V,E>的权函数w,根节点r.
 * 	输出：该图的最小生成树T，使得W(T)最小。
 * 问题分析：
 * 	最优子结构：
 * 		这是一个组合优化问题，G有若干棵生成树，每棵生成树T均有其权值W(T)作为目标值。目的是要求具有最小目标值的生成树。
 * 	设T是G的一颗最小生成树，e是T中一条边，删去e则将T分成两部分T1和T2。假定V1和V2分别是T1和T2所包含的顶点集，G1和G2分别是
 * 	G的V1和V2的诱导子图，则T1和T2分别是G1和G2的最小生成树。
 * 	贪婪策略：
 * 		从U={r}开始，在{(x,y)|(x,y)∈E,x∈U，y∈V-U}中找权值最小的边(u,v),将(u,v)加入到T中，v加入到U中。这个算法叫Prim算法。
 * 		(即先从根开始，先将该根加入到树集合T中，再在V-T中找到与根节点权最小的值，然后将该点也加入到T中，然后重复前面的动作直到V-T=∅)
 * @parameter
 */
public class MST {
	
	public static Node Prim (double[][] w,int r) throws Exception{
		int n =w.length;
		Vertex[] key = new Vertex[n];
		int[] parent = new int[n];//用来存放父节点的下标,先初始化为-1
		boolean[] poped = new boolean[n];//用来记录该点是否已出队
		PrioQueue que = new PrioQueue(new DESC());//用来存放当前所有的边的权值的最小优先队列
		for (int i=0;i<n;i++){//先将所有的点的权值初始化为无穷大，父节点设为自己
			key[i]=new Vertex(Double.POSITIVE_INFINITY, i);
		}
		key[r].setWeight(0.0);//让其weight最小，从而作为第一个出队的
		Arrays.fill(parent, -1);
		Arrays.fill(poped, false);
		for (int i=0;i<n;i++){
			que.enQueue(key[i]);
		}
		while (!que.isEmpty()){
			int index = ((Vertex)que.deQueue()).getIndex();
			poped[index] = true;//表示该点已经出队
			for (int i=0;i<n;i++){
				if (w[index][i]>0.0){//大于0.0表示两点是可以直接到达的，即判断是不是相邻的顶点
					if (!poped[i]){//若是已经出来的就不能再选
						if (w[index][i]<key[i].getWeight()){
							parent[i]=index;
							key[i].setWeight(w[index][i]);
						}
					}
				}
				que.fixQue();
			}
		}
		return new Node(key, parent);
	}
	
	public static void main(String[] args) throws Exception {
		double[][] a = {{0,4,0,0,0,0,0,8,0},
						{4,0,8,0,0,0,0,11,0},
						{0,8,0,7,0,4,0,0,2},
						{0,0,7,0,9,14,0,0,0},
						{0,0,0,9,0,10,0,0,0},
						{0,0,4,14,10,0,2,0,0},
						{0,0,0,0,0,2,0,1,6},
						{8,11,0,0,0,0,1,0,7},
						{0,0,2,0,0,0,6,7,0}};
		double weight = 0.0;
		int n=a.length;
		Node node = Prim(a, 0);
		Vertex[] key = node.getKey();
		int[] parent = node.getParent();
		for (int i=0;i<n;i++){
			weight+=key[i].getWeight();
			if (parent[i]>=0){
				System.out.print("<"+parent[i]+","+i+"> ");
			}
		}
		System.out.println();
		System.out.println("Weight:"+weight);
	}
	
}
