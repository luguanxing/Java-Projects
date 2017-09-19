

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class ��ȡ�����ӿں���ص�ַ��Ϣ {

	public static void main(String[] args) {
		try {
			//��ȡ�����ӿ�
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			if (networkInterfaces == null) {
				System.out.println("û���ҵ������ӿ�");
			} else {
				while (networkInterfaces.hasMoreElements()) {
					NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
					System.out.println("networkInterface = [" + networkInterface.getName() + "]");
					//��ȡ�����ӿ���ص�ַ
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
