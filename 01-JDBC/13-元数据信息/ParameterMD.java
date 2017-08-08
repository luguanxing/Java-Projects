import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtils;

public class ParameterMD {

	public static void main(String[] args) throws Exception {
		//�м��������Ͷ�Ӧ������ļ���Object
		Object[] params = new Object[] {"����", 100f};
		read("select * from t_user where name = ? and money > ?", params);
	}

	static void read(String sql, Object[] params) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();	//��ȡPreparedStatement����Ԫ������Ϣ
			int count = pmd.getParameterCount();
			if (count != params.length) {
				throw new Exception("����������һ��");
			}
			for (int i = 1; i <= count; i++) {					//ע���±��1��ʼ��ֵ
				System.out.print("������" + pmd.getParameterClassName(i) + "\t");	//��ȡ���ͣ���׼ȷ��ע�������ݿ�����url�����?generateSimpleParameterMetadata=true
				System.out.print("���ͣ�" + pmd.getParameterType(i) + "\t");
				System.out.print("��������" + pmd.getParameterTypeName(i)+ "\n");
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
