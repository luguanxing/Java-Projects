package 向上转型实现信息隐藏;

public class 兵工厂 {

	private class 大头兵 implements 兵 {
		@Override
		public void 攻击() {
			System.out.println("大头兵攻击");
		}
	}
	
	private class 动员兵 implements 兵 {
		@Override
		public void 攻击() {
			System.out.println("动员兵攻击");
		}
	}
	
	public 大头兵 要大头兵() {
		return new 大头兵();
	}
	
	public 动员兵 要动员兵() {
		return new 动员兵();
	}
}
