package dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.User;
import jdbc.JdbcUtils;

public abstract class AbstractDao {

	//不变的地方放在抽象类，适用性更强(模板模式)
	public int update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i+1, args[i]);
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
	public Object find(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i+1, args[i]);
			rs = ps.executeQuery();
			if (rs.next()) {
				obj = rowMapper(rs);
			}
		} catch (SQLException e) {
			obj = null;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return obj;
	}
	
	//让子类实现映射方法，把结果集数据取出
	abstract protected Object rowMapper(ResultSet rs) throws SQLException;
	
}
