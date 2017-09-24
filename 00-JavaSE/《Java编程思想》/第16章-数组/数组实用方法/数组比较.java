package 数组实用方法;

import java.util.Arrays;

public class 数组比较 {

	public static void main(String[] args) {
		
		int[] a = new int[10];
		int[] b = new int[10];
		
		Arrays.fill(a, 1);
		Arrays.fill(b, 2);
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println("a == b ? " + Arrays.equals(a, b));
		
		Arrays.fill(a, 2);
		System.out.println();
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println("a == b ? " + Arrays.equals(a, b));

	}

}
