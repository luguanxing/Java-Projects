package dao.refactor;

import dao.User;

public class Test {

	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl();
		User u1 = udi.findUser("уехЩ");
		System.out.println(u1);
	}

}
