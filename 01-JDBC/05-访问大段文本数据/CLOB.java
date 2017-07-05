import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Clob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CLOB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//将大文件src/DateTest.java读入数据库
		File readfile = new File("src/DateTest.java");
		Reader reader = new BufferedReader(new FileReader(readfile));
		create(reader, readfile.length());
		reader.close();
		
		//将大文件数据库写入writefile.java
		File writefile = new File("writefile.java"); 
		Writer writer = new BufferedWriter(new FileWriter(writefile));
		read(writer);
		writer.close();
	}

	public static void create(Reader reader, long length) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			String sql = "INSERT INTO db_jdbc.t_text (text) VALUES(?);";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			//替换ASCII字符流ps.setAsciiStream(parameterIndex, x, length);
			//替换UNICODE字符流ps.setCharacterStream(parameterIndex, reader, length);
			//也可使用setString，但要转换
			ps.setCharacterStream(1, reader, length);
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void read(Writer writer) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		String sql = "select * from t_text";
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Clob clob = (Clob) rs.getClob(2);
				Reader reader = clob.getCharacterStream();
				//也可使用reader = rs.getCharacterStream(1);
				//也可使用getString，但要转换
				char[] buff = new char[1024];
				for (int len = 0; (len = reader.read(buff)) > 0;)
					writer.write(buff, 0, len);
				reader.close();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
