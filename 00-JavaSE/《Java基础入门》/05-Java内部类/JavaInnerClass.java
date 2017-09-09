class Outer1 {	//外部类含内部类
	private int outernum = 111;
	class Inner {
		private int innernum = 222;
		void ShowOuterNum() {
			System.out.println("outernum = " + outernum);
		}
		void ShowInnerNum() {
			System.out.println("innernum = " + innernum);
		}		
	}	
}

class Outer2 {	//外部类含内部静态类
	private static int outernum = 333;
	static class Inner {
		private static int innernum = 444;
		void ShowOuterNum() {
			System.out.println("outernum = " + outernum);
		}
		void ShowInnerNum() {
			System.out.println("innernum = " + innernum);
		}
	}
}

public class JavaInnerClass {
	public static void main(String[] args) {
		
		Outer1 outer1 = new Outer1();
		Outer1.Inner inner1 = new Outer1().new Inner();
		inner1.ShowOuterNum();
		inner1.ShowInnerNum();
		
		Outer2 outer2 = new Outer2();
		Outer2.Inner inner2 = new Outer2.Inner();
		inner2.ShowOuterNum();	
		inner2.ShowInnerNum();
		
	}
}