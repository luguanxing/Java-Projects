package ������ʽ;

import java.util.Arrays;

public class String�Դ����� {

	public void Matches() {
		//"-?\\d+"��-?��ʾ������һ�����������\\d+��ʾһ����������
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		
		//"(-|\\+)?\\d+"��(-|\\+)?��ʾ������-��+��\\d+��ʾһ����������
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
		System.out.println(str.replaceFirst("\\W+", " �� "));
		System.out.println(str.replaceAll("\\W+", " �� "));
		System.out.println("=============");
	}
	
	public static void main(String[] args) {
		String�Դ����� test = new String�Դ�����();
		test.Matches();
		test.Splitting(" ", "\\W+", "u\\W+");
		test.Replace();
	}

}
