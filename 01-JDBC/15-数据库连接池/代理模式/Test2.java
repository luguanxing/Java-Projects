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
//		������Ӳ���();
//		���ز���();
		close����();
	}
	
	public static void ������Ӳ���() throws Exception {
		System.out.println("������Ӳ���");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils2.getConnection();
			System.out.println(conn);
			JdbcUtils2.free(null, null, conn);
		}
	}
	
	public static void ���ز���() throws Exception {
		System.out.println("���ز���");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils2.getConnection();
			System.out.println(conn);
		}
	}
	
	public static void close����() throws Exception {
		System.out.println("close����()");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils2.getConnection();
			System.out.println(conn);
			conn.close();
		}
	}
}
