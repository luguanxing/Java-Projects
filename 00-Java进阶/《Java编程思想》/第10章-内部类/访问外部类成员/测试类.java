package �����ⲿ���Ա;

public class ������ {

	public static void main(String[] args) {
		���� xl = new ����(10);
		for (int i = 0; i < 10; i++)
			xl.����(i);
		ѡ���� xzq1 = xl.�������ѡ����();
		while (!xzq1.isEnd()) {
			System.out.print(xzq1.current() + " ");
			xzq1.next();
		}
		System.out.println("");
		ѡ���� xzq2 = xl.��÷���ѡ����();
		while (!xzq2.isEnd()) {
			System.out.print(xzq2.current() + " ");
			xzq2.next();
		}
	}

}
