package udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


/**
 * 发送线程
 * @author LGX
 *
 */
class Sender implements Runnable {
	
	private DatagramSocket ds;
	InetAddress inetAddress;
	int port;
	
	public Sender(InetAddress destInetAddress, int destPort) throws Exception {
		this.ds = new DatagramSocket();
		this.inetAddress = destInetAddress;
		this.port = destPort;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = null;
			while ((input = br.readLine()) != null) {
				byte[] buffer = input.getBytes();
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length, inetAddress, port);
				ds.send(dp);
			}
			ds.close();
		} catch (Exception e) {
			System.out.println("发送失败：");
			e.printStackTrace();
		}
	}
}



/**
 * 接收线程
 * @author LGX
 *
 */
class Receiver implements Runnable {
	
	private DatagramSocket ds;
	
	public Receiver(int listenPort) throws Exception {
		this.ds = new DatagramSocket(listenPort);
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				byte[] buffer = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp);
				int port = dp.getPort();
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(), 0, dp.getLength());
				System.out.println("================");
				System.out.println("收到ip = " + ip + ":" + dp.getPort());
				System.out.println("内容data = " + data);
				System.out.println("================");
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("接收失败：");
			e.printStackTrace();
		}
	}
}

/**
 * 局域网聊天程序 程序在端口20000监听数据  程序发送数据通过广播向局域网内所有主机20000端口发送数据
 * @author LGX
 *
 */
public class UDPchatroom {

	public static void main(String[] args) throws Exception {
		new Thread(new Sender(InetAddress.getByName("192.168.2.255"), 20000)).start();
		new Thread(new Receiver(20000)).start();
	}
	
}


