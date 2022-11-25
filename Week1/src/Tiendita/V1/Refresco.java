package Tiendita.V1;


public class Refresco extends Producto {
	
	// Atributos
	private String presentacion;
	
	// Constructor
	Refresco(String nombre, int cantidad, double precio, String presentacion) {
		super(nombre, cantidad, precio);
		this.presentacion = presentacion;
	}
	

	// Getters & Setters de los atributos de esta clase
	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	// Métodos heredados de la clase padre (Métodos Abstractos)
	public void comprar(int qty) {
		String msg1 = getMsgOperacion(false, qty);
		System.out.println(msg1);
		String msg2 = getMsgImporte(qty);
		System.out.println(msg2);
		System.out.println(getMsgStock());
		setCantidad(qty); 
	}
	
	public void vender(int qty) {
		String msg1 = getMsgOperacion(false, qty);
		System.out.println(msg1);
		String msg2 = getMsgImporte(qty);
		System.out.println(msg2);
		System.out.println(getMsgStock());
		setCantidad(qty); 
	}
	
	
	// Sobreescritura de los métodos heredados de la clase padre
	@Override
	public String getMsgImporte(int qty) {
		return "Se Gastó $"+ getPrecio() * qty;
	}
	
	@Override
	public String getMsgOperacion(boolean venta, int qty) {
		return (venta) ? "Se compraron "+ qty + " " + getPresentacion() + " de " + getNombre() :
						 "Se vendieron "+ qty + " " + getPresentacion() + " de " + getNombre();
	}
	
	@Override
	public String getMsgStock() {
		return "Ahora tienes " + getCantidad() + getPresentacion() + " de " + getNombre();
	}
}