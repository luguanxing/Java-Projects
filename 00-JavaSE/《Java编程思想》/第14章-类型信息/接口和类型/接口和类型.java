package 接口和类型;

public class 接口和类型 {
	
	public static void main(String[] args) {
		A a = new Aimpl();
		Aimpl a_impl_a = (Aimpl) a;
		Aimpl aimpl = new Aimpl();
		
		
		a.f();
		System.out.println("a = [" + a.getClass() + "]");
		System.out.println("a instanceof A = [" + (a instanceof A) + "]");
		System.out.println("a instanceof Aimpl = [" + (a instanceof Aimpl) + "]");
		
		System.out.println();
		
		a_impl_a.f();
		a_impl_a.g();
		System.out.println("a_impl_a = [" + a_impl_a.getClass() + "]");
		System.out.println("a_impl_a instanceof A = [" + (a_impl_a instanceof A) + "]");
		System.out.println("a_impl_a instanceof Aimpl = [" + (a_impl_a instanceof Aimpl) + "]");
		
		System.out.println();
		
		aimpl.f();
		aimpl.g();
		System.out.println("aimpl = [" + aimpl.getClass() + "]");
		System.out.println("aimpl instanceof A = [" + (aimpl instanceof A) + "]");
		System.out.println("aimpl instanceof Aimpl = [" + (aimpl instanceof Aimpl) + "]");
	}

}
