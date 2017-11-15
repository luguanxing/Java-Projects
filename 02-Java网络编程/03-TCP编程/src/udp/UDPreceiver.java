package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPreceiver {

	/**
	 * UDP接收数据
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		receiveLoop(20000);
	}
	
	public static void receiveOneTime(int listenPort) throws Exception {
		//1.通过DatagramSocket创建UDP服务,指定端口鉴定
		DatagramSocket ds = new DatagramSocket(listenPort);

		//2.定义数据包来存储数据
		byte[] buffer = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
		
		//3.通过服务的receive接收数据,阻塞式方法
		ds.receive(dp);
		
		//4.通过数据包方法获取数据
		int port = dp.getPort();
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(), 0, dp.getLength());
		System.out.println("================");
		System.out.println("收到ip = " + ip + ":" + dp.getPort());
		System.out.println("内容data = " + data);
		System.out.println("================");
		System.out.println();
		
		//5.关闭资源
		ds.close();
	}
	
	public static void receiveLoop(int listenPort) throws Exception {
		DatagramSocket ds = new DatagramSocket(listenPort);
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
	}

}
