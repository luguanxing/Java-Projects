package 组合;

public class 测试类 {

	public static void main(String[] args) {
		测试代理();
	}
	
	public static void 测试代理() {
		System.out.println("测试代理");
		控制中心_组合 test = new 控制中心_组合();
		test.上();
		test.下();
		test.左();
		test.右();
		System.out.println("");
	}
}
