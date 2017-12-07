package algorithm.greedy;
/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月6日 下午12:58:54 
 * @version 1.0 
 * @parameter
 */
public class BinaryTree implements Comparable<BinaryTree>{

	private int key;
	
	private char element;
	
	private BinaryTree left; 
	
	private BinaryTree right;
	
	public BinaryTree() {}

	public BinaryTree(int key, char element, BinaryTree left, BinaryTree right) {
		this.key = key;
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public char getElement() {
		return element;
	}

	public void setElement(char element) {
		this.element = element;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	@Override
	public int compareTo(BinaryTree o) {
		if (key > o.getKey()){
			return 1;
		} else if (key < o.getKey()){
			return -1;
		}
		return 0;
	}
	
	//中序遍历
	public void inorderWalk (){
		if (left!=null){
			left.inorderWalk();
		}
		System.out.print(toString()+"\t");
		if (right!=null){
			right.inorderWalk();
		}
	}
	
	@Override
	public String toString() {
		return "character:"+element+" frequncy:"+key;
	}
	
}
