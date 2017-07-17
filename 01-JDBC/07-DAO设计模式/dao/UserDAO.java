package dao;

public interface UserDAO {
	//DAO为数据层访问对象，用于与数据库交互，可写出接口便于多种不同实现
	//不要写入或抛出任何与SQL有关的操作或异常污染接口，否则提高耦合性难以修改
	public void addUser(User user);

	public User getUser(int userId);

	public User findUser(String loginName, String password);

	public void update(User user);

	public void delete(User user);
}
