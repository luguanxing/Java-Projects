package ����finally;

public class ��߽�׳�� {

	public static void main(String[] args) {

		int ���Դ��� = 0;
		
		while (true) {
			
			try {
				System.out.println("��" + (++���Դ���) + "�γ���");
				throw new Exception("ĳ����");
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (���Դ��� >= 3) {
					System.out.println("��γ��Ծ�ʧ��");
					break;
				}
			}
			
		}

	}

}
