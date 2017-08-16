package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 	JdbcUtils�������࣬���ڻ���JDBC����
 */
public final class JdbcUtils {

	//����Դʹ�õ���ģʽ
	private static MyDataSource mds = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			mds = new MyDataSource();
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() {
		try {
			return mds.getConnection();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static void free(ResultSet rs, Statement st, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				mds.freeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	
}
