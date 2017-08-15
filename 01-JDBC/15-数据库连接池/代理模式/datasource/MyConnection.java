package datasource;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;



public class MyConnection implements Connection {

	private Connection realConnection;
	private MyDataSource myDataSource;
	
	public MyConnection(Connection realConnection, MyDataSource myDataSource) {
		 //�������Connection��������ݿ��йأ���MYSQL,ORACLE��
		this.realConnection = realConnection;
		this.myDataSource = myDataSource;
	}


	@Override
	public void close() throws SQLException {
		// �޸�close���ڵ��ø÷���ʱ�Ż����ӳأ�ע���Ƿ�MyConnection����Ϊ��������close()������ȡ�����Ǹ÷���
		this.myDataSource.connectionsPool.addLast(this);
	}
	
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		//һ��ʵ�ֵķ�������realConnectionʵ��
		return this.realConnection.unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public Statement createStatement() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void commit() throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void rollback() throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public String getCatalog() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO �Զ����ɵķ������
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public String getSchema() throws SQLException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO �Զ����ɵķ������
		return 0;
	}
	
}
