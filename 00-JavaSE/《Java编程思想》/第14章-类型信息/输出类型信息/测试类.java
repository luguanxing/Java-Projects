package ���������Ϣ;

public class ������ {

	public static void ����(Class clazz) {
		System.out.println("=======================");
		System.out.println("������ : " + clazz.getName());
		System.out.println("�Ƿ�Ϊ�ӿ� : [" + clazz.isInterface() + "]");
		System.out.println("������ : [" + clazz.getSimpleName() + "]");
		System.out.println("=======================");
		System.out.println();
	}
	
	public static void main(String[] args) {
		�ӿ� interfaze = new ʵ����();
		try {
			����(Class.forName("���������Ϣ.����"));
			����(Class.forName("���������Ϣ.�ӿ�"));
			����(Class.forName("���������Ϣ.ʵ����"));
			����(new ������().getClass());
			����(interfaze.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
