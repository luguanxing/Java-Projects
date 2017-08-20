package 适配器设计模式;

public class 火箭兵 extends 兵 {

	@Override
	public void 攻击(Object obj) {
		System.out.println(name() + "用火箭攻击了" + obj);
	}
	
}
