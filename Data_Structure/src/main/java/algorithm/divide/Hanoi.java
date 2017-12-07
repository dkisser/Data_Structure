package algorithm.divide;
/** * @author  wenchen 
 * @date 创建时间：2017年11月22日 上午10:52:04 
 * @version 1.0 
 * 分冶算法——Hanoi塔问题
 * @parameter */
public class Hanoi {

	/**
	 * 推理思路：
	 * 	若n=1时，直接将a挪到c处
	 * 	若n=2时，先将上面一个盘子挪到b，再将下面的那个挪到c，最后将b处的挪到c处。
	 *  若n=3时，先将上面两个盘子挪到b，再将最下面的那个挪到c，最后将b处的两个盘子挪到c。
	 *  .
	 *  .
	 *  若n=n时，现将上面的n-1个盘子挪到b，再将最下面的一个盘子挪到c，最后将b处的n-1个盘子挪到c
	 * @param n 表示Hanoi塔的层数
	 * @param a 初始杆
	 * @param b 过度杆
	 * @param c 目标杆
	 */
	public static int Hanoi(int n,String a,String b,String c){
		int count = 0;
		if (n==1) {
			count ++;
			System.out.print(a+"-->"+c+" ");
			return count;
		}
		//将上面的n-1个盘子从a点经c点挪到b点
		count +=Hanoi(n-1, a, c, b);
		//将最下面的一个盘子从a移动到c
		count++;
		System.out.print(a+"-->"+c+" ");
		//再将n-1个盘子从b点经a点移动到c点
		count+=Hanoi(n-1, b, a, c);
		return  count;
	}
	public static void main(String[] args) {
		System.out.println("Count="+Hanoi(3, "A", "B", "C"));
	}
}
