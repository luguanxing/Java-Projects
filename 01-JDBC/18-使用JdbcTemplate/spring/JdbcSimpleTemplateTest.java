package spring;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class JdbcSimpleTemplateTest {
	
	private static SimpleJdbcTemplate simple = new SimpleJdbcTemplate(JdbcUtils.getDataSource());

	public static void main(String[] args) {
		System.out.println(findUser("张三"));
	}
	
	public static User findUser(String username) {
		String sql = "select id, name, money, birthday from t_user where name = ? and money > ?";
		//特性：1.能返回泛型， 2.使用...可变参数，但要作为最后一个参数
		User user = simple.queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(User.class), username, 100f);
		//可以调用成员模板方法simple.getNamedParameterJdbcOperations().update(arg0, arg1)
		//同理有simple.getJdbcOperations()
		return user;
	}

}
