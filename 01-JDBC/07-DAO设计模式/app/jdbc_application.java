package app;

import java.util.Date;

import javax.jws.soap.SOAPBinding.Use;

import dao.User;
import dao.UserDAO;
import dao.UserDaoJdbcImpl;

public class jdbc_application {

	public static void main(String[] args) {
		//Ӧ�ó��򲿷֣�ֱ��ʹ�ýӿڲ���
		
		User user = new User();
		user.setBirthday(new Date());
		user.setName("dao_test");
		user.setMoney(5000f);
		
		UserDaoJdbcImpl dao = new UserDaoJdbcImpl();
		dao.addUser(user);
		

		User check = dao.findUser(user.getName(), null);
		System.out.println("���û�idΪ"+check.getId());
		dao.delete(check);
	}

}
