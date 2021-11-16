package trade;

import trade.business.abstracts.UserService;
import trade.business.concreters.UserManager;
import trade.connect.AccountOperation;
import trade.dataAccess.concretes.OpUserDao;
import trade.entities.concretes.User;

public class main {

	public static void main(String[] args) {
		
		UserService userservice = new UserManager(new OpUserDao(), new AccountOperation());
		
		User user = new User();
		user.setName("Burak");
		user.setSurname("Kaya");
		user.setId(1);
		user.setEmail("eeebura5@gmail.com");
		user.setPassword("123456789");
		userservice.sign(user);
		userservice.logIn(user);
		userservice.logOut(user);
		//userservice.entrywithGoogle(user);
		System.out.println("//////////////");
		
		User user1 = new User();
		user1.setName("Ali");
		user1.setSurname("soyadi");
		user1.setId(2);
		user1.setEmail("dsdadali2@gmail.com");
		user1.setPassword("123456");
		userservice.sign(user1);
		//userservice.logIn(user1);
		//userservice.logOut(user1);
		userservice.entrywithGoogle(user1);
		System.out.println("//////////////");
		
		User user2 = new User();
		user2.setName("Al");
		user2.setSurname("soyadi");
		user2.setId(3);
		user2.setEmail("dsdadali2@gmail.com");
		user2.setPassword("123456");
		userservice.sign(user2);
		//userservice.logIn(user2);
		//userservice.logOut(user2);
		userservice.entrywithGoogle(user2);
		System.out.println("//////////////");


		
	}

}
