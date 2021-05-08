package eTicaret.business.concretes;

import java.util.regex.Pattern;

import eTicaret.business.abstracts.UserService;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	
	public UserManager (UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public void register(User user) {
		if (!validateEmail(user)) {
			System.out.println("E-posta alaný e-posta formatýnda olmalýdýr. ");
			return;
		} else if ((user.getFirstName().length() < 3) || (user.getLastName().length() < 3)) {
			System.out.println("Ad ve soyad en az iki karakterden oluþmalýdýr. ");
			return;

		} else if (!validatePassword(user)) {
			System.out.println("Parola en az 6 karakterden oluþmalýdýr. ");
			return;
		}else {
			System.out.println("Kayýt baþarýlý.");
		}		
	}

	@Override
	public void login(User user) {
		for (User users : this.userDao.getAll()) {
			if (!(users == user)) {
				System.out.println("Böyle bir kullanýcý yok öncellikle üye olmanýz gerekmektedir.");
			} else if (isUser(user)) {
				System.out.println("Sisteme baþarýlý bir þekilde giriþ yaptýnýz.");
			} else {
				System.out.println(
						"Hesabýnýz aktif edilmemiþ. Eposta adresinizden aktif hale getirebilirsiniz.");
			}
		}
		
	}

	public boolean isUser(User user) {
		for (User users : this.userDao.getAll()) {
			if (users==user) {
					return true;
			}			
		}
		return false;
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanýcý bilgileri güncellendi.");
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanýcý silindi.");
		
	}

	@Override
	public boolean validateEmail(User user) {
		String emailRegex = "[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+";
		return Pattern.matches(emailRegex, user.getEmail());

	}

	@Override
	public boolean validatePassword(User user) {
		String passwordRegex = ".{6,}";
		return Pattern.matches(passwordRegex, user.getPassword());
	}

}
