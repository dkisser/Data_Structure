package algorithm.divide;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algorithm.divide.point.PointCompare;

/** * @author  wenchen 
 * @date 创建时间：2017年11月25日 下午4:39:50 
 * @version 1.0 
 * @parameter */
public class PointSort {
	
	public static void PointSort (List<Point> list,Comparator<Point> com){
		Collections.sort(list, com);
	}
	
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(1, 23));
		list.add(new Point(2, 2));
		list.add(new Point(1, 2));
		list.add(new Point(2, 23));
		list.add(new Point(3, 23));
		list.add(new Point(3, 2));
		System.out.println("排序前的list="+list);
		PointSort(list, new PointCompare());
		System.out.println("排序后的list="+list);
	}
	
}
