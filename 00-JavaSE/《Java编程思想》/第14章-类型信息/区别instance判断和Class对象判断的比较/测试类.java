package 区别instance判断和Class对象判断的比较;

public class 测试类 {

	public class 基类 {}
	public class 继承类 extends 基类 {}
	
	public static void Test(Object object) {
		System.out.println("=============================");
		System.out.println("类型 = " + object.getClass());
		
		//粗略判断（包含继承）
		System.out.println("instanceof 基类 = [" + (object instanceof 基类) + "]");
		System.out.println("instanceof 继承类 = [" + (object instanceof 继承类) + "]");
		System.out.println("基类.class.isInstance(object) = [" + (基类.class.isInstance(object)) + "]");
		System.out.println("基类.class.isInstance(object) = [" + (继承类.class.isInstance(object)) + "]");
		
		//精确判断（不包含继承）
		System.out.println("object.getClass() == 基类.class ? [" + object.getClass() == 基类.class + "]");
		System.out.println("object.getClass() == 继承类.class ? [" + object.getClass() == 继承类.class + "]");
		System.out.println("object.getClass().equals(基类.class) ? [" + object.getClass().equals(基类.class) + "]");
		System.out.println("object.getClass().equals(继承类.class) ? [" + object.getClass().equals(继承类.class) + "]");
		System.out.println("=============================");
		System.out.println();
	}
	
	public static void main(String[] args) {
		测试类 main = new 测试类();
		Test(main.new 基类());
		Test(main.new 继承类());
	}

}
