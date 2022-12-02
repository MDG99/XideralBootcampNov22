package injection_dependecy;

public class Banorte_account extends Account {

	public Banorte_account(String userName, String userNumber) {
		super(userName, userNumber);
	}
	
	@Override
	public void bienvenida() {
		System.out.println("Usuario: " + userName + " Cuenta: " + userNumber);
	}
}