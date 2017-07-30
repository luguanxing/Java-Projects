import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DTtest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		test1();	//不采用事务，出错不可回滚
		test2();	//采用事务，出错可回滚
	}

	public static void test1() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			st = (Statement) conn.createStatement();
			String sql;
			float money = 0f;
			//模拟转账，id=1用户减去10元
			sql = "update t_user set money=money-10 where id = 1";
			st.executeUpdate(sql);
			//查看id=2用户余额
			sql = "SELECT money FROM t_user WHERE id = 2";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				money = rs.getFloat("money");
			} else {
				throw new Exception("sql表错误");
			}
			//超出限制出错，否则转账
			if (money > 500)
				throw new Exception("money超过最大值");
			sql = "update t_user set money=money+10 where id = 1";
			st.executeUpdate(sql);
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void test2() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			conn.setAutoCommit(false);					//事务开始
			st = (Statement) conn.createStatement();
			String sql;
			float money = 0f;
			//模拟转账，id=1用户减去10元
			sql = "update t_user set money=money-10 where id = 1";
			st.executeUpdate(sql);
			//查看id=2用户余额
			sql = "SELECT money FROM t_user WHERE id = 2";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				money = rs.getFloat("money");
			} else {
				throw new Exception("sql表错误");
			}
			//超出限制出错，否则转账
			if (money > 500)
				throw new Exception("money超过最大值");
			sql = "update t_user set money=money+10 where id = 1";
			st.executeUpdate(sql);
			conn.commit();					//事务提交
			st.close();
			conn.close();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("回滚");
			System.out.println(e);
		}
	}
}
