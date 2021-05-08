package eTicaret.core.concretes;

import eTicaret.core.abstracts.GoogleService;
import eTicaret.entities.concretes.User;

public class JGoogleManagerAdapter implements GoogleService{

	public void addGoogleUser(User user) {
		System.out.println("Sisteme Google ile giriþ yapýldý .");
		
	}

}
