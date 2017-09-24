package Comparable接口;

import java.util.Comparator;

public class 无接口兵比较器 extends 无接口兵 implements Comparator<无接口兵> {

	public 无接口兵比较器(String 兵种, int 级别) {
		super(兵种, 级别);
	}

	@Override
	public int compare(无接口兵 o1, 无接口兵 o2) {
		return o2.级别 - o1.级别;
	}

}
