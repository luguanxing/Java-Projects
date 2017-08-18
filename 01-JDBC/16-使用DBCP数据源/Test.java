import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.mysql.jdbc.Statement;

import jdbc.JdbcUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		多次连接测试();
//		超载测试();
	}
	
	public static void 多次连接测试() throws Exception {
		System.out.println("多次连接测试");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils.getConnection();
			System.out.println(conn.getClass().getName());
			JdbcUtils.free(null, null, conn);
		}
	}
	
	public static void 超载测试() throws Exception {
		System.out.println("超载测试");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils.getConnection();
			System.out.println(conn);
		}
	}
}
