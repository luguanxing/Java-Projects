
public class TestString {

	public static void main(String[] args) {
		testString();
		System.out.println("");
		testStringBuffer();
	}
	
	public static void testString() {
		System.out.println(">>>>>>>>>>>>testString<<<<<<<<");
		char[] charArray = new char[]{'A','B','C'};
		String str1 = new String();
		String str2 = new String("abcdefg");
		String str3 = new String(charArray);
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str3="+str3);	
		System.out.println("str1.isEmpty()="+str1.isEmpty());
		System.out.println("str2.length()="+str2.length());
		System.out.println("str2.substring(3)="+str2.substring(3));
		System.out.println(">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<");
	}

	public static void testStringBuffer() {
		System.out.println(">>>>>>>>>>>>testStringBuffer<<<<<<<<");
		StringBuffer sb = new StringBuffer();
		sb.append("abcdefg");
		System.out.println("sb.insert(2, \"XXX\")="+sb.insert(2, "XXX"));
		System.out.println("sb.delete(0, 5)="+sb.delete(0, 5));
		System.out.println("sb="+sb);
		System.out.println(">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<");
	}
}
