package trade.dataAccess.abstracsts;

import java.util.List;

import trade.entities.concretes.User;

public interface UserDao {
	
	void sign(User user);
	void logIn(User user);
	void logOut(User user);
	List<User> list();
	
}
