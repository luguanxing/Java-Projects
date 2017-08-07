package 第07章_复用类;

public class 测试类 {

	public static void main(String[] args) {
		测试继承();
		测试代理();
	}
	
	public static void 测试继承() {
		System.out.println("测试继承");
		控制台_继承 test = new 控制台_继承();
		test.上();
		test.下();
		test.左();
		test.右();
		System.out.println("");
	}
	
	public static void 测试代理() {
		System.out.println("测试代理");
		控制中心_组合代理 test = new 控制中心_组合代理();
		test.上();
		test.下();
		test.左();
		test.右();
		System.out.println("");
	}
}
