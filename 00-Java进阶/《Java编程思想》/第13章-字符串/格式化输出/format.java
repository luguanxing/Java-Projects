package ��ʽ�����;

public class format {

	public static void ��ӡ����(double x, double y) {
		String result = String.format("(%.2f,%.2f)", x, y);
		System.out.println(result);
	}
	
	public static void �����ƴ�ӡ(byte[] data) {
		StringBuilder sb = new StringBuilder();
		int width = 0;
		for (byte b : data) {
			if (width % 16 == 0) {
				//��ӡ��ͷ
				sb.append(String.format("%05X: ", width));
			}
			sb.append(String.format("%02X ", b));
			width++;
			if (width % 16 == 0) {
				//����
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		��ӡ����(3, 3.3);
		��ӡ����(6.666, 233.333);
		�����ƴ�ӡ("�Թԡ�վ��        Boy��Next��Door��".getBytes());
	}

}
