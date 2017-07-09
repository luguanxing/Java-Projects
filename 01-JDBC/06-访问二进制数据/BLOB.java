import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Clob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BLOB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//		//将根目录下图片tiananmen.jpg读入数据库
//		File readfile = new File("tiananmen.jpg");
//		InputStream in = new BufferedInputStream(new FileInputStream(readfile));
//		create(in, readfile.length());
//		in.close();
		
		//将大文件数据库写入tiananmen2.jpg
		File writefile = new File("tiananmen_out.jpg"); 
		OutputStream out = new BufferedOutputStream(new FileOutputStream(writefile));
		read(out);
		out.close();
	}

	public static void create(InputStream in, long length) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			String sql = "INSERT INTO db_jdbc.t_bit (bit) VALUES (?)";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			//读取二进制字节流
			ps.setBinaryStream(1, in, length);
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void read(OutputStream out) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		String sql = "select * from t_bit";
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Blob blob = (Blob) rs.getBlob(2);
				InputStream in = blob.getBinaryStream();
				//也可使用reader = rs.getBinaryStream(1);
				byte[] buff = new byte[1024];
				for (int len = 0; (len = in.read(buff)) > 0;)
					out.write(buff, 0, len);
				in.close();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
