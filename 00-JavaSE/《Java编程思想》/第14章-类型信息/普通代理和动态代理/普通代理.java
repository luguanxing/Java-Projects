package 普通代理和动态代理;

public class 普通代理 implements 接口 {

	接口 我的接口 = null;
	
	普通代理(接口 实现了的接口) {
		我的接口 = 实现了的接口;
	}
	
	@Override
	public void 打() {
		//调用自己的接口实现方法
		System.out.print("代理类调用方法:\t");
		我的接口.打();
	}
	
	@Override
	public void 打(String str) {
		//调用自己的接口实现方法
		System.out.print("代理类调用方法:\t");
		我的接口.打(str);
	}
	
	@Override
	public void 跳() {
		//调用自己的接口实现方法
		System.out.print("代理类调用方法:\t");
		我的接口.跳();
	}

	
	public static void main(String[] args) {
		接口 接口1 = new 实现类1();
		接口 接口2 = new 实现类2();
		普通代理 普通代理1 = new 普通代理(接口1);
		普通代理 普通代理2 = new 普通代理(接口2);
		
		普通代理1.打();
		普通代理1.打("123");
		普通代理1.跳();
		
		System.out.println();
		
		普通代理2.打();
		普通代理2.打("123");
		普通代理2.跳();
	}

}
