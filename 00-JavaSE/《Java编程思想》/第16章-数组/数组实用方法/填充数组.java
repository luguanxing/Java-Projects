package ����ʵ�÷���;

import java.util.Arrays;

public class ������� {

	public static void main(String[] args) {
		
		int[] intarray = new int[10];
		float[] floatarray = new float[10];
		String[] stringarray = new String[10];
		
		Arrays.fill(intarray, 3);
		Arrays.fill(floatarray, 2.33f);
		Arrays.fill(stringarray, "haha");
		
		System.out.println(Arrays.toString(intarray));
		System.out.println(Arrays.toString(floatarray));
		System.out.println(Arrays.toString(stringarray));
	}

}
