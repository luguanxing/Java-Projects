package �ֲ��ڲ���;

public class ���������� {
	
	public static �� Ҫ��ͷ��() {
		//�ڲ���
		class ��ͷ�� implements �� {
			@Override
			public void ����() {
				System.out.println("��ͷ������");
			}
		}
		return new ��ͷ��();
	}
	
	public static �� Ҫ��Ա��() {
		//������
		return new ��() {
			@Override
			public void ����() {
				System.out.println("��Ա������");
			}
		};
	}
	
}
