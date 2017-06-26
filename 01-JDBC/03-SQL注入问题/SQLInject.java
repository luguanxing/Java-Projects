import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SQLInject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		read("张三");				//正常使用
		read("' or 1 or '");		//SQL注入攻击，name = ''被注入后变成name = '' or 1 or ''结果是所有数据泄漏
		read_sql("张三");			//正常使用
		read_sql("' or 1 or '");	//防止SQL注入攻击
	}
	
	public static void read(String name) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select id, name, birthday, money from t_user where name = '" + name +"'";
		System.out.println("将要执行的sql语句为:" + sql);
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getObject("id")+"  ");
				System.out.print(rs.getObject("name")+"  ");
				System.out.print(rs.getObject("birthday")+"  ");
				System.out.print(rs.getObject("money")+"  ");
				System.out.println("");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void read_sql(String name) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		String sql = "select id, name, birthday, money from t_user where name = ?";
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			ps = (PreparedStatement) conn.prepareStatement(sql);	//构造时PreparedStatement自动过滤
			ps.setString(1, name);
			System.out.println("将要执行的sql语句为:" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getObject("id")+"  ");
				System.out.print(rs.getObject("name")+"  ");
				System.out.print(rs.getObject("birthday")+"  ");
				System.out.print(rs.getObject("money")+"  ");
				System.out.println("");
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
