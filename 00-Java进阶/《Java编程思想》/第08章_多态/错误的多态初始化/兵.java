package 错误的多态初始化;

public class 兵 {
	
	public 兵() {
		System.out.println("兵进入战斗!");
		打();
		System.out.println("兵退出战斗!");
	}
	
	public void 打() {
		System.out.println("用枪打……");
	}
	
}
