package dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static UserDAO userDao = null;
	private static DaoFactory instance = new DaoFactory();

	//����ģʽ
	private DaoFactory() {
		try {
			Properties pro = new Properties();
			InputStream inStream = DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");	//��ǰ��Ŀ¼�µ�����
			pro.load(inStream);
			String userDaoClassName = pro.getProperty("UserDaoJdbcImpl");	//����JDBCʵ�����Ե�ַ�ַ�,ֻ�������ü��ɸ���ʵ����
			Class userDaoClass = Class.forName(userDaoClassName);			//���ݵ�ַ�ַ�����JDBCʵ��������
			userDao = (UserDAO) userDaoClass.newInstance();					//����JDBCʵ��ʵ��
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public UserDAO getUserDao() {
		return userDao;
	}
}
