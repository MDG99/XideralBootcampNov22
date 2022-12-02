package injection_dependecy;

public class BBVA_account extends Account {
	private String RFC;

	public BBVA_account(String userName, String userNumber, String rFC) {
		super(userName, userNumber);
		RFC = rFC;
	}
	
	@Override
	public void bienvenida() {
		System.out.println("---Bienvenido a BBVA---");
		System.out.println("Usuario: " + userName + " Cuenta: " + userNumber);
		System.out.println("RFC: " + RFC);
	}
}
