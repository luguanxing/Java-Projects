package 引用外部类;

public class 测试类 {

	public static void main(String[] args) {
		//.this返回外部类
		外部类 outer = new 外部类();
		外部类.内部类 inner = outer.获得内部类();
		outer.外部方法();
		inner.获得外部类().外部方法();
		
		//.new创建内部类
		外部类.内部类 inner2 = outer.new 内部类();
		inner2.获得外部类().外部方法();
		
		//最终结果都是调用了outer的外部方法，因为内部类要引用关联到具体外部类（除非是静态）
	}

}
