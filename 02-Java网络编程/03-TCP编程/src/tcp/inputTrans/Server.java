package tcp.inputTrans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * 服务端不断接收数据，翻译后返回响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//接收
		ServerSocket ss = new ServerSocket(20000);
		Socket s = ss.accept();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//发送
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String sourceStr = null;
		while ((sourceStr = bufIn.readLine()) != null) {
			String transStr = sourceStr.toUpperCase();
			bufOut.write(transStr);
			bufOut.newLine();
			bufOut.flush();
			System.out.println(sourceStr + "=>" + transStr);
		}
		s.close();
		ss.close();
	}
	
}
