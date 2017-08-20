package 适配器设计模式;

public class 装甲兵 extends 兵 {

	@Override
	public void 攻击(Object obj) {
		System.out.println(name() + "用火炮攻击了" + obj);
	}

}
