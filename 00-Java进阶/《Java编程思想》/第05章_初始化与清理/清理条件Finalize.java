package ��05��_��ʼ��������;

public class ��������Finalize {

	public static void main(String[] args) throws Throwable {
		
		�� Java���� = new ��("Java����");
		�� Java������ = new ��(true, "Java������");
		�� Java���˼�� = new ��(false, "Java���˼��");
		
		Java����.check();
		
		Java����.finalize();
		Java������.finalize();
		Java���˼��.finalize();
		System.gc();
		
	}

}
