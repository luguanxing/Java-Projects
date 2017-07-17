package dao;

public interface UserDAO {
	//DAOΪ���ݲ���ʶ������������ݿ⽻������д���ӿڱ��ڶ��ֲ�ͬʵ��
	//��Ҫд����׳��κ���SQL�йصĲ������쳣��Ⱦ�ӿڣ������������������޸�
	public void addUser(User user);

	public User getUser(int userId);

	public User findUser(String loginName, String password);

	public void update(User user);

	public void delete(User user);
}
