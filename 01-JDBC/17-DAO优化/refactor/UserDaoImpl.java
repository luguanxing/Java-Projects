package dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.User;

public class UserDaoImpl extends AbstractDao {

	//更新用户，只把用户的特殊部分单独写，其余公共部分作为超类(模板模式)
	public void update(User user) {
		String sql = "update t_user set name=?, birthday=?, money=? where id=?";
		Object[] args = {user.getName(), user.getBirthday(), user.getMoney(), user.getId()};
		int ret = super.update(sql, args);
		if (ret > 0)
			System.out.println("更新成功");
	}
	
	//add如果需要主键要另外写超类，不然和上述类似
	public void delete(User user) {
		String sql = "delete from t_user where id=?";
		Object[] args = {user.getId()};
		int ret = super.update(sql, args);
		if (ret > 0)
			System.out.println("删除成功");
	}

	//超类映射方法是抽象的，子类实现了User映射方法，根据查询语句映射
	@Override
	protected Object rowMapper(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setMoney(rs.getFloat("money"));
		user.setBirthday(rs.getDate("birthday"));
		return user;
	}
	
	public User findUser(String loginName) {
		String sql = "select id, name, money, birthday from t_user where name=?";
		Object[] args = {loginName};
		Object obj = super.find(sql, args);
		return (User) obj;
	}

}
