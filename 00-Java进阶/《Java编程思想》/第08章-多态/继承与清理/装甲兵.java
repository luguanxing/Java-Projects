package 继承与清理;

public class 装甲兵 extends 兵 {

	@Override
	public void 清理() {
		System.out.println("下坦克了");
		super.清理();
	}

}
