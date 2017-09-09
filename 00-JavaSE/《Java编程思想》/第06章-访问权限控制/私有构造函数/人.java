package 私有构造函数;

public class 人 {
	String 名字;
	public 人() {
		名字 = "未命名";
	}
	
	public 人(String 名字) {
		this.名字 = 名字;
	}
	
	public void 自我介绍() {
		System.out.println("我是\""+名字+"\"");
	}
}
