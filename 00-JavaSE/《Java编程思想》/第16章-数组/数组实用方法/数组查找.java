package ����ʵ�÷���;

import java.util.Arrays;

public class ������� {

	public static void main(String[] args) {
		
		int[] a = {3, 15, 36, 27 ,58, 10};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		//���ҵ���ʾ�±�
		System.out.println("index of 10 = " + Arrays.binarySearch(a, 10));
		
		//�����ҵ���ʾ�������±�
		System.out.println("index of 20 = " + Arrays.binarySearch(a, 20));
		
		//�����ҵ���ʾ�������±�
		System.out.println("index of -10 = " + Arrays.binarySearch(a, -10));
		
	}

}
