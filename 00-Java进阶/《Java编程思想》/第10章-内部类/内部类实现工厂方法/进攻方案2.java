package �ڲ���ʵ�ֹ�������;

//ʵ�ֽ�������2�����ܷ�����ʵ�ֽ�������2�Ĺ���
public class ��������2 implements ���� {

	@Override
	public void ��ʼ() {
		System.out.println("����ն�ף���ϮΧ��");
	}

	private static ���������� ��������2������ = new ����������() {
		//�����ܹ����ظ÷���(this)�Ĺ���
		@Override
		public ���� ��ý�������() {
			return new ��������2();
		}
	};
	
	public static ���������� ���������() {
		return ��������2������;
	}
	
}
