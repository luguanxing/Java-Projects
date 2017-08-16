package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource {
	
	//数据库基本信息
	private static String url = "jdbc:mysql://localhost:3306/db_jdbc?generateSimpleParameterMetadata=true";
	private static String user = "root";
	private static String password = "root";
	
	//连接池，用于缓冲
	private static int INIT_CONNECTIONS = 5;
	private static int MAX_CONNECTIONS = 8;
	private static int CURRENT_CONNECTIONS = 0;
	private LinkedList<Connection> connectionsPool = new LinkedList<Connection>();
	
	public MyDataSource() {
		try {
			for (int i =0; i < INIT_CONNECTIONS; i++)	//保存了INIT_CONNECTIONS个Connection
				this.connectionsPool.addLast(this.createConnection());
		} catch (Exception e) {
			System.out.println("初始化错误");
		}
	}
	
	private static Connection createConnection() throws Exception {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("创建Connection出错");
			conn = null;
		}
		return conn;
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
