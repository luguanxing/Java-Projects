import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TestCharset {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws UnsupportedEncodingException {
		String str="你好，世界！";
		byte[] b_ = str.getBytes();
		byte[] b_gbk = str.getBytes("GBK");		//指定字符编码方式，同样可用在打开文件IO等操作
		byte[] b_utf8 = str.getBytes("UTF-8");
		System.out.println("bytes[] = " + Arrays.toString(b_));
		System.out.println("bytes_gbk[] = " + Arrays.toString(b_gbk));
		System.out.println("bytes_utf8[] = " + Arrays.toString(b_utf8));
		System.out.println("");
		
		String s_2gbk = new String(b_, "GBK");
		String s_2utf8 = new String(b_, "UTF-8");
		String s_utf82gbk = new String(b_utf8, "GBK");
		String s_gbk2utf8 = new String(b_gbk, "UTF-8");
		String s_gbk2gbk = new String(b_gbk, "GBK");
		String s_utf82utf8 = new String(b_utf8, "UTF-8");

		System.out.println("s_2gbk="+s_2gbk);
		System.out.println("s_2utf8="+s_2utf8);
		System.out.println("s_utf82gbk="+s_utf82gbk);
		System.out.println("s_gbk2utf8="+s_gbk2utf8);
		System.out.println("s_gbk2gbk="+s_gbk2gbk);
		System.out.println("s_utf82utf8="+s_utf82utf8);	
	}

}