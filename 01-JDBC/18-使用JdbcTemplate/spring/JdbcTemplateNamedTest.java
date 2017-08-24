package spring;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class JdbcTemplateNamedTest {

	private static NamedParameterJdbcTemplate named = new NamedParameterJdbcTemplate(JdbcUtils.getDataSource());
	
	public static void main(String[] args) {
//		User user = new User();
//		user.setMoney(10);
//		user.setId(2);
//		System.out.println(findUser(user));
//		System.out.println(findUser2(user));
		
		User maozedong = new User();
		maozedong.setName("maozedong");
		maozedong.setMoney(10);
		maozedong.setMoney(999999);
		maozedong.setBirthday(new Date());
		System.out.println(addUser(maozedong));
	}
	
	public static User findUser(User user) {
		String sql = "select id, name, money, birthday from t_user where money > :m and id < :id";
		//旧方法，必须要一一对应
		Object[] args = {user.getName(), user.getMoney(), user.getId()};
		//新方法，用map对应
		Map params = new HashMap();
		params.put("n", user.getName());
		params.put("m", user.getMoney());
		params.put("id", user.getId());
		Object obj = named.queryForObject(sql, params, new BeanPropertyRowMapper(User.class));
		return (User) obj;	//只能查询一个，查到多个报错
	}
	
	public static User findUser2(User user) {
		String sql = "select id, name, money, birthday from t_user where money > :money and id < :id";
		//使用BeanPropertySqlParameterSource优化，但要求变量名要和属性相同
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		Object obj = named.queryForObject(sql, ps, new BeanPropertyRowMapper(User.class));
		return (User) obj;
	}

	public static User addUser(User user) {
		String sql = "insert into t_user(name,birthday, money) values (:name,:birthday,:money) ";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		named.update(sql, ps, keyHolder);
		int id = keyHolder.getKey().intValue();	//可获得主键，如果不是int型用keyHolder.getKeys();
		user.setId(id);
		return user;
	}
	
}
