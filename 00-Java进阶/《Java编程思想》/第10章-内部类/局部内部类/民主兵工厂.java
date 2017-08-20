package 局部内部类;

public class 民主兵工厂 {
	
	public static 兵 要大头兵() {
		//内部类
		class 大头兵 implements 兵 {
			@Override
			public void 攻击() {
				System.out.println("大头兵攻击");
			}
		}
		return new 大头兵();
	}
	
	public static 兵 要动员兵() {
		//匿名类
		return new 兵() {
			@Override
			public void 攻击() {
				System.out.println("动员兵攻击");
			}
		};
	}
	
}
