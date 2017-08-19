package dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.User;

public class UserDaoImpl extends AbstractDao {

	//�����û���ֻ���û������ⲿ�ֵ���д�����๫��������Ϊ����(ģ��ģʽ)
	public void update(User user) {
		String sql = "update t_user set name=?, birthday=?, money=? where id=?";
		Object[] args = {user.getName(), user.getBirthday(), user.getMoney(), user.getId()};
		int ret = super.update(sql, args);
		if (ret > 0)
			System.out.println("���³ɹ�");
	}
	
	//add�����Ҫ����Ҫ����д���࣬��Ȼ����������
	public void delete(User user) {
		String sql = "delete from t_user where id=?";
		Object[] args = {user.getId()};
		int ret = super.update(sql, args);
		if (ret > 0)
			System.out.println("ɾ���ɹ�");
	}

	//����ӳ�䷽���ǳ���ģ�����ʵ����Userӳ�䷽�������ݲ�ѯ���ӳ��
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
