package 格式化输出;

public class format {

	public static void 打印坐标(double x, double y) {
		String result = String.format("(%.2f,%.2f)", x, y);
		System.out.println(result);
	}
	
	public static void 二进制打印(byte[] data) {
		StringBuilder sb = new StringBuilder();
		int width = 0;
		for (byte b : data) {
			if (width % 16 == 0) {
				//打印行头
				sb.append(String.format("%05X: ", width));
			}
			sb.append(String.format("%02X ", b));
			width++;
			if (width % 16 == 0) {
				//换行
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		打印坐标(3, 3.3);
		打印坐标(6.666, 233.333);
		二进制打印("乖乖♂站好        Boy♂Next♂Door♂".getBytes());
	}

}
