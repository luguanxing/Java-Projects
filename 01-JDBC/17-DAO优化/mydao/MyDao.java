package mydao;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.User;
import jdbc.JdbcUtils;

public class MyDao {
	
	public Object find(String sql, Object[] args, RowMapper rowMapper) {
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
				//使用传入接口的映射行方法
				obj = rowMapper.mapRow(rs);
			}
		} catch (SQLException e) {
			System.out.println(e);
			obj = null;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return obj;
	}
	
}
