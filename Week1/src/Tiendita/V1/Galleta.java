package Tiendita.V1;

public class Galleta extends Producto {
	
	// Constructor
	Galleta(String nombre, int cantidad, double precio) {
		super(nombre, cantidad, precio);
	}
	
	// Métodos heredados de la clase padre (Métodos Abstractos)
	public void comprar(int qty) {
		String msg1 = getMsgOperacion(false, qty);
		System.out.println(msg1);
		String msg2 = getMsgImporte(qty);
		System.out.println(msg2);
		setCantidad(qty); 
	}
	
	public void vender(int qty) {
		String msg1 = getMsgOperacion(false, qty);
		System.out.println(msg1);
		String msg2 = getMsgImporte(qty);
		System.out.println(msg2);
		setCantidad(qty); 
	}

}
