package ����instance�жϺ�Class�����жϵıȽ�;

public class ������ {

	public class ���� {}
	public class �̳��� extends ���� {}
	
	public static void Test(Object object) {
		System.out.println("=============================");
		System.out.println("���� = " + object.getClass());
		
		//�����жϣ������̳У�
		System.out.println("instanceof ���� = [" + (object instanceof ����) + "]");
		System.out.println("instanceof �̳��� = [" + (object instanceof �̳���) + "]");
		System.out.println("����.class.isInstance(object) = [" + (����.class.isInstance(object)) + "]");
		System.out.println("����.class.isInstance(object) = [" + (�̳���.class.isInstance(object)) + "]");
		
		//��ȷ�жϣ��������̳У�
		System.out.println("object.getClass() == ����.class ? [" + object.getClass() == ����.class + "]");
		System.out.println("object.getClass() == �̳���.class ? [" + object.getClass() == �̳���.class + "]");
		System.out.println("object.getClass().equals(����.class) ? [" + object.getClass().equals(����.class) + "]");
		System.out.println("object.getClass().equals(�̳���.class) ? [" + object.getClass().equals(�̳���.class) + "]");
		System.out.println("=============================");
		System.out.println();
	}
	
	public static void main(String[] args) {
		������ main = new ������();
		Test(main.new ����());
		Test(main.new �̳���());
	}

}
