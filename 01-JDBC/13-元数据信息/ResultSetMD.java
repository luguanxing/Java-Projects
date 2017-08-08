import java.awt.List;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jdbc.JdbcUtils;

public class ResultSetMD {
	//结果集ResultSet返回List<Map>查询方便，灵活性高
	public static void main(String[] args) throws Exception {
		ArrayList<Map<String, Object>> list = read("select id, name from t_user where id < 5");
		System.out.println(list);
	}
	
	static ArrayList<Map<String, Object>> read(String sql) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Map<String, Object>> list = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count];
			for (int i = 1; i <= count; i++) {
				System.out.print("列类型" + rsmd.getColumnClassName(i) + "\t");	//获取类型（准确）
				System.out.print("列名" + rsmd.getColumnName(i) + "\t");		//获取真标签名
				System.out.print("列标签" + rsmd.getColumnLabel(i) + "\n");	//获取别名
				colNames[i-1] = rsmd.getColumnLabel(i);	//有别名则使用别名
			}
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<Map<String, Object>>();
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < colNames.length; i++)
					map.put(colNames[i], rs.getObject(colNames[i]));
				list.add(map);
			}
			return list;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
}
