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

	//线程安全
	static JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSource());
	
	public static void main(String[] args) {
		System.out.println(findUser("张三"));
		
		List<User> users = findUsers(5);
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println("总共有"+getUserCount()+"条记录");
		
		System.out.println(getUserName(1));
		
		Map map = findUserMap(1);
		System.out.println(map);
	}
	
	public static User findUser(String username) {
		//能自动转registDate为regist_date或使用别名regist_date_abc as registDate均可
		String sql = "select id, name, money, birthday from t_user where name=?";
		Object[] args = {username};
		//传入参数：sql语句，参数，User.class类（BeanPropertyRowMapper会自动帮你用反射和metadata创建对象并设置）
		//注意queryForObject只返回一条记录，如果找不到或找到多个则会报错
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
		int[] argTypes = {Types.INTEGER};	//传入的参数类型，不传也可以(spring会通过反射知道类型)
		List<User> users = jdbc.query(sql, args, argTypes, new BeanPropertyRowMapper(User.class));
		return users;
	}
	
	public static User findUserWithRowMapper(String username) {
		String sql = "select id, name, money, birthday from t_user where name=?";
		Object[] args = {username};
		Object user = jdbc.queryForObject(sql, args, new RowMapper(){	//传入参数：sql语句，参数，映射器实现
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
