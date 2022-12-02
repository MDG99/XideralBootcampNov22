package injection_dependecy;

public class Principal {

	public static void main(String[] args) {
		Bank bank1 = Inyector.getBankInjected("BBVA Bancomer S.A. de C.V.", 1);
		Bank bank2 = Inyector.getBankInjected("Citibanamex S.A. de C.V.", 2);
		Bank bank3 = Inyector.getBankInjected("Banco Mercantil del Norte S.A. de C.V.", 5);
		
		System.out.println("PRUEBA 1");
		bank1.printAccountInformation();
		System.out.println("PRUEBA 2");
		bank2.printAccountInformation();
		System.out.println("PRUEBA 3");
		bank3.printAccountInformation();
		
	}

}
