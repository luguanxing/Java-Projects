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
	//�����ResultSet����List<Map>��ѯ���㣬����Ը�
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
				System.out.print("������" + rsmd.getColumnClassName(i) + "\t");	//��ȡ���ͣ�׼ȷ��
				System.out.print("����" + rsmd.getColumnName(i) + "\t");		//��ȡ���ǩ��
				System.out.print("�б�ǩ" + rsmd.getColumnLabel(i) + "\n");	//��ȡ����
				colNames[i-1] = rsmd.getColumnLabel(i);	//�б�����ʹ�ñ���
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
