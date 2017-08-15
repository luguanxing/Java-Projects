package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource2 {
	
	//���ݿ������Ϣ
	private static String url = "jdbc:mysql://localhost:3306/db_jdbc?generateSimpleParameterMetadata=true";
	private static String user = "root";
	private static String password = "root";
	
	//���ӳأ����ڻ���
	private static int INIT_CONNECTIONS = 1;
	private static int MAX_CONNECTIONS = 2;
	protected int CURRENT_CONNECTIONS = 0;
	protected LinkedList<Connection> connectionsPool = new LinkedList<Connection>();	//�޸�����ʹͬһ��������ʹ��
	
	public MyDataSource2() {
		try {
			for (int i =0; i < INIT_CONNECTIONS; i++)	//������INIT_CONNECTIONS��Connection
				this.connectionsPool.addLast(this.createConnection());
		} catch (Exception e) {
			System.out.println("��ʼ������");
		}
	}
	
	private Connection createConnection() throws Exception {
		//����MyConnection2���������
		Connection realConn = DriverManager.getConnection(url, user, password);
		MyConnection2 myConn = new MyConnection2(realConn, this);
		return myConn;
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
