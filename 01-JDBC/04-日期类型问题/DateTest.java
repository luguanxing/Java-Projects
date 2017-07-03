import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DateTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO �Զ����ɵķ������
		Class.forName("com.mysql.jdbc.Driver");
		create("haha", new Date(), 123.567f);	//��ǰʱ��
		read("haha");
	}

	//��������ʹ��java.util.Date(����java.sql.Date)
	public static void create(String name, Date birthday, float money) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			String sql = "INSERT INTO db_jdbc.t_user (NAME, birthday, money) VALUES( ?, ?, ?);";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDate(2, new java.sql.Date(birthday.getTime()));	//java.util.DateתΪjava.sql.Date������ת���ࣩ
			ps.setFloat(3, money);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void read(String name) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		String sql = "select id, name, birthday, money from t_user where name = ?";
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			ps = (PreparedStatement) conn.prepareStatement(sql);	//����ʱPreparedStatement�Զ�����
			ps.setString(1, name);
			System.out.println("��Ҫִ�е�sql���Ϊ:" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("id")+"  ");
				System.out.print(rs.getString("name")+"  ");
				//java.sql.date�̳���java.util��date,��ֻ������û��ʱ��
				//Date utildate = rs.getDate("birthday"); //������Ը�������
				Date utildate = new Date(rs.getDate("birthday").getTime());
				System.out.print(utildate+"  ");
				System.out.print(rs.getFloat("money")+"  ");
				System.out.println("");
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
