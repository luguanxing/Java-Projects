package tcp.base;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	/**
	 * 客户端发送数据，并打印收到的响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//发送:创建服务,获取输出流并向输出流写数据
		Socket s = new Socket("192.168.2.161", 20000);
		OutputStream out = s.getOutputStream();
		out.write("你好，我是客户端".getBytes());
		//接收:获取输入流并向输入流读数据
		InputStream in = s.getInputStream();
		String receIp = s.getInetAddress().getHostAddress();
		System.out.println("receIp = " + receIp);
		byte[] buffer = new byte[1024];
		int len = in.read(buffer);
		System.out.println("receData = " + new String(buffer, 0, len));
		s.close();
	}
	
	
}
