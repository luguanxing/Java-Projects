package ��05��_��ʼ��������;

public class �ɱ���� {

	public static void ��ʾ�ɱ�����(Object... objects) {
		for (Object object : objects) {
			System.out.print(object  + " " );
		}
		System.out.println();
		for (Object object : objects) {
			System.out.print("(" + object.getClass().getCanonicalName() + ") ");
		}
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		��ʾ�ɱ�����(1, 2, 3);
		��ʾ�ɱ�����("one", "two", "three");
		��ʾ�ɱ�����("one", 1f, 3.2);
	}

}
