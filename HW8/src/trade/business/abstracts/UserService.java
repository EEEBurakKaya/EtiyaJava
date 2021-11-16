package trade.business.abstracts;

import java.util.List;

import trade.entities.concretes.User;

public interface UserService {
	
	void sign(User user);
	void logIn(User user);
	void logOut(User user);
	boolean emailCheck (User user);
	boolean nameCheck (User user);
	boolean lastnameCheck (User user);
	boolean passwordCheck (User user);
	boolean googleMailCheck (User user);
	void entrywithGoogle (User user);

}
