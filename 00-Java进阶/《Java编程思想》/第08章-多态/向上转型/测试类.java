package 向上转型;

public class 测试类 {

	public static void main(String[] args) {
		兵 b1 = new 兵();
		装甲兵 b2 = new 装甲兵();
		自我介绍(b1);
		自我介绍(b2);
	}

	public static void 自我介绍(兵 bing) {
		bing.自我介绍();
	}
	
}
