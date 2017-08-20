package 内部类实现工厂方法;

public class 测试类 {

	public static void main(String[] args) {
		从具体方案生成工厂();
		从包含多个方案的工厂选取();
	}
	
	public static void 从具体方案生成工厂() {
		进攻 attack1 = 进攻方案1.组件策略组().获得进攻方法();
		进攻 attack2 = 进攻方案2.组件策略组().获得进攻方法();
		attack1.开始();
		attack2.开始();
	}
	
	public static void 从包含多个方案的工厂选取() {
		进攻 attack1 = 进攻方案集中组.获得进攻方案1();
		进攻 attack2 = 进攻方案集中组.获得进攻方案2();
		attack1.开始();
		attack2.开始();
	}

}
