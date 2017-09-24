package 数组实用方法;

import java.util.Arrays;

public class 数组复制 {
	
	public static void main(String[] args) {
		
		int[] a = new int[5];
		int[] b = new int[10];
		
		Arrays.fill(a, 1);
		Arrays.fill(b, 2);
		
		System.out.println("before:");
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		System.out.println();
		System.arraycopy(a, 0, b, 0, a.length);
		
		System.out.println("after:");
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
	}

}
