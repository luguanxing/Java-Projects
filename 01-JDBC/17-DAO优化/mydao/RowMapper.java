package mydao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
	//�������ʵ�ֵ�RowMapper(����������)����ӳ��
	public Object mapRow(ResultSet rs) throws SQLException;
}
