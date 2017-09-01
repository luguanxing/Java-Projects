package 打印异常;

import java.io.PrintStream;

public class 打印到流 {
	
	public static void 打印栈轨迹到流(PrintStream print) {
		try {
			throw new Exception("某错误");
		} catch (Exception e) {
			e.printStackTrace(print);
		}
	}
	
	public static void 打印调用链到流(PrintStream print) {
		try {
			throw new Exception("某错误");
		} catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace()) {
				print.println("[" + ste.getMethodName() + "]");
			}
		}
	}
	
	public static void 打印到控制台() {
		打印栈轨迹到流(System.out);
		打印调用链到流(System.out);
	}
	
	public static void 打印到错误流() {
		打印栈轨迹到流(System.err);
		打印调用链到流(System.err);
	}

	public static void main(String[] args) {
		打印到控制台();
		打印到错误流();
	}

}
