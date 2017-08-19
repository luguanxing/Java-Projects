package dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.User;
import jdbc.JdbcUtils;

public abstract class AbstractDao {

	//����ĵط����ڳ����࣬�����Ը�ǿ(ģ��ģʽ)
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
	
	//������ʵ��ӳ�䷽�����ѽ��������ȡ��
	abstract protected Object rowMapper(ResultSet rs) throws SQLException;
	
}
