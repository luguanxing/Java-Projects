package 向上转型;

public class 装甲兵 extends 兵 {

	@Override
	public void 自我介绍() {
		System.out.println("我是一个装甲兵，我来自("+this.getClass().getName()+")类");
	}

}
