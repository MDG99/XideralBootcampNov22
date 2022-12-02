package lambdas_example;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Direccion {
	
	public static void main(String[] args) {
		
		// Ejemplo creando la FunctionalInterface
		List<Alumno> lista_alumnos = new ArrayList<Alumno>();
		lista_alumnos.add(new Alumno("Ignacio Isaac", "140093", 23, false, 80.0, 1.74 ));
		lista_alumnos.add(new Alumno("Pablo Reyes", "223033", 19, true, 92.3, 1.80));
		lista_alumnos.add(new Alumno("Raul Medina", "133387", 27, false, 63.9, 1.74));
		lista_alumnos.add(new Alumno("Alex Salazar", "224685", 17, true, 55.0, 1.50));

		// Consulta básica de información
		Escuela f1 = x -> x.isActivo(); // Obtiene los alumnos activos
		Escuela f2 = y -> y.getEdad() > 20; // Obtiene los alumnos mayores a 20 años
		Escuela f3 = z -> z.getMatricula().startsWith("1"); // Alumnos cuya matrícula empieza con 1
		
		for (Alumno A : lista_alumnos) {
			if (f1.filtrar(A)) { // Cambiar el tipo de función para aplicar un filtro diferente
				System.out.println(A);
			}
		}
		
		// Ejemplo usando las interfaces proporcionadas por Java
		// Operaciones con el grupo
		double IMC_group = 0;		
		Function<Alumno, Double> f4 = z -> z.getPeso() / z.getAltura();
		
		
		for (Alumno A : lista_alumnos) {
			IMC_group += f4.apply(A);
		}
		
		IMC_group /= lista_alumnos.size();
		
		System.out.println("IMC del grupo: " + IMC_group);
		
	}

}
