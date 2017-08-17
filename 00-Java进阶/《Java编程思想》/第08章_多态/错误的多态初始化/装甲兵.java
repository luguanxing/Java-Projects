package 错误的多态初始化;

public class 装甲兵 extends 兵 {
	
	public void 装甲兵() {
		System.out.println("装甲兵进入战斗!");
		打();
		System.out.println("装甲兵退出战斗!");
	}
	
	public void 打() {
		System.out.println("用大炮打……");
	}

}
