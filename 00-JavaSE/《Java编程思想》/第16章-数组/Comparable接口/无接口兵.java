package Comparable接口;

public class 无接口兵 {
	
	String 兵种;
	int 级别;
	
	public 无接口兵(String 兵种, int 级别) {
		this.兵种 = 兵种;
		this.级别 = 级别;
	}

	@Override
	public String toString() {
		return "兵 [兵种=" + 兵种 + ", 级别=" + 级别 + "]";
	}
	
}
