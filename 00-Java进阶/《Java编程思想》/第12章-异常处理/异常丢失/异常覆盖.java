package �쳣��ʧ;

public class �쳣���� {
	
	public static void ĳ����() throws Exception {
		try {
			throw new Exception("���ش���");
		} catch (Exception e) {
			
		} finally {
			//һ���쳣��û�����������һ���쳣
			throw new Exception("С����");
		}
	}
	
	public static void main(String[] args) {
		try {
			ĳ����();
		} catch (Exception e) {
			System.out.println("������" + e);
		}
	}

}
