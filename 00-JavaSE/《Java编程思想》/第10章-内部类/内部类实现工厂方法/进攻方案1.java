package �ڲ���ʵ�ֹ�������;

//ʵ�ֽ�������1�����ܷ�����ʵ�ֽ�������1�Ĺ���
public class ��������1 implements ���� {

	@Override
	public void ��ʼ() {
		System.out.println("�������ǣ�װ��ͻ��");
	}

	private static ���������� ��������1������ = new ����������() {
		//�����ܹ����ظ÷���(this)�Ĺ���
		@Override
		public ���� ��ý�������() {
			return new ��������1();
		}
	};
	
	public static ���������� ���������() {
		return ��������1������;
	}
	
}
