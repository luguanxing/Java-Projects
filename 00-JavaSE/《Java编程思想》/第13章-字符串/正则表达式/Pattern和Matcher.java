package ������ʽ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern��Matcher {

	public void test(String target, String... regexs) {
		System.out.println("========================================");
		System.out.println("target = " + target);
		for (String regex : regexs) {
			System.out.println("regex = "+regex);
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(target);
			while (matcher.find()) {
				System.out.println("��λ��[" + matcher.start() + "," + matcher.end() + ")" + "ƥ����" + matcher.group());
			}
		}
		System.out.println("========================================");
	}
	
	public static void main(String[] args) {
		Pattern��Matcher main = new Pattern��Matcher();
		main.test("abcabcabcccdefabc", "abc+");
		main.test("abcabcabcccdefabc", "(abc)+");
		main.test("abcabcabcccdefabc", "(abc){2,}");
		main.test("abcabcabcccdefabc", "(abc){1,2}");
		main.test("abcabcabcccdefabc", "(abc){99,}");
	}

}
