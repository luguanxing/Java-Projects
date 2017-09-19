package 常量初始化类;

import java.util.Random;

public class 测试类 {
	
	public static void main(String[] args) {
		//使用静态final常量不初始化
		System.out.println("初始化类1.静态final常量 = " + 初始化类1.静态常量);
		System.out.println();
		
		//使用静态final变量会初始化
		System.out.println("初始化类1.静态final变量 = " + 初始化类1.静态变量);
		System.out.println();
		
		//使用静态非final常量会初始化
		System.out.println("初始化类2.静态非final常量 = " + 初始化类2.静态常量);
		System.out.println();
		
		//使用非静态常量会初始化
		System.out.println("new 初始化类3().非静态常量 = " + new 初始化类3().非静态常量);
		System.out.println();
	}

}
