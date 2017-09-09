package 内部类实现工厂方法;

//实现进攻方案2，并能返回能实现进攻方案2的工厂
public class 进攻方案2 implements 进攻 {

	@Override
	public void 开始() {
		System.out.println("定点斩首，奇袭围攻");
	}

	private static 进攻策略组 进攻方案2策略组 = new 进攻策略组() {
		//生成能够返回该方案(this)的工厂
		@Override
		public 进攻 获得进攻方法() {
			return new 进攻方案2();
		}
	};
	
	public static 进攻策略组 组件策略组() {
		return 进攻方案2策略组;
	}
	
}
