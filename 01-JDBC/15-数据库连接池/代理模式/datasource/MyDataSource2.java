package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource2 {
	
	//数据库基本信息
	private static String url = "jdbc:mysql://localhost:3306/db_jdbc?generateSimpleParameterMetadata=true";
	private static String user = "root";
	private static String password = "root";
	
	//连接池，用于缓冲
	private static int INIT_CONNECTIONS = 1;
	private static int MAX_CONNECTIONS = 2;
	protected int CURRENT_CONNECTIONS = 0;
	protected LinkedList<Connection> connectionsPool = new LinkedList<Connection>();	//修改属性使同一个包内能使用
	
	public MyDataSource2() {
		try {
			for (int i =0; i < INIT_CONNECTIONS; i++)	//保存了INIT_CONNECTIONS个Connection
				this.connectionsPool.addLast(this.createConnection());
		} catch (Exception e) {
			System.out.println("初始化错误");
		}
	}
	
	private Connection createConnection() throws Exception {
		//创建MyConnection2并放入池中
		Connection realConn = DriverManager.getConnection(url, user, password);
		MyConnection2 myConn = new MyConnection2(realConn, this);
		return myConn;
	}
	
	public Connection getConnection() throws Exception {
		//保证线程安全，也不能无限制取Connection
		synchronized (connectionsPool) {		//线程池还有Connection
			if (connectionsPool.size() > 0) {
				CURRENT_CONNECTIONS++;
				return connectionsPool.removeFirst();
			} else {								//线程池没有Connection了，可以继续创建直到最大值
				if (CURRENT_CONNECTIONS < MAX_CONNECTIONS) {
					System.out.println("新建Connection");
					CURRENT_CONNECTIONS++;
					return createConnection();
				} else {
					return null;
				}
			}
		}
	}
	
	public void freeConnection(Connection conn) {
		connectionsPool.addLast(conn);
		CURRENT_CONNECTIONS--;
	}
}
