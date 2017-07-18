package dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static UserDAO userDao = null;
	private static DaoFactory instance = new DaoFactory();

	//单例模式
	private DaoFactory() {
		try {
			Properties pro = new Properties();
			InputStream inStream = DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");	//当前艮目录下的配置
			pro.load(inStream);
			String userDaoClassName = pro.getProperty("UserDaoJdbcImpl");	//读入JDBC实现属性地址字符,只读入配置即可更改实现类
			Class userDaoClass = Class.forName(userDaoClassName);			//根据地址字符加载JDBC实现属性类
			userDao = (UserDAO) userDaoClass.newInstance();					//生成JDBC实现实例
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
