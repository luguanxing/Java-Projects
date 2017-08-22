package mydao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
	//传入具体实现的RowMapper(可用匿名类)进行映射
	public Object mapRow(ResultSet rs) throws SQLException;
}
