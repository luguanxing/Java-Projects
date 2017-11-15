package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpDemo {

	public static void main(String[] args) throws Exception {
		System.out.println("本机地址:");
		printInetAddress(InetAddress.getLocalHost());
		
		System.out.println("查询百度地址:");
		InetAddress[] inetAddresses = InetAddress.getAllByName("www.baidu.com");
		for (InetAddress inetAddress : inetAddresses) {
			printInetAddress(inetAddress);
		}
	}
	
	public static void printInetAddress(InetAddress inetAddress) {
		System.out.println("==================");
		System.out.println(inetAddress.toString());
		System.out.println("HostAddress = " + inetAddress.getHostAddress());
		System.out.println("HostName = " + inetAddress.getHostName());
		System.out.println("==================");
		System.out.println();
	}
	
}
