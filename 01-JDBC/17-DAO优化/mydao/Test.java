package mydao;

import dao.User;

public class Test {

	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl();
		User user = udi.findUser("уехЩ");
		String name = udi.findUserName(1);
		System.out.println(user);
		System.out.println(name);
	}

}
