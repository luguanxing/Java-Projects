package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource {
	
	//���ݿ������Ϣ
	private static String url = "jdbc:mysql://localhost:3306/db_jdbc?generateSimpleParameterMetadata=true";
	private static String user = "root";
	private static String password = "root";
	
	//���ӳأ����ڻ���
	private static int INIT_CONNECTIONS = 5;
	private static int MAX_CONNECTIONS = 8;
	private static int CURRENT_CONNECTIONS = 0;
	private LinkedList<Connection> connectionsPool = new LinkedList<Connection>();
	
	public MyDataSource() {
		try {
			for (int i =0; i < INIT_CONNECTIONS; i++)	//������INIT_CONNECTIONS��Connection
				this.connectionsPool.addLast(this.createConnection());
		} catch (Exception e) {
			System.out.println("��ʼ������");
		}
	}
	
	private static Connection createConnection() throws Exception {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("����Connection����");
			conn = null;
		}
		return conn;
	}
	
	public Connection getConnection() throws Exception {
		//��֤�̰߳�ȫ��Ҳ����������ȡConnection
		synchronized (connectionsPool) {		//�̳߳ػ���Connection
			if (connectionsPool.size() > 0) {
				CURRENT_CONNECTIONS++;
				return connectionsPool.removeFirst();
			} else {								//�̳߳�û��Connection�ˣ����Լ�������ֱ�����ֵ
				if (CURRENT_CONNECTIONS < MAX_CONNECTIONS) {
					System.out.println("�½�Connection");
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
