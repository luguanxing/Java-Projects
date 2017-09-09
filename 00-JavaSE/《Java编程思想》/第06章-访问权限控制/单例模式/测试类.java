package 单例模式;

public class 测试类 {

	public static void main(String[] args) {
		单例测试();
	}

	public static void 单例测试() {
		System.out.println("=======单例测试======");
		人 单例人1 = 单例模式.获取单例人();
		人 单例人2 = 单例模式.获取单例人();
		单例人1.自我介绍();
		单例人2.自我介绍();
		System.out.println("将单例人1改名");
		单例人1.名字 = "新的单例人";
		单例人1.自我介绍();
		单例人2.自我介绍();
		System.out.println("===================");
	}
}
