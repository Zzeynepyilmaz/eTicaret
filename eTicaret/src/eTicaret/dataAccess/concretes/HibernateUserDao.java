package eTicaret.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	List <User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName()+ " isimli kullanici eklendi. ");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName()+" isimli kullanýcý güncellendi. ");
		
	}

	@Override
	public void delete(User user) {
		user = users.remove(user.getId());
		System.out.println(user.getFirstName() + " isimli kullanici silindi.");
	}

	@Override
	public User getById(int id) {
		List<User> users = getAll();
	        if (users != null) {
	            for (User user : users) {
	                if (user.getId() == id) return user;
	            }
	        }
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

}
