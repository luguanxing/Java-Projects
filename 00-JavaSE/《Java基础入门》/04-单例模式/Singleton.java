class Singleton1 {
	private static Singleton1 instance = new Singleton1();	//唯一实例
	private Singleton1() {}	//私有构造函数
	public static Singleton1 GetInstance() {	//获得实例唯一静态接口
		return instance;
	}
}

class Singleton2 {
	private Singleton2() {}	//私有构造函数
	public static final Singleton2 instance = new Singleton2();	//禁止外部修改
}

public class Singleton {
	public static void main(String[] args) {
		Singleton1 si1 = Singleton1.GetInstance();
		Singleton1 si2 = Singleton1.GetInstance();
		System.out.println(si1 == si2);
		
		Singleton2 si3 = Singleton2.instance;
		Singleton2 si4 = Singleton2.instance;
		System.out.println(si3 == si4);		
	}
}