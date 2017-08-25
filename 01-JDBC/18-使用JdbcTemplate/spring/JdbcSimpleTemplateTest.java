package spring;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class JdbcSimpleTemplateTest {
	
	private static SimpleJdbcTemplate simple = new SimpleJdbcTemplate(JdbcUtils.getDataSource());

	public static void main(String[] args) {
		System.out.println(findUser("����"));
	}
	
	public static User findUser(String username) {
		String sql = "select id, name, money, birthday from t_user where name = ? and money > ?";
		//���ԣ�1.�ܷ��ط��ͣ� 2.ʹ��...�ɱ��������Ҫ��Ϊ���һ������
		User user = simple.queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(User.class), username, 100f);
		//���Ե��ó�Աģ�巽��simple.getNamedParameterJdbcOperations().update(arg0, arg1)
		//ͬ����simple.getJdbcOperations()
		return user;
	}

}
