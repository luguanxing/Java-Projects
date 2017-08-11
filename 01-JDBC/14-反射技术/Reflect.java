import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import dao.User;

public class Reflect {

	public static void main(String[] args) throws Exception {
		createTest();
		invokeTest();
		showField(User.class);
		showAnnotation(User.class);
	}
	
	public static void createTest() throws Exception {
		User user = (User) createObjWithString(User.class);
		System.out.println(user);
		Bean bean = (Bean) createObjWithString(Bean.class);
		System.out.println(bean);
	}
	
	public static void invokeTest() throws Exception {
		User user = (User) createObjWithString(User.class);
		invokeMethodByTraversal(user, "sayHello");
		invokeMethodByGetName(user, "sayHellxo");
	}
	
	
	
	//构造class对象，一般带参数
	public static Object createObjWithString(Class clazz) throws Exception {
		Constructor con = clazz.getConstructor(String.class);	//找到clazz类参数为String的构造器
		Object obj = con.newInstance("testname");				//使用构造器产生实例对象
		return obj;
	}
	
	//查看和调用class对象实例方法
	public static void invokeMethodByTraversal(Object obj, String methodName) throws Exception {
		Method[] methods = obj.getClass().getMethods();				//查看所有public方法（包括超类）
//		Method[] methods = obj.getClass().getDeclaredMethods();		//查看当前声明的方法（不包括超类）包括public和private，不推荐使用
		for (Method method : methods) {
			System.out.print(method.getName()+" ");
			if (methodName.equals(method.getName())) {
				System.out.println("调用了方法->"+method.getName());
				method.invoke(obj, null); 	//传入实例和参数调入方法
			}
		}
	}
	
	public static void invokeMethodByGetName(Object obj, String methodName) throws Exception {
		try {
			Method method_byname = obj.getClass().getMethod(methodName, null);	//根据名字和参数确定固定的方法
			System.out.println("调用了方法->"+method_byname.getName());
			method_byname.invoke(obj, null);
		} catch (NoSuchMethodException e) {
			System.out.println("不存在方法->"+e.getMessage());
		}
	}
	
	//查看class对象属性
	public static void showField(Class clazz) throws Exception {
		//Field[] fields = clazz.getFields();		//只看公有
		Field[] fields = clazz.getDeclaredFields();	//可看公有私有，不推荐使用
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
	
	//查看注解如@Override
	public static void showAnnotation(Class clazz) throws Exception {
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotations);
		}
	}
}
