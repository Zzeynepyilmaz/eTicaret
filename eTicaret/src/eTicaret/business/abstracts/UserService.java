package eTicaret.business.abstracts;

import eTicaret.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user);
	void update(User user);
	void delete(User user);
	boolean validateEmail(User user);
	boolean validatePassword(User user);
	boolean isUser(User user);

}
