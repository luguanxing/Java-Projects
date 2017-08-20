package 错误的多态初始化;

public class 测试类 {

	public static void main(String[] args) {
		装甲兵 bing = new 装甲兵();
		System.out.println("基类（兵）错误地使用了多态调用了继承类（装甲兵）方法。。。");
	}

}
