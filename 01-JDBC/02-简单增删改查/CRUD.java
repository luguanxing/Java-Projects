import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		create();	//增删改稍简单
		update();
		delete();
		read();		//稍微复杂，因为需要读结果集
	}

	public static void create() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/db_jdbc";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement st = null;
		int ret = 0;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);
			st = (Statement) conn.createStatement();
			String sql_create = "INSERT INTO db_jdbc.t_user (NAME, birthday, money) VALUES( 'testname', '2000-00-00', '1000');";
			ret = st.executeUpdate(sql_create);
			System.out.println("create影响了"+ret+"条记录");
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void read() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/db_jdbc";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);
			st = (Statement) conn.createStatement();
			rs = st.executeQuery("select id, name, birthday, money from t_user");		//选择表数据项名,不用*
			while (rs.next()) {															//可以用数据项名
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
	
	public static void update() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/db_jdbc";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement st = null;
		int ret = 0;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);
			st = (Statement) conn.createStatement();
			String sql_create = "update t_user set money=money+10;";
			ret = st.executeUpdate(sql_create);
			System.out.println("update影响了"+ret+"条记录");
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void delete() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/db_jdbc";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement st = null;
		int ret = 0;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);
			st = (Statement) conn.createStatement();
			String sql_create = "delete from t_user where id >= 4";
			ret = st.executeUpdate(sql_create);
			System.out.println("delete影响了"+ret+"条记录");
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
