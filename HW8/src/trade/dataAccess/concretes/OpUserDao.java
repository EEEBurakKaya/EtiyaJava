package trade.dataAccess.concretes;

import java.util.List;

import trade.dataAccess.abstracsts.UserDao;
import trade.entities.concretes.User;

public class OpUserDao implements UserDao {

	@Override
	public void sign(User user) {
		System.out.println("Kaydiniz tamamlandi.Hosgeldiniz: "+ user.getName());
		
	}

	@Override
	public void logIn(User user) {
	    
		System.out.println("Hosgeldin " +user.getName());
	}

	@Override
	public void logOut(User user) {
		
		System.out.println("Görüsürüz " +user.getName());
		
	}

	@Override
	public List<User> list() {
		
		return null;
	}
	

}
