package 引用外部类;

public class 外部类 {
	
	protected void 外部方法() {
		System.out.println(this + "调用了外部方法");
	}
	
	public class 内部类 {
		public 外部类 获得外部类() {
			return 外部类.this;
		}
	}
	
	public 内部类 获得内部类() {
		return new 内部类();
	}
}
