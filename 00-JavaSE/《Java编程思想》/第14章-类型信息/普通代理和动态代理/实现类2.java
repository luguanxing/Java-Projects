package 普通代理和动态代理;

public class 实现类2 implements 接口 {

	@Override
	public void 打() {
		System.out.println("实现类2 -> 打");
	}

	@Override
	public void 打(String str) {
		System.out.println("实现类2 -> 打(" + str + ")");
	}

	@Override
	public void 跳() {
		System.out.println("实现类2 -> 跳");
	}

}
