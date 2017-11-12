package udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPsender {

	/**
	 * UDP发送数据
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//testInput(InetAddress.getLocalHost(), 20000);		//发给自己
		testInput(InetAddress.getByName("192.168.2.255"), 20000);		//广播
	}
	
	public static void testHello(InetAddress inetAddress, int port) throws Exception {
		//1.通过DatagramSocket创建UDP服务
		DatagramSocket ds = new DatagramSocket();
		
		//2.提供数据和封装包
		byte[] buffer = "UDP-hello world".getBytes();
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length, inetAddress, port);
		
		//3.通过socket服务使用send将已有数据包发送
		ds.send(dp);
		
		//4.关闭资源
		ds.close();
	}
	
	public static void testInput(InetAddress inetAddress, int port) throws Exception {
		DatagramSocket ds = new DatagramSocket();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		while ((input = br.readLine()) != null) {
			byte[] buffer = input.getBytes();
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, inetAddress, port);
			ds.send(dp);
		}
		ds.close();	
	}
	
}
