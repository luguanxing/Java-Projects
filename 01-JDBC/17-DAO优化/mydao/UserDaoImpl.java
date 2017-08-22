package mydao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.User;

public class UserDaoImpl {	//策略模式
	
	MyDao mydao = new MyDao();
	
	public User findUser(String username) {
		String sql = "select id, name, money, birthday from t_user where name=?";
		Object[] args = {username};
		Object user = mydao.find(sql, args, new RowMapper() {	//传入sql语句，参数，具体映射策略
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setMoney(rs.getFloat("money"));
				user.setBirthday(rs.getDate("birthday"));
				return user;
			}
		});
		return (User) user;
	}

	public String findUserName(int id) {
		String sql = "select name from t_user where id=?";
		Object[] args = {id};
		Object name = mydao.find(sql, args, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				return rs.getString("name");
			}
		});
		return (String) name;
	}
	
}
