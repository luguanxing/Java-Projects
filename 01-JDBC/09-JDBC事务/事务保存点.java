import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DTsavepoint {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		test();
	}
	
	public static void test() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			conn.setAutoCommit(false);					//事务开始
			st = (Statement) conn.createStatement();
			String sql;
			float money = 0f;
			//模拟加钱，回滚时回滚到该步
			sql = "update t_user set money=money+1000 where id = 3";
			st.executeUpdate(sql);
			sp = conn.setSavepoint();	//在此设立保存点，回滚时到此即结束（这部必完成）
			
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
			if (conn != null && sp != null) {
				conn.rollback(sp);
				conn.commit();
			}
			System.out.println("回滚到保存点");
			System.out.println(e);
		}
	}
}
