package 嵌套接口;

import 嵌套接口.A.Dimp2;

public class 测试类 {

	public static void main(String[] args) {
		A a = new A();
//		不能访问私有接口A.D
//		A.D ad = a.getD();
		A.Dimp2 adi2 = (Dimp2) a.getD();
		adi2.f();
//		不能访问私有接口A.D
//		a.getD().f();
		A a2 = new A();
		a2.receiveD(a.getD());
	}

}
