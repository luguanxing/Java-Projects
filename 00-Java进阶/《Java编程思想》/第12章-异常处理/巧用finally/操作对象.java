package ����finally;

public class �������� {

	public static void һ���ɹ��Ĵ�() {}
	public static void ����ʧ�ܵĴ�() {}
	public static void һ���ɹ��Ĳ���() {}
	public static void ����ʧ�ܵĲ���() {}
	public static void һ���ɹ��Ĺر�() {}
	public static void ����ʧ�ܵĹر�() {}
	
	public static void ����1() {
		try {
			һ���ɹ��Ĵ�();
			����ʧ�ܵĲ���();
		} catch (Exception e) {

		} finally {
			һ���ɹ��Ĺر�();
		}
	}
	
	public static void ����2() {
		try {
			����ʧ�ܵĴ�();
			try {
				����ʧ�ܵĲ���();
			} catch (Exception ����ʧ��) {
				try {
					����ʧ�ܵĹر�();
				} catch (Exception �ر�ʧ��) {
					//�ر�ʧ��
				}
			} finally {
				һ���ɹ��Ĺر�();
			}
		} catch (Exception ��ʼ��ʧ��) {
			//��ʧ��,���ùر�
		} finally {
			//һ�㲻������رգ�����ʹ�� if (obj!= null) obj.close();
		}
	}
	
	public static void main(String[] args) {


	}

}
