import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DTtest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		test1();	//���������񣬳����ɻع�
		test2();	//�������񣬳���ɻع�
	}

	public static void test1() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			st = (Statement) conn.createStatement();
			String sql;
			float money = 0f;
			//ģ��ת�ˣ�id=1�û���ȥ10Ԫ
			sql = "update t_user set money=money-10 where id = 1";
			st.executeUpdate(sql);
			//�鿴id=2�û����
			sql = "SELECT money FROM t_user WHERE id = 2";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				money = rs.getFloat("money");
			} else {
				throw new Exception("sql�����");
			}
			//�������Ƴ�������ת��
			if (money > 500)
				throw new Exception("money�������ֵ");
			sql = "update t_user set money=money+10 where id = 1";
			st.executeUpdate(sql);
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void test2() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			conn.setAutoCommit(false);					//����ʼ
			st = (Statement) conn.createStatement();
			String sql;
			float money = 0f;
			//ģ��ת�ˣ�id=1�û���ȥ10Ԫ
			sql = "update t_user set money=money-10 where id = 1";
			st.executeUpdate(sql);
			//�鿴id=2�û����
			sql = "SELECT money FROM t_user WHERE id = 2";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				money = rs.getFloat("money");
			} else {
				throw new Exception("sql�����");
			}
			//�������Ƴ�������ת��
			if (money > 500)
				throw new Exception("money�������ֵ");
			sql = "update t_user set money=money+10 where id = 1";
			st.executeUpdate(sql);
			conn.commit();					//�����ύ
			st.close();
			conn.close();
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			System.out.println("�ع�");
			System.out.println(e);
		}
	}
}
