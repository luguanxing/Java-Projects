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
		testFileInputStream();	//�����������
		testFileOutputStream();	//д���������
		testCopy1();			//���ֽڶ�д�����������и���
		testCopy2();			//����װ��ģʽ������(8192�ֽ�)��д�����������и���	
		testFileReader(); 		//�����ַ���
		testFileWriter(); 		//д���ַ���
		testReadline();			//���Զ�����
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
		String str = "hahaha!���!\n";
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
		System.out.println("����ֽڿ����ļ�����"+(fis.toString().length())+"������"+(endtime-begintime)+"msʱ��");
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
		System.out.println("�����������ļ�����"+(bis.toString().length())+"������"+(endtime-begintime)+"msʱ��");
		bis.close();
		bos.close();
		System.out.println("");
	}
	
	public static void testFileReader() throws Exception {
		FileReader reader = new FileReader("ʮ��׼.txt");
		int ch;
		while ((ch = reader.read()) != -1)
			System.out.print((char)ch);
		reader.close();
		System.out.println("");
	}
	
	public static void testFileWriter() throws Exception {
		FileWriter writer = new FileWriter("write2.txt", true);
		String str = "��ã����磡";
		writer.write(str+"\n");
		writer.close();
		System.out.println("");
	}
	
	public static void testReadline() throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader("ʮ��׼.txt"));
		String str;
		int count = 1;
		while ((str = bf.readLine()) != null)
			System.out.print("["+count+++"]"+str+"\n");
		System.out.println("");
	}
}
