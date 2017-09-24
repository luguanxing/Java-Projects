package 数组实用方法;

import java.util.Arrays;

public class 数组查找 {

	public static void main(String[] args) {
		
		int[] a = {3, 15, 36, 27 ,58, 10};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		//能找到显示下标
		System.out.println("index of 10 = " + Arrays.binarySearch(a, 10));
		
		//不能找到显示插入后的下标
		System.out.println("index of 20 = " + Arrays.binarySearch(a, 20));
		
		//不能找到显示插入后的下标
		System.out.println("index of -10 = " + Arrays.binarySearch(a, -10));
		
	}

}
