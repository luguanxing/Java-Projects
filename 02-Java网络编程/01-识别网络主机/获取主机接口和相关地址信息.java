

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class 获取主机接口和相关地址信息 {

	public static void main(String[] args) {
		try {
			//获取主机接口
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			if (networkInterfaces == null) {
				System.out.println("没有找到主机接口");
			} else {
				while (networkInterfaces.hasMoreElements()) {
					NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
					System.out.println("networkInterface = [" + networkInterface.getName() + "]");
					//获取主机接口相关地址
					Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
					while (inetAddresses.hasMoreElements()) {
						InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
						System.out.println("\tinetAddress = [" + inetAddress + "]");
						System.out.print("\t\ttype = ");
						if ((inetAddress instanceof Inet4Address))
							System.out.println("[ipv4] ");
						else if ((inetAddress instanceof Inet6Address))
							System.out.println("[ipv6] ");
						System.out.println("\t\tgetAddress = [" + inetAddress.getAddress() + "]");
						System.out.println("\t\tgetHostName = [" + inetAddress.getHostName() + "]");
					}
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
