package algorithm.incremental.order;

import java.util.Comparator;

/** * @author  wenchen 
 * @date 创建时间：2017年11月21日 上午11:20:40 
 * @version 1.0 
 * @parameter */
public class ASC implements Comparator<Comparable>{

	@Override
	public int compare(Comparable x, Comparable y) {
		
		return x.compareTo(y);
	}

}
