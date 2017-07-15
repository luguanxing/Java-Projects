package 第四章_控制执行流程;

import java.util.Random;

public class Switch {

	public static void main(String[] args) {
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int c = rnd.nextInt(26) + 'a';
			System.out.print("生成字符:" + (char)c);
			switch (c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u': 
					System.out.println("(是元音)");
				break;
				case 'y':
				case 'w': 
					System.out.println("(可能是元音)");
				break;
				default:
						System.out.println("(不是元音)");
					break;
			}
		}
	}

}
