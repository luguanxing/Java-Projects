package 反射机制;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class 测试类 {

	public class Person {
		String name;
		String country;
		void speak() {};
		void run() {};
		void jump() {};
		void eat() {};
	}
	
	public static void 查看类信息(Class clazz) {
		System.out.println("=======================");
		System.out.println("类信息 = [" + clazz.getSimpleName() + "]");
		System.out.print("类方法 = [" );
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getName() + " ");
		}
		System.out.println("]" );
		System.out.print("成员 = [" );
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.print(field.getName() + " ");
		}
		System.out.println("]" );
		System.out.println("=======================");
	}
	
	public static void main(String[] args) {
		测试类 main = new 测试类();
		查看类信息(main.new Person().getClass());
		查看类信息(String.class);
	}

}
