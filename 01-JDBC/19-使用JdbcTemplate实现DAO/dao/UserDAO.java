package dao;

public interface UserDAO {
	//DAO为数据层访问对象，用于与数据库交互，可写出接口便于多种不同实现和应用层操作
	//不要写入或抛出任何与SQL有关的操作或异常污染接口，否则提高耦合性难以修改
	
	public boolean addUser(User user);	//向数据库中增加用户，成功返回true

	public User getUser(int userId);	//向数据库中查找用户，成功返回user，失败返回null

	public User findUser(String loginName);	//向数据库中查找用户，成功返回user，失败返回null

	public boolean update(User user);	//向数据库中更新用户，成功返回true

	public boolean delete(User user);	//向数据库中删除用户，成功返回true
}
