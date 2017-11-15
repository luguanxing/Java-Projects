package tcp.imageUploadMulti;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;


public class Server extends Thread {

	private Socket s;
	
	public Server(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		String receIp = s.getInetAddress().getHostAddress();
		System.out.println("receIp = " + receIp);
		try {
			//接收
			InputStream in = s.getInputStream();
			String filename = System.currentTimeMillis() + "=" + UUID.randomUUID();
			FileOutputStream fos = new FileOutputStream("D:\\" + filename + ".jpg");
			byte[] buf = new byte[1024];
			int len = 0;
			while ( (len=in.read(buf)) != -1 )
				fos.write(buf, 0, len);
			
			//发送
			OutputStream out = s.getOutputStream();
			out.write(("文件" + filename + "上传成功").getBytes());
			fos.close();
			s.close();
		} catch (Exception e) {
			System.out.println(receIp + "上传失败");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 服务端使用多线程接收图片，并返回响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(20000);
		while (true) {
			Socket s = ss.accept();
			new Thread(new Server(s)).start();
		}
		//ss.close();
	}
	
}
