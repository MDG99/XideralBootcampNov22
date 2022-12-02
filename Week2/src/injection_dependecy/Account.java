package injection_dependecy;

public abstract class Account {
	String userName;
	String userNumber;
	
	Account (String userName, String userNumber){
		this.userName = userName;
		this.userNumber = userNumber;
	}
	
	public abstract void bienvenida();
	
}
