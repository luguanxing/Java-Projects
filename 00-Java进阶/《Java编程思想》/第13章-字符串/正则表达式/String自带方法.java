package 正则表达式;

import java.util.Arrays;

public class String自带方法 {

	public void Matches() {
		//"-?\\d+"即-?表示可能有一个或零个负号\\d+表示一个或多个数字
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		
		//"(-|\\+)?\\d+"即(-|\\+)?表示可能有-或+号\\d+表示一个或多个数字
		System.out.println("+911".matches("(-|\\+)?\\d+"));
		System.out.println("-911".matches("(-|\\+)?\\d+"));
		System.out.println("=============");
	}
	
	public void Splitting(String... regexs) {
		String str = "do you like what you see?";
		for (String regex : regexs) {
			System.out.println(Arrays.toString(str.split(regex)));
		}
		System.out.println("=============");
	}
	
	public void Replace() {
		String str = "boy next door";
		System.out.println(str.replaceFirst("\\W+", " ♂ "));
		System.out.println(str.replaceAll("\\W+", " ♂ "));
		System.out.println("=============");
	}
	
	public static void main(String[] args) {
		String自带方法 test = new String自带方法();
		test.Matches();
		test.Splitting(" ", "\\W+", "u\\W+");
		test.Replace();
	}

}
