package multicatch_usage;

public class Principal {

	public static void main(String[] args) {
		
		int result;
		int a = 1;
		int b = 0;
		
		int [] myArray = {0, 1, 2, 3, 4, 5};
		
		String text = null;
		
		try {
			// Genera la excepción ArithmeticException
			result = a/b;
			
			// Genera la excepción ArrayIndexOutOfBoundsException
			result = myArray[6];
			
			// Genera la excepción NullPointerException
			result = text.length();
			
			System.out.println("Se termino el bloque Try");
			
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException  | NullPointerException e) {
			System.out.println("Se lanzo por la excepcion: " + e);
		} finally {
			System.out.println("Se termino la excepcion");
		}
			

	}

}
