package ��ͨ����Ͷ�̬����;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ��̬���� implements InvocationHandler {

	private Object �ҵĽӿ�;
	
	public ��̬����(Object ʵ���˵Ľӿ�) {
		�ҵĽӿ� = ʵ���˵Ľӿ�;
	}
	
	@Override	//��̬����InvocationHandlerʵ������÷���ʱ�����ô˴�
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//�˴������Ϣ��������HOOKAPI
		System.out.print("������ [" + proxy.getClass().getName() + "] " + "Ҫ���� [" + method.getName() + "] ����������Ϊ [");
		if (args != null)
			for (Object arg : args) {
				System.out.print(arg + " ");
			}
		System.out.println("]");
		//������Ҫ���õķ���ת�����Ѿ�ʵ���˵Ľӿڼ����ҵĽӿڡ�������������=�ӿڷ�������->������->����ʵ����
		return method.invoke(�ҵĽӿ�, args);
	}
	
	public static void main(String[] args) {
		ʵ����1 ʵ����1 = new ʵ����1();
		ʵ����2 ʵ����2 = new ʵ����2();
		
		//����ʵ����1������̬����InvocationHandlerʵ����
		�ӿ� �ӿ� = (�ӿ�) Proxy.newProxyInstance(�ӿ�.class.getClassLoader(), new Class[] {�ӿ�.class}, new ��̬����(ʵ����1));
		�ӿ�.��();
		�ӿ�.��("123");
		�ӿ�.��();
		
		System.out.println();
		
		//����ʵ����2������̬����InvocationHandlerʵ����
		�ӿ� = (�ӿ�) Proxy.newProxyInstance(�ӿ�.class.getClassLoader(), new Class[] {�ӿ�.class}, new ��̬����(ʵ����2));
		�ӿ�.��();
		�ӿ�.��("321");
		�ӿ�.��();
	}

}
