package ������_����ִ������;

import java.util.Random;

public class Switch {

	public static void main(String[] args) {
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int c = rnd.nextInt(26) + 'a';
			System.out.print("�����ַ�:" + (char)c);
			switch (c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u': 
					System.out.println("(��Ԫ��)");
				break;
				case 'y':
				case 'w': 
					System.out.println("(������Ԫ��)");
				break;
				default:
						System.out.println("(����Ԫ��)");
					break;
			}
		}
	}

}
