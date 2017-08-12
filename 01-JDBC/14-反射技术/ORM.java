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
		//返回User实例，并且已从数据库取出数据并设置值
		User user = (User) getObject("select id as Id, name as Name, birthday as Birthday, money as Money from t_user where id = 1", User.class);
		System.out.println(user);
		
		//同样的语句Bean中只有name所以仅能调用了setName方法
		Bean bean = (Bean) getObject("select id as Id, name as Name, birthday as Birthday, money as Money from t_user where id = 1", Bean.class);
		System.out.println(bean);		
	}
	
	//返回类型与具体类无关，能得到任意Object，灵活性高
	public static Object getObject(String sql, Class clazz) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();							//获取ResultSet
			ResultSetMetaData rsmd = rs.getMetaData();		//获取ResultSet信息
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count];
			for (int i = 1; i <= count; i++)				//获取ResultSet列名(标签名)
				colNames[i-1] = rsmd.getColumnLabel(i);
			
			Object object = null;
			
			if (rs.next()) {
				object = clazz.newInstance();	//必须为不带参数的方法
				Method[] methods = object.getClass().getMethods();	//获取该类所有public方法
				for (int i = 0; i < colNames.length; i++) {
					String colName = colNames[i];
					String MethodName = "set" + colName;				//准备调用set方法
					for (Method method : methods) {						//遍历找set方法
						if (MethodName.equals(method.getName())) {		//调用set方法,设置colName
							System.out.println("调用了方法"+MethodName+"("+rs.getObject(colName)+")");
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
