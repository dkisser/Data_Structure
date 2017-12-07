package algorithm.incremental.order;

import java.util.Comparator;

/** * @author  wenchen 
 * @date 创建时间：2017年11月21日 上午11:21:48 
 * @version 1.0 
 * @parameter */
public class DESC implements Comparator<Comparable>{

	@Override
	public int compare(Comparable x, Comparable y) {
		
		return y.compareTo(x);
	}

}
