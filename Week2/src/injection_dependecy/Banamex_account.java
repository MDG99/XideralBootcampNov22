package injection_dependecy;

public class Banamex_account extends Account {
	private double SalaryPerMonth;

	public Banamex_account(String userName, String userNumber, double SalaryPerMonth) {
		super(userName, userNumber);
		this.SalaryPerMonth = SalaryPerMonth;
	}
	
	@Override
	public void bienvenida() {
		System.out.println("***Citibanamex***");
		System.out.println("Usuario: " + userName + " Cuenta: " + userNumber);
		
		if (SalaryPerMonth > 2000 ) {
			System.out.println("Felicidades, eres candidato a un crédito");
		}
	}
}