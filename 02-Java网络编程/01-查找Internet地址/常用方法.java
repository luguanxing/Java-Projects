import java.net.InetAddress;

public class test {

	public static void main(String[] args) {
		���������һ��IP();
		�������������IP();
		��ñ���IP();
		�жϱ�����IPV4����IPV6();
		���Կɴ���();
	}

	public static void ���������һ��IP() {
		System.out.println("��www.baidu.com�������һ��IP");
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println(address.getHostName() + " -> " + address.getHostAddress());
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
	
	public static void �������������IP() {
		System.out.println("��www.bilibili.com�����������IP");
		try {
			InetAddress[] addresses = InetAddress.getAllByName("www.bilibili.com");
			for (InetAddress address : addresses) {
				System.out.println(address.getHostName() + " -> " + address.getHostAddress());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
	
	public static void ��ñ���IP() {
		System.out.println("��ñ���IP");
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostName() + " -> " + address.getHostAddress());
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
	
	public static void �жϱ�����IPV4����IPV6() {
		System.out.println("�ж�IPV4��IPV6");
		try {
			InetAddress address = InetAddress.getLocalHost();
			byte[] local = address.getAddress();
			if (local.length == 4) {
				System.out.println("��IPV4");
			} else if (local.length == 6) {
				System.out.println("��IPV6");
			} else {
				System.out.println("δ֪");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
	
	private static void ���Կɴ���() {
		System.out.println("����www.baidu.com�ɴ���");
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			boolean isOk = address.isReachable(500);
			if (isOk) {
				System.out.println("��500ms�ڿ����ӳɹ�");
			} else {
				System.out.println("��500ms�ڿ�����ʧ��");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
}

