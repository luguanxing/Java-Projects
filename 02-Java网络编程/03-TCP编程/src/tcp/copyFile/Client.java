package tcp.copyFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	/**
	 * 客户端发送文件，并打印收到的响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//发送
		Socket s = new Socket("192.168.2.161", 20000);
		BufferedReader bufr = new BufferedReader(new FileReader("D:\\source"));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		String textLine = null;
		while ( (textLine = bufr.readLine()) != null ) {
			out.println(textLine);
		}
		s.shutdownOutput();	//关闭输出流
		
		//接收
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(bufIn.readLine());
		bufr.close();
		s.close();
	}
	
	
}
