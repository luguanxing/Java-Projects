package 匿名内部类;

public class 神秘兵工厂 {
	
	public 兵 获得匿名兵() {
		return new 兵() {
			{
				System.out.println("匿名兵初始化方法");
			}
			@Override
			public void 攻击() {
				System.out.println("匿名兵攻击");
			}
		};
	}
	
	public 枪 获得匿名枪(String givenname) {
		return new 枪(givenname) {
			{
				this.name = givenname;
				System.out.println("匿名枪初始化方法");
			}
			@Override
			public void 打() {
				System.out.println("使用" + name + "打");
			}
		};
	}
	
}
