package ����ת��ʵ����Ϣ����;

public class ������ {

	private class ��ͷ�� implements �� {
		@Override
		public void ����() {
			System.out.println("��ͷ������");
		}
	}
	
	private class ��Ա�� implements �� {
		@Override
		public void ����() {
			System.out.println("��Ա������");
		}
	}
	
	public ��ͷ�� Ҫ��ͷ��() {
		return new ��ͷ��();
	}
	
	public ��Ա�� Ҫ��Ա��() {
		return new ��Ա��();
	}
}
