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
 * 	JdbcUtils的连接类，用于化简JDBC连接
 */
public final class JdbcUtils {

	//使用DBCP
	private static DataSource ds = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();		//读取配置文件
			InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(is);
			ds = BasicDataSourceFactory.createDataSource(prop);	//通过工厂创建数据源，需要配置参数
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
