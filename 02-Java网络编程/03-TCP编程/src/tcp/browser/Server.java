package tcp.browser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * 服务端返回响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//接收:打印请求信息并返回一句话
		ServerSocket ss = new ServerSocket(8080);

		while (true) {
			//打印请求信息
			Socket s = ss.accept();
			InputStream in = s.getInputStream();
			System.out.println("收到来自IP=" + s.getInetAddress().getLocalHost() + "的请求");
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			System.out.println(new String(buf));
			
			//返回响应信息
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println("HTTP/1.1 200");
			out.println("Content-Type: text/html;charset=UTF-8");
			out.println("Date: Thu, 16 Nov 2017 11:53:10 GMT");
			out.println("Connection: close");
			out.println();
			out.println();
			out.println("<html><title>hello</title><body>");
			out.println("hello! i am a java sever!");
			out.println("</body></html>");
			s.close();
		}
		
		//ss.close();
	}
	
}
