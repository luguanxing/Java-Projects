package ��ӡ�쳣;

import java.io.PrintStream;

public class ��ӡ���� {
	
	public static void ��ӡջ�켣����(PrintStream print) {
		try {
			throw new Exception("ĳ����");
		} catch (Exception e) {
			e.printStackTrace(print);
		}
	}
	
	public static void ��ӡ����������(PrintStream print) {
		try {
			throw new Exception("ĳ����");
		} catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace()) {
				print.println("[" + ste.getMethodName() + "]");
			}
		}
	}
	
	public static void ��ӡ������̨() {
		��ӡջ�켣����(System.out);
		��ӡ����������(System.out);
	}
	
	public static void ��ӡ��������() {
		��ӡջ�켣����(System.err);
		��ӡ����������(System.err);
	}

	public static void main(String[] args) {
		��ӡ������̨();
		��ӡ��������();
	}

}
