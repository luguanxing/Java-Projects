package 异常的抛出;

public class 重抛异常 {

	public static void 内部调用() throws Exception {
		try {
			throw new Exception("内部调用异常");
		} catch (Exception e) {
			System.out.println("内部调用异常");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void 外部调用_更新异常() throws Exception {
		try {
			内部调用();
		} catch (Exception e) {
			System.out.println("外部调用异常");
			e = (Exception)e.fillInStackTrace();
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	
	public static void 外部调用_不更新异常() throws Exception {
		try {
			内部调用();
		} catch (Exception e) {
			System.out.println("外部调用异常");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			外部调用_更新异常();
		} catch (Exception e) {
			System.out.println("main调用异常");
			e = (Exception)e.fillInStackTrace();
			e.printStackTrace(System.out);
		}
		
		System.out.println("\n\n===========\n\n");
		
		try {
			外部调用_不更新异常();
		} catch (Exception e) {
			System.out.println("main调用异常");
			e.printStackTrace(System.out);
		}

	}

}
