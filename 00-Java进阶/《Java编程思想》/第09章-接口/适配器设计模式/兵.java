package 适配器设计模式;

public class 兵 {
	public String name() {
		return this.getClass().getSimpleName();
	}
	public void 攻击(Object obj) {
		System.out.println(name() + "用枪攻击了" + obj);
	}
}
