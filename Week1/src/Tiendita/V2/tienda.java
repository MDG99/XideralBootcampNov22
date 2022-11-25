package Tiendita.V2;
import java.util.*;

public class tienda {
	
	private static Random randomNumber = new Random();

	
	public static void main(String[] main) {
		
		// Creamos una lista vacía
		ArrayList<Producto> lista_productos = new ArrayList<Producto>();
		
		// Intanciamos los productos de la tiendita
		Producto cocaColaBotella = new Refresco("Coca-Cola", 100, 14.50, "Botella");
		Producto cocaColaLata = new Refresco("Coca-Cola", 50, 10.0, "Lata");
		Producto galletaCoco = new Galleta("Coco con Avena", 30, 37.0);
		Producto cafeLate_1 = new Cafe("Cafe Late", 50, 10.0, "Taza", "Grande");
		Producto cafeLate_2 = new Cafe("Cafe Late", 50, 10.0, "Vaso", "Mediano");
		
		// Añadimos los productos en la lista
		lista_productos.add(cocaColaBotella);
		lista_productos.add(cocaColaLata);
		lista_productos.add(galletaCoco);
		lista_productos.add(cafeLate_1);
		lista_productos.add(cafeLate_2);

		// Definimos unas variables de apoyo
		int cantidadAleatoria;
		String className;
		
		// Iteramos en cada miembro de la lista de productos
		for (Producto p: lista_productos) {
			
			// Obtenemos el tipo de producto (Clase a la que pertenece)
			className = p.getClass().getSimpleName();
			System.out.println("\nProducto de tipo " + className);
			
			// Generamos un número aleatorio y compramos
			cantidadAleatoria = getNumeroAleatorio();
			p.comprar(cantidadAleatoria);
			
			// Generamos un número aleatorio y vendemos
			cantidadAleatoria = getNumeroAleatorio();
			p.vender(cantidadAleatoria);
			
			System.out.println();
		}
		
	}
	
	public static int getNumeroAleatorio() {
		int number = randomNumber.nextInt(12);
		System.out.println("Numero aleatorio generado: " + number);
		return number;
	}
	
}
