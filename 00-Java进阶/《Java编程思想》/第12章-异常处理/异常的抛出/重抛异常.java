package �쳣���׳�;

public class �����쳣 {

	public static void �ڲ�����() throws Exception {
		try {
			throw new Exception("�ڲ������쳣");
		} catch (Exception e) {
			System.out.println("�ڲ������쳣");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void �ⲿ����_�����쳣() throws Exception {
		try {
			�ڲ�����();
		} catch (Exception e) {
			System.out.println("�ⲿ�����쳣");
			e = (Exception)e.fillInStackTrace();
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	
	public static void �ⲿ����_�������쳣() throws Exception {
		try {
			�ڲ�����();
		} catch (Exception e) {
			System.out.println("�ⲿ�����쳣");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			�ⲿ����_�����쳣();
		} catch (Exception e) {
			System.out.println("main�����쳣");
			e = (Exception)e.fillInStackTrace();
			e.printStackTrace(System.out);
		}
		
		System.out.println("\n\n===========\n\n");
		
		try {
			�ⲿ����_�������쳣();
		} catch (Exception e) {
			System.out.println("main�����쳣");
			e.printStackTrace(System.out);
		}

	}

}
