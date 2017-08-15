import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.mysql.jdbc.Statement;

import jdbc.JdbcUtils;
import jdbc.JdbcUtils2;

public class Test2 {

	public static void main(String[] args) throws Exception {
//		∂‡¥Œ¡¨Ω”≤‚ ‘();
//		≥¨‘ÿ≤‚ ‘();
		close≤‚ ‘();
	}
	
	public static void ∂‡¥Œ¡¨Ω”≤‚ ‘() throws Exception {
		System.out.println("∂‡¥Œ¡¨Ω”≤‚ ‘");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils2.getConnection();
			System.out.println(conn);
			JdbcUtils2.free(null, null, conn);
		}
	}
	
	public static void ≥¨‘ÿ≤‚ ‘() throws Exception {
		System.out.println("≥¨‘ÿ≤‚ ‘");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils2.getConnection();
			System.out.println(conn);
		}
	}
	
	public static void close≤‚ ‘() throws Exception {
		System.out.println("close≤‚ ‘()");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils2.getConnection();
			System.out.println(conn);
			conn.close();
		}
	}
}
