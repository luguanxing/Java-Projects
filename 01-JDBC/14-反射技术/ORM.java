import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.User;
import jdbc.JdbcUtils;

public class ORM {

	public static void main(String[] args) throws Exception {
		//����Userʵ���������Ѵ����ݿ�ȡ�����ݲ�����ֵ
		User user = (User) getObject("select id as Id, name as Name, birthday as Birthday, money as Money from t_user where id = 1", User.class);
		System.out.println(user);
		
		//ͬ�������Bean��ֻ��name���Խ��ܵ�����setName����
		Bean bean = (Bean) getObject("select id as Id, name as Name, birthday as Birthday, money as Money from t_user where id = 1", Bean.class);
		System.out.println(bean);		
	}
	
	//����������������޹أ��ܵõ�����Object������Ը�
	public static Object getObject(String sql, Class clazz) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();							//��ȡResultSet
			ResultSetMetaData rsmd = rs.getMetaData();		//��ȡResultSet��Ϣ
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count];
			for (int i = 1; i <= count; i++)				//��ȡResultSet����(��ǩ��)
				colNames[i-1] = rsmd.getColumnLabel(i);
			
			Object object = null;
			
			if (rs.next()) {
				object = clazz.newInstance();	//����Ϊ���������ķ���
				Method[] methods = object.getClass().getMethods();	//��ȡ��������public����
				for (int i = 0; i < colNames.length; i++) {
					String colName = colNames[i];
					String MethodName = "set" + colName;				//׼������set����
					for (Method method : methods) {						//������set����
						if (MethodName.equals(method.getName())) {		//����set����,����colName
							System.out.println("�����˷���"+MethodName+"("+rs.getObject(colName)+")");
							method.invoke(object, rs.getObject(colName));
						}
					}
				}
			}
			return object;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
