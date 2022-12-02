package lambdas_example;

public class Alumno{
	
	private String Nombre;
	private String Matricula;
	private int Edad;
	private boolean Activo;
	private double Peso;
	private double Altura;
	
	public Alumno(String Nombre, String Matricula, int Edad, boolean Activo, double peso,
			double altura) {
		this.Nombre = Nombre;
		this.Matricula = Matricula;
		this.Edad = Edad;
		this.Activo = Activo;
		this.Peso = peso;
		this.Altura = altura;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public boolean isActivo() {
		return Activo;
	}

	public void setActivo(boolean activo) {
		Activo = activo;
	}
	
	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}
	
	public double getAltura() {
		return Altura;
	}

	public void setAltura(double altura) {
		Peso = altura;
	}

	@Override
	public String toString() {
		return "Alumno [Nombre=" + Nombre + ", Matricula=" + Matricula + ", Edad=" + Edad + ", Activo=" + Activo + "]";
	}
	
	
	
	
	
}
