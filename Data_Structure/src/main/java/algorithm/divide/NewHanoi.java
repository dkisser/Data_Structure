package algorithm.divide;

import java.util.Arrays;


/** * @author  wenchen 
 * @date 创建时间：2017年11月22日 下午2:10:13 
 * @version 1.0 
 * @parameter 
 * 问题描述：
 * 	有n个盘子，分别放置在三根柱子上（小盘在大盘上）。我们要将这些盘子中的特定的盘子放到特定的柱子上。
 * 	求最小移动次数？
 * */
public class NewHanoi {
	
	/**
	 * Hanoi移动
	 * @param current 用于记录盘子当前所在柱子  如current={A,A,A,B,B,B,C,C,C}表示前三个盘子在A柱子中....
	 * (这里的current里面是从上到下编号的)
	 * @param n 要移动的盘子个数
	 * @param a 初始位置
	 * @param b 过渡位置
	 * @param c 目标位置
	 */
	public static int Hanoi(String[] current,int n,String a,String b,String c){
		int count = 0;
		int top = n-1;
		if (n == 1) {
			top = getTop(current, a);
			System.out.print(a+"-->"+c+" ");
			count++;
			current[top]=c;
			return count;
		}
		//先将n-1个盘子从a经c移动到b上
		count += Hanoi(current,n-1,a,c,b);
		//将最大的一个盘子从a移动到c
		System.out.print(a+"-->"+c+" ");
		current[top]=c;
		count++;
		//再将n-1个盘子从b经a移动到c
		count += Hanoi(current, n-1, b, a, c);
		return count;
	}
	
	private static int getTop(String[] current,String s){
		for (int i = 0;i<current.length;i++) {
			if (current[i].equals(s)) {
				return i;
			}
		}
		return 0;
	}
	/**
	 * 将current[1,...,i]放到位于current[i]的那一根杆子上
	 * @param current
	 * @param i 代表的是在current数组中的位置
	 */
	private static int genTower (String[] current,int i){
		int count = 0;
		if (i==0){
			return 0;
		}
		if (i==1) {
			//将i-1放到i的杆子上
			if (!current[i].equals(current[i-1])) {
				System.out.println(current[i-1]+"-->"+current[i]);
				count++;
				current[i-1]=current[i];
			}
			return count;
		}
		//三个盘子分别在三个柱子上
		if (i>=2&&!current[i].equals(current[i-1])&&!current[i].equals(current[i-2])&&!current[i-1].equals(current[i-2])) {
			//先将i-2之前的盘子放到i-2那根柱子上
			count+=genTower(current, i-2);
			//将i-1放到i上
			System.out.print(current[i-1]+"-->"+current[i]+" ");
			String temp = current[i-1];//用于保存移动盘子之前的位置
			current[i-1]=current[i];
			count++;
			//移动i-2,经i-1到i上
			count+=Hanoi(current, i-1, current[i-2], temp, current[i]);
			return count;
		}
		//三个盘子至少有两个位于一个盘子上
		count+=genTower(current, i-1);
		//i-1号盘子和i号盘子不在同一根柱子上
		if (!current[i-1].equals(current[i])){
			String temp = getOther(current, current[i-1], current[i]);
			count+=Hanoi(current, i-1, current[i-1], temp, current[i]);
		}
		return count;
	}
	//找到除a,b之外的第三根杆
	private static String getOther (String[] current,String a,String b){
		for (int i=0;i<current.length;i++) {
			if (!current[i].equals(a)&&!current[i].equals(b)) {
				return current[i];
			}
		}
		return null;
	}
	
	public static int NewHanoi (String[] current,String[] target) {
		int count = 0;
		int k = 0;
		//先从大到小的遍历，找到需要移动的盘子
		for (int i=current.length-1;i>=0;i--) {
			if (!current[i].equals(target[i])) {
				k=i;
				break;
			}
		}
		if (k>1) {
			count += genTower(current, k-1);
			System.out.println("生成的新的塔:"+Arrays.asList(current));
		}
		for (;k>0;k--) {
			if (!current[k].equals(target[k])) {
				String temp = getOther(current, current[k], target[k]);
				//1....k-1在k上面
				if (current[k-1].equals(current[k])) {
					count += Hanoi(current, k, current[k], target[k], temp);
					//1...k-1已经在目标位置了
				} else if (current[k-1].equals(target[k])) {
					count += Hanoi(current, k, target[k], current[k], temp);
				}
				System.out.println(current[k]+"-->"+target[k]+" ");
				current[k]=target[k];
				count ++;
			}
		}
		
		//看一号盘是否需要移动
		if (!current[0].equals(target[0])) {
			System.out.print(current[0]+"-->"+target[0]);
			current[0] = target[0];
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
//		String[] current={"A","A","A","A"};
//		System.out.println("Count="+Hanoi(current, current.length,"A", "B", "C"));
//		System.out.println(Arrays.asList(current));
		String[] current = {"B","B","B","C","A","A","A","A","B","B","C"};
		String[] target = {"B","B","B","B","B","B","B","C","B","B","C"};
		System.out.println("Count="+NewHanoi(current, target));
	}
}
