package dao;

public interface UserDAO {
	//DAOΪ���ݲ���ʶ������������ݿ⽻������д���ӿڱ��ڶ��ֲ�ͬʵ�ֺ�Ӧ�ò����
	//��Ҫд����׳��κ���SQL�йصĲ������쳣��Ⱦ�ӿڣ������������������޸�
	
	public boolean addUser(User user);	//�����ݿ��������û����ɹ�����true

	public User getUser(int userId);	//�����ݿ��в����û����ɹ�����user��ʧ�ܷ���null

	public User findUser(String loginName);	//�����ݿ��в����û����ɹ�����user��ʧ�ܷ���null

	public boolean update(User user);	//�����ݿ��и����û����ɹ�����true

	public boolean delete(User user);	//�����ݿ���ɾ���û����ɹ�����true
}
