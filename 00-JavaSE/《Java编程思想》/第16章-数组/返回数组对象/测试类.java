package �����������;

import java.util.Arrays;
import java.util.Random;

public class ������ {

	private static final Random rmd = new Random(System.currentTimeMillis());
	
	private static final String[] ���ž� = {"�ڱ�", "��е������", "Ħ�л�����", "����", "�ѻ���", "��ǹ��", "̹�˱�"};
	
	public static String[] �齨ͻ����(int n) {
		if (n > ���ž�.length)
			n = ���ž�.length;
		boolean[] isExist = new boolean[���ž�.length];
		String[] ͻ���� = new String[n];
		for (int i = 1; i <= n; i++) {
			int index;
			do {
				index = rmd.nextInt(���ž�.length);
			} while (isExist[index]);
			isExist[index] = true;
			ͻ����[i-1] = ���ž�[index];
		}
		return ͻ����;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(�齨ͻ����(5)));
		System.out.println(Arrays.toString(�齨ͻ����(150)));
		
	}

}
