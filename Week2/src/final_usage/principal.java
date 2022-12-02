package final_usage;

public class principal extends method_with_final {
	
	public static void main(String[] args) {
		
		final int numero = 20;
		final String s1 = "Hola";
		numero = 3; // Provoca error de compilación.
		s1 = "Hola de nuevo"; // Provoca error de compilación.
		System.out.println(numero);
	}
	
	// Provoca error de compilación ya que el método es final
	@Override
	public void dummy_method() {
		System.out.println("Ahora tengo una lógica diferente");
	}

}


// Provoca un error de compilación ya que la clase es final
class principal_with_class extends class_with_final{
	
	public int dummy_integer_2;
	
}
