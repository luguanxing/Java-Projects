import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SQLInject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		read("����");				//����ʹ��
		read("' or 1 or '");		//SQLע�빥����name = ''��ע�����name = '' or 1 or ''�������������й©
		read_sql("����");			//����ʹ��
		read_sql("' or 1 or '");	//��ֹSQLע�빥��
	}
	
	public static void read(String name) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select id, name, birthday, money from t_user where name = '" + name +"'";
		System.out.println("��Ҫִ�е�sql���Ϊ:" + sql);
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
			ps = (PreparedStatement) conn.prepareStatement(sql);	//����ʱPreparedStatement�Զ�����
			ps.setString(1, name);
			System.out.println("��Ҫִ�е�sql���Ϊ:" + ps.toString());
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
