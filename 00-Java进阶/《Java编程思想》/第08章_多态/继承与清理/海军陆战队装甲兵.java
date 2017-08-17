package 继承与清理;

public class 海军陆战队装甲兵 extends 装甲兵 {

	@Override
	public void 清理() {
		System.out.println("上岸了");
		super.清理();
	}

}
