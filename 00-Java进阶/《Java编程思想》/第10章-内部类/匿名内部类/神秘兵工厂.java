package �����ڲ���;

public class ���ر����� {
	
	public �� ���������() {
		return new ��() {
			{
				System.out.println("��������ʼ������");
			}
			@Override
			public void ����() {
				System.out.println("����������");
			}
		};
	}
	
	public ǹ �������ǹ(String givenname) {
		return new ǹ(givenname) {
			{
				this.name = givenname;
				System.out.println("����ǹ��ʼ������");
			}
			@Override
			public void ��() {
				System.out.println("ʹ��" + name + "��");
			}
		};
	}
	
}
