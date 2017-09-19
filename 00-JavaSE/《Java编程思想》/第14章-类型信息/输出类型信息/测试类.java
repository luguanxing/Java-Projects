package 输出类型信息;

public class 测试类 {

	public static void 测试(Class clazz) {
		System.out.println("=======================");
		System.out.println("类名称 : " + clazz.getName());
		System.out.println("是否为接口 : [" + clazz.isInterface() + "]");
		System.out.println("简单类名 : [" + clazz.getSimpleName() + "]");
		System.out.println("=======================");
		System.out.println();
	}
	
	public static void main(String[] args) {
		接口 interfaze = new 实现类();
		try {
			测试(Class.forName("输出类型信息.基类"));
			测试(Class.forName("输出类型信息.接口"));
			测试(Class.forName("输出类型信息.实现类"));
			测试(new 测试类().getClass());
			测试(interfaze.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
