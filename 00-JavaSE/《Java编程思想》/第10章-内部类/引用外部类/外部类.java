package �����ⲿ��;

public class �ⲿ�� {
	
	protected void �ⲿ����() {
		System.out.println(this + "�������ⲿ����");
	}
	
	public class �ڲ��� {
		public �ⲿ�� ����ⲿ��() {
			return �ⲿ��.this;
		}
	}
	
	public �ڲ��� ����ڲ���() {
		return new �ڲ���();
	}
}
