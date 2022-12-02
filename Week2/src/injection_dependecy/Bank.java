package injection_dependecy;

public class Bank {
	private String Name;
	private Account myAccount;
	
	Bank(String Name, Account myAccount){
		this.Name = Name;
		this.myAccount = myAccount;
	}
	

	public void printAccountInformation() {
		System.out.println("Institución Financiera: " + Name);
		myAccount.bienvenida();
	}
	
}
