package �������;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ������ {

	public class Person {
		String name;
		String country;
		void speak() {};
		void run() {};
		void jump() {};
		void eat() {};
	}
	
	public static void �鿴����Ϣ(Class clazz) {
		System.out.println("=======================");
		System.out.println("����Ϣ = [" + clazz.getSimpleName() + "]");
		System.out.print("�෽�� = [" );
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getName() + " ");
		}
		System.out.println("]" );
		System.out.print("��Ա = [" );
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.print(field.getName() + " ");
		}
		System.out.println("]" );
		System.out.println("=======================");
	}
	
	public static void main(String[] args) {
		������ main = new ������();
		�鿴����Ϣ(main.new Person().getClass());
		�鿴����Ϣ(String.class);
	}

}
