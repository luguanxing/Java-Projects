package ������_��ʼ��������;

public class Finalize {

	public static void main(String[] args) throws Throwable {
		
		Book Java���� = new Book("Java����");
		Book Java������ = new Book(true, "Java������");
		Book Java���˼�� = new Book(false, "Java���˼��");
		
		Java����.check();
		
		Java����.finalize();
		Java������.finalize();
		Java���˼��.finalize();
		System.gc();
		
	}

}
