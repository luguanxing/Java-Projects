package 内部类实现工厂方法;

//对比包含多种进攻方案(工厂类)
public class 进攻方案集中组 {
	
	public static 进攻方案1 获得进攻方案1() {
		return new 进攻方案1();
	}
	
	public static 进攻方案2 获得进攻方案2() {
		return new 进攻方案2();
	}
	
}
