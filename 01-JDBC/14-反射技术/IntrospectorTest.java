import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import dao.User;

public class IntrospectorTest {

	public static void main(String[] args) throws Exception {
		User user = new User();
		ShowBean(user);
		GetBean(user);
		SetBean(user);
	}

	public static void ShowBean(Object obj) throws Exception {
		System.out.println("============================");
		BeanInfo bi = Introspector.getBeanInfo(obj.getClass());
		System.out.println("类名:"+obj.getClass().getName());
		System.out.println("属性名(类型):");
		PropertyDescriptor[] pDescriptors = bi.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : pDescriptors) {
			System.out.print(propertyDescriptor.getName() + " (");
			System.out.println(propertyDescriptor.getPropertyType() + ")");
		}
		System.out.println("============================");
	}
	
	public static void GetBean(Object obj) throws Exception {
		System.out.println("============================");
		BeanInfo bi = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] pDescriptors = bi.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : pDescriptors) {
			Method getMethod = propertyDescriptor.getReadMethod();
			System.out.println("存在GET方法->"+getMethod.getName());
		}
		System.out.println("============================");
	}
	
	public static void SetBean(Object obj) throws Exception {
		System.out.println("============================");
		BeanInfo bi = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] pDescriptors = bi.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : pDescriptors) {
			Method setMethod = propertyDescriptor.getWriteMethod();
			try {
				System.out.println("存在SET方法->"+setMethod.getName());
			} catch (Exception e) {
				System.out.println(propertyDescriptor.getName() + "不存在SET方法");
			}
		}
		System.out.println("============================");
	}
}
