package Comparable�ӿ�;

import java.util.Arrays;

public class ������ {

	public static void main(String[] args) {
		
		�нӿڱ�[] ��һ�ֶ� = {new �нӿڱ�("����", 10), new �нӿڱ�("��ʿ", 1), new �нӿڱ�("�ϵȱ�", 2),  new �нӿڱ�("��ʿ", 3),  new �нӿڱ�("�ܱ�", 3), new �нӿڱ�("�ѻ���", 2)};
		�޽ӿڱ�[] �ڶ��ֶ� = {new �޽ӿڱ�("����", 10), new �޽ӿڱ�("��ʿ", 1), new �޽ӿڱ�("�ϵȱ�", 2),  new �޽ӿڱ�("��ʿ", 3),  new �޽ӿڱ�("�ܱ�", 3), new �޽ӿڱ�("�ѻ���", 2)};
		
		Arrays.sort(��һ�ֶ�);
		System.out.println(Arrays.toString(��һ�ֶ�));
		
		�޽ӿڱ��Ƚ��� compare = new �޽ӿڱ��Ƚ���("�Ƚ���", 123);
		Arrays.sort(�ڶ��ֶ�, compare);
		System.out.println(Arrays.toString(�ڶ��ֶ�));
	}

}
