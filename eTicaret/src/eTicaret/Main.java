package eTicaret;

import eTicaret.business.abstracts.UserService;
import eTicaret.business.concretes.UserManager;
import eTicaret.dataAccess.concretes.HibernateUserDao;
import eTicaret.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService1 = new UserManager(new HibernateUserDao());
		User user1 = new User(1, "Zeynep", "Y�lmaz", "zeynep@gmail.com", "123456789");
		userService1.register(user1);
		
		
		
		UserService userService2 = new UserManager(new HibernateUserDao());
		User user2 = new User(1, "Ze", "Y�lmaz", "zeynep@gmail.com", "123456789");
		userService2.register(user2);
		
		
	}

}
