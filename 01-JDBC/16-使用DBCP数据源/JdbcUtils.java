package jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 	JdbcUtils�������࣬���ڻ���JDBC����
 */
public final class JdbcUtils {

	//ʹ��DBCP
	private static DataSource ds = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();		//��ȡ�����ļ�
			InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(is);
			ds = BasicDataSourceFactory.createDataSource(prop);	//ͨ��������������Դ����Ҫ���ò���
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
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
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	
}
