package dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl extends AbstractDao {

	public Account findAccount(int id) {
		String sql = "select id, name, money from t_account where id=?";
		Object[] args = {id};
		Object obj = super.find(sql, args);
		return (Account) obj;
	}
	
	@Override
	protected Object rowMapper(ResultSet rs) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setMoney(rs.getFloat("money"));
		account.setName(rs.getString("name"));
		return null;
	}

}
