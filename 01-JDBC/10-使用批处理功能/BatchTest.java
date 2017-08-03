import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import jdbc.JdbcUtils;

public class BatchTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		long p1, p2, p3;
		p1 = System.currentTimeMillis();
		
		//方式1：多次连接操作（不推荐）
		for (int i =0; i < 100; i++)
			test_nobatch(i);
		p2 = System.currentTimeMillis();
		
		//方式2：批处理,注意包不能太多否则可能内存溢出
		test_batch(100);
		p3 = System.currentTimeMillis();
		
		System.out.println("不用批处理时间:"+(p2-p1));
		System.out.println("使用批处理时间:"+(p3-p2));
	}

	public static void test_nobatch(int i) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			String sql = "INSERT INTO db_jdbc.t_user (NAME, birthday, money) VALUES(?, ?, ?);";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, "batch" + i);
			ps.setString(2, "2010-10-01");
			ps.setFloat(3, 5000f);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
	public static void test_batch(int n) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			String sql = "INSERT INTO db_jdbc.t_user (NAME, birthday, money) VALUES(?, ?, ?);";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			for (int i = 0; i < n; i++) {
				ps.setString(1, "batch" + i);
				ps.setString(2, "2010-10-01");
				ps.setFloat(3, 5000f);
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
}
