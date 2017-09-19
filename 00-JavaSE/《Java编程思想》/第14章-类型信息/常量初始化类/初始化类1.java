package 常量初始化类;

import java.util.Random;

public class 初始化类1 {
	static final int 静态常量 = 123;
	static Random random = new Random();
	static final int 静态变量 = random.nextInt();
	static {
		System.out.println("初始化类1已初始化");
	}
}
