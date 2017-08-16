package datasource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;


public class MyConnectionHandler implements InvocationHandler {

	private Connection realConnection;		//真的连接
	private Connection warpedConnection;	//HOOK后假的连接
	private MyDataSource3 myDataSource;
	
	public MyConnectionHandler(MyDataSource3 myDataSource) {
		this.myDataSource = myDataSource;
	}
	
	//通过绑定将realConnection绑到具体Connection实现类
	Connection bind(Connection realConnection) {
		this.realConnection = realConnection;
		this.warpedConnection = (Connection) Proxy.newProxyInstance(	//自动产生新的类(在内存中)实现了Connection接口并转发个this处理
						this.getClass().getClassLoader(), 
						new Class[]{Connection.class}, 
						this
				);
		return warpedConnection;
	}

	@Override
	//代理到realConnection，类似HOOKAPI
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("close".equals(method.getName())) {
			System.out.println("HOOK的close方法");
			this.myDataSource.connectionsPool.addLast(this.warpedConnection);
		}
		return method.invoke(realConnection, args);	//方法调用转到realConnection
	}

}
