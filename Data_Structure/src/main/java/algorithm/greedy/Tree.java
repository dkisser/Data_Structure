package algorithm.greedy;
/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月7日 下午4:20:45 
 * @version 1.0 
 * @parameter
 */
public class Tree {
	private Vertex[] key;
	
	private int[] parent;

	public Tree(Vertex[] key, int[] parent) {
		this.key = key;
		this.parent = parent;
	}

	public Vertex[] getKey() {
		return key;
	}

	public void setKey(Vertex[] key) {
		this.key = key;
	}

	public int[] getParent() {
		return parent;
	}

	public void setParent(int[] parent) {
		this.parent = parent;
	}
}
