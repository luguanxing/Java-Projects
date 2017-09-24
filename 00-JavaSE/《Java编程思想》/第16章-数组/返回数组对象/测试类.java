package 返回数组对象;

import java.util.Arrays;
import java.util.Random;

public class 测试类 {

	private static final Random rmd = new Random(System.currentTimeMillis());
	
	private static final String[] 集团军 = {"炮兵", "机械化步兵", "摩托化步兵", "步兵", "狙击手", "机枪手", "坦克兵"};
	
	public static String[] 组建突击队(int n) {
		if (n > 集团军.length)
			n = 集团军.length;
		boolean[] isExist = new boolean[集团军.length];
		String[] 突击队 = new String[n];
		for (int i = 1; i <= n; i++) {
			int index;
			do {
				index = rmd.nextInt(集团军.length);
			} while (isExist[index]);
			isExist[index] = true;
			突击队[i-1] = 集团军[index];
		}
		return 突击队;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(组建突击队(5)));
		System.out.println(Arrays.toString(组建突击队(150)));
		
	}

}
