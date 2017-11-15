package tcp.imageUpload;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * 服务端接收图片，并返回响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//接收
		ServerSocket ss = new ServerSocket(20000);
		Socket s = ss.accept();
		InputStream in = s.getInputStream();
		FileOutputStream fos = new FileOutputStream("D:\\2.jpg");
		byte[] buf = new byte[1024];
		int len = 0;
		while ( (len=in.read(buf)) != -1 )
			fos.write(buf, 0, len);
		
		//发送
		OutputStream out = s.getOutputStream();
		out.write("上传成功".getBytes());
		fos.close();
		s.close();
		ss.close();
	}
	
}
