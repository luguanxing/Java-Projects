import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtils;

public class ParameterMD {

	public static void main(String[] args) throws Exception {
		//有几个参数就对应数组里的几个Object
		Object[] params = new Object[] {"张三", 100f};
		read("select * from t_user where name = ? and money > ?", params);
	}

	static void read(String sql, Object[] params) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();	//获取PreparedStatement参数元数据信息
			int count = pmd.getParameterCount();
			if (count != params.length) {
				throw new Exception("参数个数不一致");
			}
			for (int i = 1; i <= count; i++) {					//注意下标从1开始赋值
				System.out.print("类名：" + pmd.getParameterClassName(i) + "\t");	//获取类型（不准确）注意在数据库连接url后加上?generateSimpleParameterMetadata=true
				System.out.print("类型：" + pmd.getParameterType(i) + "\t");
				System.out.print("类型名：" + pmd.getParameterTypeName(i)+ "\n");
				ps.setObject(i, params[i - 1]);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
					rs.getInt("id")+" "
					+rs.getString("name")+" "
					+rs.getDate("birthday")+" "
					+rs.getFloat("money")
				);
			}
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
}
