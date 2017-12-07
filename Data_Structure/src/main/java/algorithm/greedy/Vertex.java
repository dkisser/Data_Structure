package algorithm.greedy;
/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月7日 下午3:26:48 
 * @version 1.0 
 * @parameter
 */
public class Vertex implements Comparable<Vertex>{
	
	private double weight;//存放相邻节点的最小权值
	
	private	int index;//存放最小权值的下标

	public Vertex(double weight, int index) {
		this.weight = weight;
		this.index = index;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int compareTo(Vertex o) {
		if (weight > o.getWeight()){
			return 1;
		}
		if (weight < o.getWeight()){
			return -1;
		}
		return 0;
	}
	
}
