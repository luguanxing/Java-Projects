package app;

import java.util.Date;
import dao.User;
import dao.UserDAO;
import dao.UserDaoJdbcImpl;	//缺点：依赖具体实现类(应采用工厂模式)

public class jdbc_application {

	public static void main(String[] args) {
		//应用程序部分
		User user = new User();
		user.setBirthday(new Date());
		user.setName("dao_test");
		user.setMoney(5000f);
		
		//直接使用接口操作，如想不修改业务层应使用工厂模式
		UserDAO dao = new UserDaoJdbcImpl();
		dao.addUser(user);
		
		User check = dao.findUser(user.getName());
		System.out.println("新用户id为"+check.getId());
		
		check.setMoney(10000);
		dao.update(check);
	}

}
