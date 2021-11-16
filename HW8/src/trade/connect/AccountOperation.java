package trade.connect;

import GeneralAccount.GoogleAccount;
import trade.entities.concretes.User;

public class AccountOperation implements AccountService {

	@Override
	public void entryGoogle(User user) {
         GoogleAccount googleaccount = new GoogleAccount();
         googleaccount.sign(user);
         
         
	}
}
