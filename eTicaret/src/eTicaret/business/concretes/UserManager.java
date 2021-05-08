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
			System.out.println("E-posta alan� e-posta format�nda olmal�d�r. ");
			return;
		} else if ((user.getFirstName().length() < 3) || (user.getLastName().length() < 3)) {
			System.out.println("Ad ve soyad en az iki karakterden olu�mal�d�r. ");
			return;

		} else if (!validatePassword(user)) {
			System.out.println("Parola en az 6 karakterden olu�mal�d�r. ");
			return;
		}else {
			System.out.println("Kay�t ba�ar�l�.");
		}		
	}

	@Override
	public void login(User user) {
		for (User users : this.userDao.getAll()) {
			if (!(users == user)) {
				System.out.println("B�yle bir kullan�c� yok �ncellikle �ye olman�z gerekmektedir.");
			} else if (isUser(user)) {
				System.out.println("Sisteme ba�ar�l� bir �ekilde giri� yapt�n�z.");
			} else {
				System.out.println(
						"Hesab�n�z aktif edilmemi�. Eposta adresinizden aktif hale getirebilirsiniz.");
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
		System.out.println("Kullan�c� bilgileri g�ncellendi.");
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� silindi.");
		
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
