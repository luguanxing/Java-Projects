package app;

import java.util.Date;

import javax.jws.soap.SOAPBinding.Use;

import dao.User;
import dao.UserDAO;
import dao.UserDaoJdbcImpl;

public class jdbc_application {

	public static void main(String[] args) {
		//Ӧ�ó��򲿷�
		User user = new User();
		user.setBirthday(new Date());
		user.setName("dao_test");
		user.setMoney(5000f);
		
		//ֱ��ʹ�ýӿڲ��������벻�޸�ҵ���Ӧʹ�ù���ģʽ
		UserDAO dao = new UserDaoJdbcImpl();
		dao.addUser(user);
		
		User check = dao.findUser(user.getName());
		System.out.println("���û�idΪ"+check.getId());
		dao.delete(check);
	}

}
