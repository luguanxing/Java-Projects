import java.net.InetAddress;

public class ����Host {

	public static void testHost(String host) {
		try {
			System.out.println("host = [" + host + "]");
			InetAddress[] inetAddresses = InetAddress.getAllByName(host);
			for (InetAddress inetAddress : inetAddresses) {
				System.out.println("\t" + inetAddress.getHostName() + "/" + inetAddress.getHostAddress());
			}
		} catch (Exception e) {
			System.out.println("�޷�����" + host);
		}
	}
	
	public static void main(String[] args) {
		testHost("www.baidu.com");
		testHost("www.github.com");
		testHost("haha.ha");
	}

}
