import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.mysql.jdbc.Statement;

import jdbc.JdbcUtils;
import jdbc.JdbcUtils2;
import jdbc.JdbcUtils3;

public class Test3 {

	public static void main(String[] args) throws Exception {
		close≤‚ ‘();
	}
	
	public static void close≤‚ ‘() throws Exception {
		System.out.println("close≤‚ ‘()");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils3.getConnection();
			System.out.println(conn);
			conn.close();
		}
	}
	
}
