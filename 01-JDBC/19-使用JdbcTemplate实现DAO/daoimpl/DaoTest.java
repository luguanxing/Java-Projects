package daoimpl;

import java.util.Date;

import dao.DaoFactory;
import dao.User;
import dao.UserDAO;

public class DaoTest {

	public static void main(String[] args) {
		//Ӧ�ó��򲿷�
		User user = new User();
		user.setBirthday(new Date());
		user.setName("dao_test");
		user.setMoney(5000f);
		
		//ʹ�ù���ģʽ���ڲ��޸�ҵ������������ʵ������д����
		UserDAO dao = DaoFactory.getInstance().getUserDao();
		dao.addUser(user);
		
		User check = dao.findUser(user.getName());
		System.out.println("���û�idΪ"+check.getId());
		System.out.println(check);
		
		check.setMoney(20000);
		dao.update(check);
	}

}
