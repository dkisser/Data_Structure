package algorithm.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月6日 下午1:12:26 
 * @version 1.0 
 * 贪婪算法——哈夫曼编码
 * 引入：
 * 	我们把数据视为一连串的字符。Huffman的贪婪算法是利用一张记录各字符发生频率的表格建立一个将每个字符表示为二进制串的最优方式。
 * 编码概念：
 * 	假定我们希望压缩一个具有100000个字符的数据文件。其中字符a出现了45000次，b出现了13000次，c出现了12000次，d出现了16000次，e出现了9000次，f
 * 出现了5000次。我们有两种编码方式
 * 编码方式一：定长编码。编码后的定长编码字如下。
 *		a: 000	b: 001	c:010	d:011	e:100	f:101
 * 编码方式二：变长编码。编码后的变长编码字如下。
 * 		a: 0	b:101	c:100	d:111	e:1101	f:1100
 * 两种编码方式的分析：
 * 	我们要设计一种二进制编码，其中的每个字符表示唯一的二进制串。若使用定长编码，每个字符需要用3个比特来表示。那么若要编码一个有10000个字符的数据文件则需要300000个比特的空间。
 * 而使用变长编码时我们通过赋予低频字符长编码，高频字符短编码的方式使其需要的空间更小。如上诉，则我们使用变长编码的方式需要的空间为(45*1+13*3+12*3+16*11+9*4+5*4)*1000=224000比特。
 * 	从上我们可以发现，无论是采用定长编码还是采用变长编码他们都有一个共同特性：没有一个编码字成为另一个编码字的前缀。我们称这样的编码为前缀码。
 * 	为确定第一个编码字，我们利用一颗已给定的字符为树叶的二叉树的表示方法。把一个字符的二进制编码字解释为从根起到该字符的路径，其中0意为“进行到左孩子”，1意为“进行到右孩子”。
 * 若我们能将对应数据文件的前缀码的编码书T求得，则可以很轻松的算出编码一个文件所需的比特数。
 * 问题抽象：
 * 	对给定的字母集C中的每一个字符c，f(c)表示在文件中发生的频数，d(c)表示c的叶子在数中的深度，同时也表示字符c的编码字的长度。则对于该文件编码所需的比特长度为：
 * 		B(T)=∑f(c)d(c),{c,c∈C}
 * 	同一文件采用不同的编码方式会具有不同的文件长度，而最短文件长度对应的前缀码编码方案，称为该文件的一个最优编码。
 * 进一步抽象问题：
 * 	输入：给定字符集C及频数f(c)，c∈C。
 * 	输出：以C中字符为叶子的满二叉树T，是的代价B(T)=∑f(c)d(c),{c,c∈C}最小。
 * 最优子结构：
 * 	设T为C的一个最优前缀码树，T的两个孩子分别为T1和T2。设C1和C2分别是T1和T2叶子所对应的字符集。显然有C1∪C2=C，C1∩C2=∅。则T1和T2分别为C1和C2的最优前缀码树。
 * 若不然，假设对C1来说，有一颗优于T1的前缀码树，则概述的编码数一定小于T1，那么将T2和该树构成一颗新树会成为一颗最优前缀码树，这与T是最优前缀码树相冲突。所以T1和T2分别为C1和C2的最优前缀码树。
 * 贪婪选择性：
 * 	设x和y是C中的两个频数最小的字符。则：
 * 	(1)存在C的一颗最前缀码树T，在此编码数中x和y是兄弟叶子；
 * 	(2)设C'是在C中移除字符x、y并加入新的字符z的字母表，所以C'=C-{x,y}∪{z};定义C'中的f除了f[z]=f[x]+f[y]外，其余的和在C中的一样。设T'为任一颗表示C'的
 * 一个最优前缀码的树。则在树T'中将叶子z替换为以x为左孩子，y为右孩子的一个内点得到的树T为表示字母表C的一个最优前缀码的树。
 * 贪婪策略：
 * 	每一次从当前的满二叉树中(初始时每一个字符构成一个平凡树，共n棵)选择两棵频数最小的构造成一棵新的满二叉树。由于每这样操作一次，就会减少一棵树，所以
 * n-1次操作之后将构成唯一的一颗满二叉树。
 * @parameter
 */
public class Huffman {

	public static BinaryTree huffman (int[] f,char[] c){
		int i,n=f.length;
		Queue<BinaryTree> que = new PriorityQueue<BinaryTree>(n);
		//先将所有的树放到队列中,由于BinaryTree实现了Comparable所以他会自动按照优先级排序
		for (i=0;i<n;i++){
			BinaryTree t = new BinaryTree(f[i],c[i],null,null);
			que.add(t);
		}
		//执行n-1次
		for (i=0;i<n-1;i++){
			BinaryTree x = (BinaryTree) que.poll();//这里每次出队的都是key小的。
			BinaryTree y = (BinaryTree) que.poll();
			BinaryTree z = new BinaryTree(x.getKey()+y.getKey(),'*',x,y);
			que.add(z);
		}
		return (BinaryTree) que.poll();
	}
	
	public static void printCode (BinaryTree tree,String str){
		if (tree.getLeft()!=null                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ){
			printCode(tree.getLeft(), str+"0");
		}
		if (tree.getRight()!=null){
			printCode(tree.getRight(), str+"1");
		}
		if (tree.getLeft()==null&&tree.getRight()==null){
			System.out.println(tree+" code:"+str);
		}
	}
	/**
	 * 问题：
	 * 	输入：整数Z，它对应Z个字符构成的字符集B={1,...,Z};整数N它对应N个位码C={0,1...,N-1};S对应B中字符的编码字(编码字中的各个位是C中的元素)连成的串。
	 * 	输出：按1,...,Z的顺序，输出各字符的编码字。
	 * @param z
	 * @param n
	 * @param s
	 */
	public static void huffmanTrees (int z,int n,String s){
		int h = s.length();
		int[] d = getNum(s, n);
		//构造具有Z片叶子，每个内点仅有最小的孩子是内点的N叉Huffman树
		//调整树使其个叶子节点的高度h'等于S的长度h.(即若h'>h,则将内点向上移一个，然后h'-k-1)
		//调整树，使其中叶子的编码字中符号出现的次数和S中符号出现的次数相等。
		//while利用树对S进行解码，若不成功则将其向右移动，直至编码字S相等。
	}
	
	/**
	 * 功能：得到各字符在S中出现的次数
	 */
	private static int[] getNum (String s,int n){
		int[] re = new int[n];
		for (int i=0;i<s.length();i++){
			int m=Character.getNumericValue(s.charAt(i));
			int count=1;
			for (int j=0;j<s.length();j++){
				if (i!=j&&s.charAt(i)==s.charAt(j)){
					count++;
				}
			}
			re[m] = count;
		}
		return re;
	}
	public static void main(String[] args) {
		int[] f = {45,13,12,16,9,5};
		char[] c = {'a','b','c','d','e','f'};
		BinaryTree tree = huffman(f, c);
		printCode(tree, "");
		System.out.println();
		int[] re=getNum("01233211231231212312", 4);
		for (int i=0;i<re.length;i++){
			System.out.print(re[i]+" ");
		}
	}
}
