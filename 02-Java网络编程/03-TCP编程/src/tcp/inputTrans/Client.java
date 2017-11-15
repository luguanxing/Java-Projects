package tcp.inputTrans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	/**
	 * 客户端不断从输入流发送小写数据，并打印收到的翻译后的大写数据
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//发送
		Socket s = new Socket("192.168.2.161", 20000);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		
		//接收
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String sourceStr = null;
		while ((sourceStr=bufr.readLine()) != null) {
			bufOut.write(sourceStr);
			bufOut.newLine();
			bufOut.flush();
			//out.println(sourceStr);
			String transStr = bufIn.readLine();
			System.out.println("=>" + transStr);
		}
		bufr.close();
		s.close();
	}
	
	
}
