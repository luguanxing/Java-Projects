import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class TestIO {
	
	public static void main(String[] args) throws Exception {
		testFileInputStream();	//读入二进制流
		testFileOutputStream();	//写入二进制流
		testCopy1();			//逐字节读写二进制流进行复制
		testCopy2();			//利用装横模式缓冲区(8192字节)读写二进制流进行复制	
		testFileReader(); 		//读入字符流
		testFileWriter(); 		//写入字符流
		testReadline();			//测试读整行
	}
	
	public static void testFileInputStream() throws Exception {
		FileInputStream fis = new FileInputStream("read.txt");
		int b = 0;
		while (true) {
			b = fis.read();
			if (b == -1)
				break;
			System.out.print(b+" ");
		}
		fis.close();
		System.out.println("");
	}
	
	public static void testFileOutputStream() throws Exception {
		FileOutputStream fos = new FileOutputStream("write.txt", true);
		String str = "hahaha!你好!\n";
		byte[] b = str.getBytes();
		for (byte c : b) {
			fos.write(c);
		}
		fos.close();
		System.out.println("");
	}
	
	public static void testCopy1() throws Exception  {
		FileInputStream fis = new FileInputStream("tiananmen.jpg");
		FileOutputStream fos = new FileOutputStream("tiananmenCopy1.jpg");
		long begintime = System.currentTimeMillis();
		int len;
		while ((len = fis.read()) != -1)
			fos.write(len);
		long endtime = System.currentTimeMillis();
		System.out.println("逐个字节拷贝文件长度"+(fis.toString().length())+"共花费"+(endtime-begintime)+"ms时间");
		fis.close();
		fos.close();
		System.out.println("");
	}
	
	public static void testCopy2() throws Exception  {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("tiananmen.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("tiananmenCopy2.jpg"));
		long begintime = System.currentTimeMillis();
		int len;
		while ((len = bis.read()) != -1)
			bos.write(len);
		long endtime = System.currentTimeMillis();
		System.out.println("缓冲区拷贝文件长度"+(bis.toString().length())+"共花费"+(endtime-begintime)+"ms时间");
		bis.close();
		bos.close();
		System.out.println("");
	}
	
	public static void testFileReader() throws Exception {
		FileReader reader = new FileReader("十不准.txt");
		int ch;
		while ((ch = reader.read()) != -1)
			System.out.print((char)ch);
		reader.close();
		System.out.println("");
	}
	
	public static void testFileWriter() throws Exception {
		FileWriter writer = new FileWriter("write2.txt", true);
		String str = "你好！世界！";
		writer.write(str+"\n");
		writer.close();
		System.out.println("");
	}
	
	public static void testReadline() throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader("十不准.txt"));
		String str;
		int count = 1;
		while ((str = bf.readLine()) != null)
			System.out.print("["+count+++"]"+str+"\n");
		System.out.println("");
	}
}
