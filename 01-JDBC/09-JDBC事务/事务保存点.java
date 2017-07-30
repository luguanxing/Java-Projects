import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DTsavepoint {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		test();
	}
	
	public static void test() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			conn.setAutoCommit(false);					//����ʼ
			st = (Statement) conn.createStatement();
			String sql;
			float money = 0f;
			//ģ���Ǯ���ع�ʱ�ع����ò�
			sql = "update t_user set money=money+1000 where id = 3";
			st.executeUpdate(sql);
			sp = conn.setSavepoint();	//�ڴ���������㣬�ع�ʱ���˼��������ⲿ����ɣ�
			
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
			if (conn != null && sp != null) {
				conn.rollback(sp);
				conn.commit();
			}
			System.out.println("�ع��������");
			System.out.println(e);
		}
	}
}
