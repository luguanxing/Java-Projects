package Comparable接口;

import java.util.Arrays;

public class 测试类 {

	public static void main(String[] args) {
		
		有接口兵[] 第一分队 = {new 有接口兵("将军", 10), new 有接口兵("列士", 1), new 有接口兵("上等兵", 2),  new 有接口兵("中士", 3),  new 有接口兵("宪兵", 3), new 有接口兵("狙击手", 2)};
		无接口兵[] 第二分队 = {new 无接口兵("将军", 10), new 无接口兵("列士", 1), new 无接口兵("上等兵", 2),  new 无接口兵("中士", 3),  new 无接口兵("宪兵", 3), new 无接口兵("狙击手", 2)};
		
		Arrays.sort(第一分队);
		System.out.println(Arrays.toString(第一分队));
		
		无接口兵比较器 compare = new 无接口兵比较器("比较器", 123);
		Arrays.sort(第二分队, compare);
		System.out.println(Arrays.toString(第二分队));
	}

}
