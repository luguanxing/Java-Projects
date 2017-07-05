import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DateTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
		Class.forName("com.mysql.jdbc.Driver");
		create("haha", new Date(), 123.567f);	//当前时间
		read("haha");
	}

	//参数传入使用java.util.Date(区别java.sql.Date)
	public static void create(String name, Date birthday, float money) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			String sql = "INSERT INTO db_jdbc.t_user (NAME, birthday, money) VALUES( ?, ?, ?);";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDate(2, new java.sql.Date(birthday.getTime()));	//java.util.Date转为java.sql.Date（父类转子类）
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
			ps = (PreparedStatement) conn.prepareStatement(sql);	//构造时PreparedStatement自动过滤
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("id")+"  ");
				System.out.print(rs.getString("name")+"  ");
				//java.sql.date继承了java.util的date,但只有日期没有时间
				//Date utildate = rs.getDate("birthday"); //子类可以赋给父类
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
