package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class JdbcTemplateTest {

	//�̰߳�ȫ
	static JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSource());
	
	public static void main(String[] args) {
		System.out.println(findUser("����"));
		
		List<User> users = findUsers(5);
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println("�ܹ���"+getUserCount()+"����¼");
		
		System.out.println(getUserName(1));
		
		Map map = findUserMap(1);
		System.out.println(map);
	}
	
	public static User findUser(String username) {
		//���Զ�תregistDateΪregist_date��ʹ�ñ���regist_date_abc as registDate����
		String sql = "select id, name, money, birthday from t_user where name=?";
		Object[] args = {username};
		//���������sql��䣬������User.class�ࣨBeanPropertyRowMapper���Զ������÷����metadata�����������ã�
		//ע��queryForObjectֻ����һ����¼������Ҳ������ҵ������ᱨ��
		Object user = jdbc.queryForObject(sql, args, new BeanPropertyRowMapper(User.class));
		return (User) user;
	}
	
	public static String getUserName(int id) {
		String sql = "select name from t_user where id="+id;
		return (String) jdbc.queryForObject(sql, String.class);
	}
	
	public static int getUserCount() {
		String sql = "select count(*) from t_user";
		return jdbc.queryForInt(sql);
	}
	
	public static List<User> findUsers(int maxid) {
		String sql = "select id, name, money, birthday from t_user where id < ?";
		Object[] args = {maxid};
		int[] argTypes = {Types.INTEGER};	//����Ĳ������ͣ�����Ҳ����(spring��ͨ������֪������)
		List<User> users = jdbc.query(sql, args, argTypes, new BeanPropertyRowMapper(User.class));
		return users;
	}
	
	public static User findUserWithRowMapper(String username) {
		String sql = "select id, name, money, birthday from t_user where name=?";
		Object[] args = {username};
		Object user = jdbc.queryForObject(sql, args, new RowMapper(){	//���������sql��䣬������ӳ����ʵ��
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
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

	public static Map findUserMap(int id) {
		String sql = "select id, name, money, birthday from t_user where id = " + id;
		return jdbc.queryForMap(sql);
	}

}
