package trade.business.concreters;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import trade.business.abstracts.UserService;
import trade.connect.AccountService;
import trade.dataAccess.abstracsts.UserDao;
import trade.entities.concretes.User;

public class UserManager implements UserService {
	List<String> mails = new ArrayList<String>();
	List<User> users = new ArrayList<User>();
	
	private UserDao userdao;
	private AccountService accountservice;
	
	public UserManager(UserDao userdao, AccountService accountservice) {
		super();
		this.userdao = userdao;
		this.accountservice= accountservice;
	}

	@Override
	public void sign(User user) {
		
		if (nameCheck(user) == false){
			System.out.println("Adiniz hatali. (Ad en az iki harften olusmalidir..)");
		}
		else if (lastnameCheck(user) == false){
			System.out.println("Soyadiniz hatali..(Soyad en az iki harften olusmalidir)");
		}
		else if (emailCheck(user)== false){
			System.out.println("E mailiniz hatali ");
		}
		else if (passwordCheck(user) == false){
			System.out.println("Parola hatali (Parola en az 6 karakterden olusmali)");
		}
	    else {
	      this.userdao.sign(user);;
	      System.out.println("Dogrulama gönderildi");
	      users.add(user);
	    }
   	}


	@Override
	public void logIn(User user) {
		this.userdao.logIn(user);
		
	}

	@Override
	public void logOut(User user) {
		this.userdao.logOut(user);
		
	}

	@Override
	public boolean emailCheck(User user) {
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(user.getEmail());
		if (matcher.matches() == true && mails.contains(user.getEmail()) == false) {
			mails.add(user.getEmail());
			return true;
		} else {
			return false;
		}
	}


	@Override
	public boolean nameCheck(User user) {
		if (user.getName().length() >2 && user.getName().length()<20 ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean lastnameCheck(User user) {

		if (user.getSurname().length() > 2 ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean passwordCheck(User user) {
		Pattern pattern = Pattern.compile(new String("^.{6,}$"));
		Matcher matcher = pattern.matcher(user.getPassword());
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean googleMailCheck(User user) {
		String regex = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getEmail());
		if(matcher.matches()==true )
		{
			mails.add(user.getEmail());
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void entrywithGoogle(User user) {

		if(googleMailCheck(user) == true && nameCheck(user)==true && passwordCheck(user)==true)
		{
			this.accountservice.entryGoogle(user);
			users.add(user);
		}
		else {
			System.out.println("Google hesabinizi tekrar giriniz.");
		}
}

}