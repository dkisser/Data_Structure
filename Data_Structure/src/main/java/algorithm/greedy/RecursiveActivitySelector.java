package algorithm.greedy;


/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月5日 下午2:18:01 
 * @version 1.0 
 * 贪婪算法——活动选择问题
 * 问题描述：
 * 	有n个需要使用同一个诸如教室这样的资源的活动，每次只能有一个活动使用该资源。每一个活动有一个开始时间si和一个完成时间fi,其中0<=si<fi<∞。
 * 若活动ai被选取，则它在半闭半开区间[si,fi]内发生。如果区间[si,fi]和[sj,fj]不相交，则活动ai和aj是相容的。求选取一个由相容活动构成的最大集合。
 * 形式化输入输出：
 * 	将问题变成形式化的输入和输出。
 * 	输入：
 * 	两个数组S和F，分别表示i的开始时间和结束时间。
 * 	输出：
 * 	表示一个相容活动组的数组{x1,x2,...,xn},其中0表示不再相容活动组中，1表示在相容活动组中
 * 分析：
 * 	设Sij是由与ai和aj相容的活动构成。为表示所有问题，我们假设两个活动a0和an+1并约定f0=0以及fn+1=∞。
 * 于是S=So n+1，而i和j的取值范围为0<=i，j<=n+1。
 * 	假定各活动按完成时间的单调增加顺序排列。
 * 	根据Sij的定义，显然只要i>=j，就有Sij=∅。于是，我们的子问题空间就在0<=i<j<=n+1中选取最大的相容活动子集。
 * 	假定Sij的一个解包含活动ak,所以fi<=sk<fk<=sj。利用ak产生两个子问题，Sik和Skj，每一个都构成Sij中的活动的子集。设Aij是Sij的一个最优解,ak∈Aij
 * 则Aij中Sik的解Aik和Skj的解Akj也必是最优的。那么我们就可以推出最优子结构。
 * 最优子结构：
 * 	1.Sij=∅,c[i,j]=0
 * 	2.Sij!=∅,c[i,j]=max{c[i][k]+c[k][j]+1}
 * 贪婪选择性：
 * 	我们可以看出最优子结构中的时间复杂度为O（n三次方），如果能一次性确定k的取值，那么就要可以减少循环的次数。
 * 贪婪选择：
 * 	设am为Sij中最早完成的一个活动：
 * 	fm={fk:ak∈Sij}
 * 则有以下两个假设：
 * （1）活动am包含在Sij的一个最大相容活动子集合中。
 * （2）子问题Sim是空的，所以选择am将使得Smj成为仅有的非空子问题。
 * 证明第一个假设：
 *  我们假定Aij是Sij的一个最大相容活动子集合，并将Aij中的活动按时间单调增加的顺序排列。设ak是Aij中的第一个活动。
 *  若ak=am。则上面的假设一成立。
 *  若ak!=am,则我们构造一个集合Aij1=Aij-{ak}∪{am}。Aij1中的活动是互不相交的，这是因为ak是Aij中第一个完成的活动，且fm<=fk。注意到Aij和Aij1所含的活动数是一样的，
 *  而Aij1又是Sij所包含am的最大相容活动子集。所以结论一还是成立的。
 * 证明第二个假设：
 * 	假定Sim非空，所以有活动ak使得fi<=sk<fk<=sm<fm,而ak也在Sij中，而且是一个比am更早的活动，这与am是最小的矛盾，于是Sim是空的。
 * @parameter
 */
public class RecursiveActivitySelector {
	
	public static int[] result;
	public static int[] selector(int[] s,int[] f,int i,int j){
		//找到Sij中的第一个活动
		int m = i+1;
		while(m<j&&s[m]<f[i]){
			result[m++]=0;
		}
		if (m<j){
			result[m] = 1;
			selector(s, f, m, j);
		}
		return result;
	}
	public static void main(String[] args) {
		//这里在第一个元素前加0是为了更好的找到第一个活动，而在最后一个元素后加最大值，是为了让最后一个元素能参与比较
		int[] s={0,1,3,0,5,3,5,6,8,8,2,12,Integer.MAX_VALUE},
			  f={0,4,5,6,7,8,9,10,11,12,13,14,Integer.MAX_VALUE};
		RecursiveActivitySelector.result = new int[s.length];
		selector(s, f, 0, s.length-1);
		for (int i=0;i<RecursiveActivitySelector.result.length;i++){
			System.out.print(RecursiveActivitySelector.result[i]+"\t");
		}
		
	}
	
}
