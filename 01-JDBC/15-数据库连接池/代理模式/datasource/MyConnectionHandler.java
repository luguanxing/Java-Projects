package datasource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;


public class MyConnectionHandler implements InvocationHandler {

	private Connection realConnection;		//�������
	private Connection warpedConnection;	//HOOK��ٵ�����
	private MyDataSource3 myDataSource;
	
	public MyConnectionHandler(MyDataSource3 myDataSource) {
		this.myDataSource = myDataSource;
	}
	
	//ͨ���󶨽�realConnection�󵽾���Connectionʵ����
	Connection bind(Connection realConnection) {
		this.realConnection = realConnection;
		this.warpedConnection = (Connection) Proxy.newProxyInstance(	//�Զ������µ���(���ڴ���)ʵ����Connection�ӿڲ�ת����this����
						this.getClass().getClassLoader(), 
						new Class[]{Connection.class}, 
						this
				);
		return warpedConnection;
	}

	@Override
	//����realConnection������HOOKAPI
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("close".equals(method.getName())) {
			System.out.println("HOOK��close����");
			this.myDataSource.connectionsPool.addLast(this.warpedConnection);
		}
		return method.invoke(realConnection, args);	//��������ת��realConnection
	}

}
