package ��ͨ����Ͷ�̬����;

public class ��ͨ���� implements �ӿ� {

	�ӿ� �ҵĽӿ� = null;
	
	��ͨ����(�ӿ� ʵ���˵Ľӿ�) {
		�ҵĽӿ� = ʵ���˵Ľӿ�;
	}
	
	@Override
	public void ��() {
		//�����Լ��Ľӿ�ʵ�ַ���
		System.out.print("��������÷���:\t");
		�ҵĽӿ�.��();
	}
	
	@Override
	public void ��(String str) {
		//�����Լ��Ľӿ�ʵ�ַ���
		System.out.print("��������÷���:\t");
		�ҵĽӿ�.��(str);
	}
	
	@Override
	public void ��() {
		//�����Լ��Ľӿ�ʵ�ַ���
		System.out.print("��������÷���:\t");
		�ҵĽӿ�.��();
	}

	
	public static void main(String[] args) {
		�ӿ� �ӿ�1 = new ʵ����1();
		�ӿ� �ӿ�2 = new ʵ����2();
		��ͨ���� ��ͨ����1 = new ��ͨ����(�ӿ�1);
		��ͨ���� ��ͨ����2 = new ��ͨ����(�ӿ�2);
		
		��ͨ����1.��();
		��ͨ����1.��("123");
		��ͨ����1.��();
		
		System.out.println();
		
		��ͨ����2.��();
		��ͨ����2.��("123");
		��ͨ����2.��();
	}

}
