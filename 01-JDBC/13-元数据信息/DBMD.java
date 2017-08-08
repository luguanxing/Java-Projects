
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;


import jdbc.JdbcUtils;

public class DBMD {

	public static void main(String[] args) throws SQLException {

		Connection conn = JdbcUtils.getConnection();
		
		DatabaseMetaData dbmd = conn.getMetaData();
		System.out.println("数据库名："+dbmd.getDatabaseProductName());
		System.out.println("数据库版本："+dbmd.getDatabaseProductVersion());
		System.out.println("是否支持事务："+dbmd.supportsTransactions());
		
		JdbcUtils.free(null, null, conn);
		
	}

}
