import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import jdbc.JdbcUtils;

public class 存储过程 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//CallableStatement();
		System.out.println(addUser_returnId("addUser_returnId", "2020-10-01", 6666f));
	}
	public static void CallableStatement() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			String sql = "{ call addUser_returnId(?, ?, ?, ?) }";
			cs = (CallableStatement) conn.prepareCall(sql);
			
			//输入3个参数
			cs.setString(1, "CallableStatement");
			cs.setString(2, "2020-10-01");
			cs.setFloat(3, 5000f);
			
			//输出1个参数
			cs.registerOutParameter(4, Types.INTEGER);
			
			cs.executeUpdate();
			int ret = cs.getInt(4);
			System.out.println(ret);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JdbcUtils.free(rs, cs, conn);
		}
	}
	
	public static int addUser_returnId(String name, String date, Float money) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			String sql = "INSERT INTO db_jdbc.t_user (NAME, birthday, money) VALUES(?, ?, ?);";
			
			//设置可返回主键
			ps = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setString(2, date);
			ps.setFloat(3, money);
			ps.executeUpdate();
			
			//取出主键,返回键集(可能是复合主键)
			rs = ps.getGeneratedKeys();
			if (rs.next())
				ret =rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e);
			ret = -1;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return ret;
	}
}
