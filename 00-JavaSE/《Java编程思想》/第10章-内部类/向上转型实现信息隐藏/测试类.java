package 向上转型实现信息隐藏;

public class 测试类 {

	public static void main(String[] args) {
		
		兵工厂 factory = new 兵工厂();
		兵 b1 = factory.要大头兵();
		兵 b2 = factory.要动员兵();

		b1.攻击();
		b2.攻击();
		
//		无法访问内部类的具体细节，使之完全不可见，只给你接口
//		兵工厂.大头兵 b3 = factory.要大头兵();
		
	}

}
