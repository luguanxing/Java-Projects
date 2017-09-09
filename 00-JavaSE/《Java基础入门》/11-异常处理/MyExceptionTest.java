class MyException extends Exception {	//�Զ����쳣
	public MyException() {
		super();
	}
	public MyException(String message) {
		super(message);
	}
	public void Explain() {
		System.out.println("�Զ����쳣��Ϣ:"+super.getMessage());
	}
}

public class MyExceptionTest {
	
	public static void MyCheck (int num) throws MyException {	//�����׳��쳣�ĺ���Ӧ����
		if (num < 0) {
			throw new MyException(num+"�Ǹ���!");
		} else {
			System.out.println(num+"������");
		}
	}
	
	public static void main(String[] args) {
		//����ϵͳ�쳣
		try {
			int result = 1/0;
		} catch (Exception e) {
			System.out.println("�쳣��Ϣ:"+e.getMessage());
		} finally {
			System.out.println("�Ѵ���ϵͳ�쳣\n");
		}
		
		//�����Զ����쳣
		try {
			MyCheck(1);
			MyCheck(-1);	//�׳��󲻻�������ִ��
			MyCheck(0);
		} catch (MyException e) {
			e.Explain();
			return; 	//�������returnҲҪִ�к���finally,������exit()����
		} finally {
			System.out.println("�Ѵ����Զ����쳣");
		}
		
		System.out.println("��������");	//���ﲻ�ᱻִ�е�����Ϊ������ִ��return
	}
}