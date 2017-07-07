import java.net.InetAddress;

public class test {

	public static void main(String[] args) {
		从域名获得一个IP();
		从域名获得所有IP();
		获得本机IP();
		判断本机是IPV4还是IPV6();
		测试可达性();
	}

	public static void 从域名获得一个IP() {
		System.out.println("从www.baidu.com域名获得一个IP");
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println(address.getHostName() + " -> " + address.getHostAddress());
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
	
	public static void 从域名获得所有IP() {
		System.out.println("从www.bilibili.com域名获得所有IP");
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
	
	public static void 获得本机IP() {
		System.out.println("获得本机IP");
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostName() + " -> " + address.getHostAddress());
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
	
	public static void 判断本机是IPV4还是IPV6() {
		System.out.println("判断IPV4和IPV6");
		try {
			InetAddress address = InetAddress.getLocalHost();
			byte[] local = address.getAddress();
			if (local.length == 4) {
				System.out.println("是IPV4");
			} else if (local.length == 6) {
				System.out.println("是IPV6");
			} else {
				System.out.println("未知");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
	
	private static void 测试可达性() {
		System.out.println("测试www.baidu.com可达性");
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			boolean isOk = address.isReachable(500);
			if (isOk) {
				System.out.println("在500ms内可连接成功");
			} else {
				System.out.println("在500ms内可连接失败");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("\n");
	}
}

