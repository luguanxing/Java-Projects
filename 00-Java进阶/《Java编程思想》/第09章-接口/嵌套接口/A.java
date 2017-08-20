package Ç¶Ì×½Ó¿Ú;

public class A {
	
	private interface D {
		void f();
	}
	private class Dimp implements D {
		public void f() {};
	}
	public class Dimp2 implements D {
		public void f() {};
	}
	
	private D dRef;
	public D getD() {
		return new Dimp2();
	}
	public void receiveD(D d) {
		dRef = d;
		dRef.f();
	}
}
