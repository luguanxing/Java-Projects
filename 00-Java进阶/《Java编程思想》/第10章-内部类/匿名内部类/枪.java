package 匿名内部类;

abstract class 枪 {
	
	protected String name;
	
	public 枪(String name) {
		System.out.println("构造了枪"+name);
		//this.name = name;
	}
	
	public abstract void 打();
	
}
