package tcp.base;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * 服务端接收数据，并返回响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//接收:获取输入流并向输入流读数据
		ServerSocket ss = new ServerSocket(20000);
		Socket s = ss.accept();
		String receIp = s.getInetAddress().getHostAddress();
		System.out.println("receIp = " + receIp);
		InputStream in = s.getInputStream();
		byte[] buffer = new byte[1024];
		int len = in.read(buffer);
		System.out.println("receData = " + new String(buffer, 0, len));
		//发送:创建服务,获取输出流并向输出流写数据
		OutputStream out = s.getOutputStream();
		out.write("你好，我是服务端，我已经收到了你的消息".getBytes());
		s.close();
		ss.close();
	}
	
}
