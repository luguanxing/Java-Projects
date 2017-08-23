package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class JdbcTemplateTest2 {

	static JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSource());
	
	public static void main(String[] args) {
		User user = new User();
		user.setBirthday(new Date());
		user.setMoney(123);
		user.setName("hahaha");
		System.out.println(addUser(user));
	}
	
	public static int addUser(final User user) {
		int retid = (int) jdbc.execute(new ConnectionCallback() {
			@Override
			public Object doInConnection(Connection conn) throws SQLException, DataAccessException {
				//可以操作Connection，可用于存储过程的执行
				String sql = "insert into t_user(name,birthday, money) values (?,?,?) ";
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
				ps.setFloat(3, user.getMoney());
				ps.executeUpdate();

				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					user.setId(rs.getInt(1));
				
				return user.getId();
			}
		});
		return retid;
	}

}
