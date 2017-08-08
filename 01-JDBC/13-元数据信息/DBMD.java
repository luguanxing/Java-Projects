
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;


import jdbc.JdbcUtils;

public class DBMD {

	public static void main(String[] args) throws SQLException {

		Connection conn = JdbcUtils.getConnection();
		
		DatabaseMetaData dbmd = conn.getMetaData();
		System.out.println("���ݿ�����"+dbmd.getDatabaseProductName());
		System.out.println("���ݿ�汾��"+dbmd.getDatabaseProductVersion());
		System.out.println("�Ƿ�֧������"+dbmd.supportsTransactions());
		
		JdbcUtils.free(null, null, conn);
		
	}

}
