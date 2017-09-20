package 普通代理和动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 动态代理 implements InvocationHandler {

	private Object 我的接口;
	
	public 动态代理(Object 实现了的接口) {
		我的接口 = 实现了的接口;
	}
	
	@Override	//动态代理InvocationHandler实现类调用方法时即调用此处
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//此处输出信息，类似于HOOKAPI
		System.out.print("代理类 [" + proxy.getClass().getName() + "] " + "要调用 [" + method.getName() + "] 方法，参数为 [");
		if (args != null)
			for (Object arg : args) {
				System.out.print(arg + " ");
			}
		System.out.println("]");
		//将真正要调用的方法转发到已经实现了的接口即“我的接口”，调用总流程=接口方法调用->代理类->真正实现类
		return method.invoke(我的接口, args);
	}
	
	public static void main(String[] args) {
		实现类1 实现类1 = new 实现类1();
		实现类2 实现类2 = new 实现类2();
		
		//利用实现类1建立动态代理InvocationHandler实现类
		接口 接口 = (接口) Proxy.newProxyInstance(接口.class.getClassLoader(), new Class[] {接口.class}, new 动态代理(实现类1));
		接口.打();
		接口.打("123");
		接口.跳();
		
		System.out.println();
		
		//利用实现类2建立动态代理InvocationHandler实现类
		接口 = (接口) Proxy.newProxyInstance(接口.class.getClassLoader(), new Class[] {接口.class}, new 动态代理(实现类2));
		接口.打();
		接口.打("321");
		接口.跳();
	}

}
