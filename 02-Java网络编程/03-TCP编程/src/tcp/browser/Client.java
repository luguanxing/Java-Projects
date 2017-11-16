package tcp.browser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	/**
	 * 客户端发送请求，并打印收到的响应内容
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//发送请求
		Socket s = new Socket("23.106.128.92", 80);
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("GET /admin HTTP/1.1");
		out.println("Accept: image/gif, image/jpeg, image/pjpeg, application/x-ms-application, application/xaml+xml, application/x-ms-xbap, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
		out.println("Accept-Language: en-US,en;q=0.8,zh-Hans-CN;q=0.5,zh-Hans;q=0.3");
		out.println("User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/8.0; .NET4.0C; .NET4.0E)");
		out.println("Accept-Encoding: gzip, deflate");
		out.println("Host: 192.168.2.161:20000");
		out.println("Connection: close");	//不保持连接
		out.println();
		out.println();
		
		//接收内容
		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ( (line=bufr.readLine()) != null) {
			System.out.println(line);
		}
		s.close();
	}
	
}
