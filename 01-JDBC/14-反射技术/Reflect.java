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
	
	
	
	//����class����һ�������
	public static Object createObjWithString(Class clazz) throws Exception {
		Constructor con = clazz.getConstructor(String.class);	//�ҵ�clazz�����ΪString�Ĺ�����
		Object obj = con.newInstance("testname");				//ʹ�ù���������ʵ������
		return obj;
	}
	
	//�鿴�͵���class����ʵ������
	public static void invokeMethodByTraversal(Object obj, String methodName) throws Exception {
		Method[] methods = obj.getClass().getMethods();				//�鿴����public�������������ࣩ
//		Method[] methods = obj.getClass().getDeclaredMethods();		//�鿴��ǰ�����ķ��������������ࣩ����public��private�����Ƽ�ʹ��
		for (Method method : methods) {
			System.out.print(method.getName()+" ");
			if (methodName.equals(method.getName())) {
				System.out.println("�����˷���->"+method.getName());
				method.invoke(obj, null); 	//����ʵ���Ͳ������뷽��
			}
		}
	}
	
	public static void invokeMethodByGetName(Object obj, String methodName) throws Exception {
		try {
			Method method_byname = obj.getClass().getMethod(methodName, null);	//�������ֺͲ���ȷ���̶��ķ���
			System.out.println("�����˷���->"+method_byname.getName());
			method_byname.invoke(obj, null);
		} catch (NoSuchMethodException e) {
			System.out.println("�����ڷ���->"+e.getMessage());
		}
	}
	
	//�鿴class��������
	public static void showField(Class clazz) throws Exception {
		//Field[] fields = clazz.getFields();		//ֻ������
		Field[] fields = clazz.getDeclaredFields();	//�ɿ�����˽�У����Ƽ�ʹ��
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
	
	//�鿴ע����@Override
	public static void showAnnotation(Class clazz) throws Exception {
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotations);
		}
	}
}
