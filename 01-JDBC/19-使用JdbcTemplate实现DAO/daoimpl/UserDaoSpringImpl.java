package daoimpl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import dao.User;
import dao.UserDAO;
import spring.JdbcUtils;

public class UserDaoSpringImpl implements UserDAO {

	private SimpleJdbcTemplate simple = new SimpleJdbcTemplate(JdbcUtils.getDataSource());
	
	@Override
	public boolean addUser(User user) {
		try {
			String sql = "insert into t_user (name, money, birthday) values (:name, :money, :birthday)";
			SqlParameterSource param = new BeanPropertySqlParameterSource(user);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			simple.getNamedParameterJdbcOperations().update(sql, param, keyHolder);
			user.setId(keyHolder.getKey().intValue());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User getUser(int userId) {
		String sql = "select id, name, money, birthday  from t_user where id = ?";
		return simple.queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(User.class),  userId);
	}

	@Override
	public User findUser(String username) {
		String sql = "select id, name, money, birthday  from t_user where name = ?";
		return simple.queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(User.class),  username);
	}

	@Override
	public boolean update(User user) {
		try {
			String sql = "update t_user set name=:name, birthday=:birthday, money=:money where id=:id ";
			simple.update(sql, new BeanPropertySqlParameterSource(user));
			return true;
		} catch (Exception e) {
			return false;
		}
//		try {
//			String sql = "update t_user set name=?, birthday=?, money=? where id=? ";
//			simple.update(sql, user.getName(), user.getBirthday(), user.getMoney(), user.getId());
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
	}

	@Override
	public boolean delete(User user) {
		String sql = "delete from t_user where id = ?";
		simple.update(sql, user.getId());
		return false;
	}

}
