package tcp.imageUpload;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	/**
	 * 客户端发送图片，并打印收到的响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//发送
		Socket s = new Socket("192.168.2.161", 20000);
		FileInputStream fis = new FileInputStream("D:\\1.jpg");
		OutputStream out = s.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ( (len=fis.read(buf)) != -1 )
			out.write(buf, 0, len);
		s.shutdownOutput();//写结束标志使接收端能结束
		
		//接收
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int num = in.read(bufIn);
		System.out.println(new String(bufIn, 0, num));
		fis.close();
		s.close();
	}
	
	
}
