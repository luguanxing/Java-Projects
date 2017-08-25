package daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.User;
import dao.UserDAO;
import jdbc.JdbcUtils;

public class UserDaoJdbcImpl implements UserDAO {

	@Override
	public boolean addUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;	//先假设操作失败
		try {
			conn = (Connection) JdbcUtils.getConnection();
			String sql = "insert into t_user(name,birthday, money) values (?,?,?) ";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
			ps.setFloat(3, user.getMoney());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return result;
	}

	@Override
	public User getUser(int userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			String sql = "select id, name, money, birthday  from t_user where id=?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = mappingUser(rs);
			}
		} catch (SQLException e) {
			user = null;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return user;
	}

	@Override
	public User findUser(String loginName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			String sql = "select id, name, money, birthday  from t_user where name=?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, loginName);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = mappingUser(rs);
			}
		} catch (SQLException e) {
			user = null;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return user;
	}

	@Override
	public boolean update(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			String sql = "update t_user set name=?, birthday=?, money=? where id=? ";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
			ps.setFloat(3, user.getMoney());
			ps.setInt(4, user.getId());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return result;
	}

	@Override
	public boolean delete(User user) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			st = (Statement) conn.createStatement();
			String sql = "delete from t_user where id=" + user.getId();
			st.executeUpdate(sql);
			result = true;
		} catch (SQLException e) {
			result = false;
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
		return result;
	}

	
	private User mappingUser(ResultSet rs) throws SQLException {
		//抽象的方法，用于化简
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setMoney(rs.getFloat("money"));
		user.setBirthday(rs.getDate("birthday"));
		return user;
	}
}
