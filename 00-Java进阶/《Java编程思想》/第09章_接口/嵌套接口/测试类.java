package Ƕ�׽ӿ�;

import Ƕ�׽ӿ�.A.Dimp2;

public class ������ {

	public static void main(String[] args) {
		A a = new A();
//		���ܷ���˽�нӿ�A.D
//		A.D ad = a.getD();
		A.Dimp2 adi2 = (Dimp2) a.getD();
		adi2.f();
//		���ܷ���˽�нӿ�A.D
//		a.getD().f();
		A a2 = new A();
		a2.receiveD(a.getD());
	}

}
