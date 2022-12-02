package injection_dependecy;

public class Inyector {
	
	static Account bbva = new BBVA_account("Ignacio Isaac", "134567", "ABC12DF");
	static Account banamex = new Banamex_account("Pablo Ramirez", "00017", 5500);
	static Account banorte = new Banorte_account("Manuel Rios", "789645312");
	
	
	static Bank getBankInjected(String name, int type){
		
		Bank myBank;
		
		switch(type) {
		
		case 1: 
			myBank = new Bank(name,bbva);
			break;
		case 2: 
			myBank = new Bank(name,banamex);
			break;
		default:
			myBank = new Bank(name,banorte);
		}
		
		return myBank;
		
	}

}
