package 私有构造函数;

public class 测试类 {

	public static void main(String[] args) {
		私有构造函数测试();
	}
	
	public static void 私有构造函数测试() {
		System.out.println("=======私有构造函数测试======");
		人 私有人1 = 私有构造函数.获取新人();
		人 私有人2 = 私有构造函数.获取新人();
		私有人1.自我介绍();
		私有人2.自我介绍();
		System.out.println("将私有人1改名");
		私有人1.名字 = "新的私有人";
		私有人1.自我介绍();
		私有人2.自我介绍();	
		System.out.println("===================");
	}
}
