package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datasource.MyDataSource2;

/**
 * 	JdbcUtils的连接类，用于化简JDBC连接
 */
public final class JdbcUtils2 {

	//数据源使用单例模式
	private static MyDataSource2 mds = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			mds = new MyDataSource2();
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
