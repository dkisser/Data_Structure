package algorithm.divide.point;

import java.awt.Point;
import java.util.Comparator;

/** * @author  wenchen 
 * @date 创建时间：2017年11月25日 下午4:35:25 
 * @version 1.0 
 * @parameter */
public class PointCompare implements Comparator<Point>{

	@Override
	public int compare(Point o1, Point o2) {
		if (o1.getX()<o2.getX()) {
			return -1;
		} else if (o1.getX()==o2.getX()&&o1.getY()<o2.getY()) {
			return -1;
		}
		return 0;
	}

	
}
