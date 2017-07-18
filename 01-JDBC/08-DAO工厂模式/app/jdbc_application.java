package app;

import java.util.Date;

import dao.DaoFactory;
import dao.User;
import dao.UserDAO;

public class jdbc_application {

	public static void main(String[] args) {
		//应用程序部分
		User user = new User();
		user.setBirthday(new Date());
		user.setName("dao_test");
		user.setMoney(5000f);
		
		//使用工厂模式，在不修改业务层和依赖具体实现类下写代码
		UserDAO dao = DaoFactory.getInstance().getUserDao();
		dao.addUser(user);
		
		User check = dao.findUser(user.getName());
		System.out.println("新用户id为"+check.getId());
		
		check.setMoney(20000);
		dao.update(check);
	}

}
