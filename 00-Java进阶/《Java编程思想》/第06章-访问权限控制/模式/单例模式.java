package 模式;

public class 单例模式 {
	
	private static 人 person = new 人("单例人");
	
	private 单例模式() {
		//单例模式，整个类只有唯一对象(不是基本对象)
	}
	
	public static 人 获取单例人() {
		return person;
	}
}
