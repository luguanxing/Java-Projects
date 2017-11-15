package tcp.copyFile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * 服务端接收文件，并响应信息
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//接收文件，读取时间标记获取开始和结尾
		ServerSocket ss = new ServerSocket(20000);
		Socket s = ss.accept();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(new FileWriter("D:\\copyFile"), true);
		String line;
		while ( (line = bufIn.readLine()) != null) {
			out.println(line);
		}
		
		//发送响应
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		pw.println("上传成功了");
		s.close();
		ss.close();
	}
	
}
