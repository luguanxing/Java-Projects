package 适配器设计模式;

public class 指挥员 implements 攻击者 {

	private 兵 被指挥的兵;
	
	public 指挥员(兵 被指挥的兵) {
		System.out.println("指挥员即将指挥"+被指挥的兵.getClass().getSimpleName());
		this.被指挥的兵 = 被指挥的兵;
	}
	
	@Override
	public void 攻击(Object 目标) {
		被指挥的兵.攻击(目标);
	}

}
