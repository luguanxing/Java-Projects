package �����ⲿ��;

public class ������ {

	public static void main(String[] args) {
		//.this�����ⲿ��
		�ⲿ�� outer = new �ⲿ��();
		�ⲿ��.�ڲ��� inner = outer.����ڲ���();
		outer.�ⲿ����();
		inner.����ⲿ��().�ⲿ����();
		
		//.new�����ڲ���
		�ⲿ��.�ڲ��� inner2 = outer.new �ڲ���();
		inner2.����ⲿ��().�ⲿ����();
		
		//���ս�����ǵ�����outer���ⲿ��������Ϊ�ڲ���Ҫ���ù����������ⲿ�ࣨ�����Ǿ�̬��
	}

}
