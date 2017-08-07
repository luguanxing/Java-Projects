package 第05章_初始化与清理;

public class 可变参数 {

	public static void 显示可变数组(Object... objects) {
		for (Object object : objects) {
			System.out.print(object  + " " );
		}
		System.out.println();
		for (Object object : objects) {
			System.out.print("(" + object.getClass().getCanonicalName() + ") ");
		}
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		显示可变数组(1, 2, 3);
		显示可变数组("one", "two", "three");
		显示可变数组("one", 1f, 3.2);
	}

}
