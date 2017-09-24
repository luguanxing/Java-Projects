package Comparable接口;

public class 有接口兵 implements Comparable<有接口兵> {
	
	String 兵种;
	int 级别;
	
	public 有接口兵(String 兵种, int 级别) {
		this.兵种 = 兵种;
		this.级别 = 级别;
	}

	@Override
	public int compareTo(有接口兵 o) {
		//从小到大排序
		return this.级别 - o.级别;
	}

	@Override
	public String toString() {
		return "兵 [兵种=" + 兵种 + ", 级别=" + 级别 + "]";
	}
	
}
