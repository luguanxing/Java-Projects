import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.mysql.jdbc.Statement;

import jdbc.JdbcUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		������Ӳ���();
//		���ز���();
	}
	
	public static void ������Ӳ���() throws Exception {
		System.out.println("������Ӳ���");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils.getConnection();
			System.out.println(conn.getClass().getName());
			JdbcUtils.free(null, null, conn);
		}
	}
	
	public static void ���ز���() throws Exception {
		System.out.println("���ز���");
		for (int i = 0; i < 10; i++) {
			Connection conn = JdbcUtils.getConnection();
			System.out.println(conn);
		}
	}
}
