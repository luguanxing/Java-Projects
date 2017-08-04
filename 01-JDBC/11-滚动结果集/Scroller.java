import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import jdbc.JdbcUtils;

public class Scroller {
	public static void main(String[] args) throws SQLException {
		scroll();
	}

	static void scroll() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = (Connection) JdbcUtils.getConnection();
			st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery("select id, name, birthday, money from t_user");
			
			System.out.println("------------");
			while (rs.next())
				output(rs);
			
			System.out.println("------------");
			if (rs.previous())
				output(rs);
			
			System.out.println("------------");
			rs.absolute(1);
			output(rs);
			
			System.out.println("------------");
			rs.absolute(1);
			for (int i = 0; i < 2 && rs.next(); i++) {	//限制次数
				output(rs);
			}
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
	
	static public void output(ResultSet rs) throws SQLException {
		for (int i = 1; i <= 4; i++) 
			System.out.print(rs.getObject(i)+"  ");
		System.out.println();
	}
}
