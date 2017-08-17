package 模式;

public class 私有构造函数 {
	
	private 私有构造函数() {
		//私有构造函数，无法通过new构造
	}

	public static 人 获取新人() {
		return new 人();
	}
}
