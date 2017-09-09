package 局部内部类;

public class 测试类 {

	public static void main(String[] args) {
		兵 bing1 = 民主兵工厂.要大头兵();
		兵 bing2 = 民主兵工厂.要动员兵();
		bing1.攻击();
		bing2.攻击();
	}

}
