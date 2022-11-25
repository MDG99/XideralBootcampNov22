package Tiendita.V1;

public class Cafe extends Producto {
	// Atributos
	private String size;
	private String presentacion;

	// Constructor
	Cafe(String nombre, int cantidad, double precio, String presentacion, String size) {
		super(nombre, cantidad, precio);
		this.size = size;
		this.presentacion = presentacion;
	}
	
	// Getters & Setters de los atributos de esta clase
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
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
		setCantidad(qty); 
	}
	
	public void vender(int qty) {
		String msg1 = getMsgOperacion(false, qty);
		System.out.println(msg1);
		String msg2 = getMsgImporte(qty);
		System.out.println(msg2);
		setCantidad(qty); 
	}
	
	// Sobreescritura de los métodos heredados de la clase padre
	@Override
	public String getMsgImporte(int qty) {
		return "Se Gastó $"+ getPrecio() * qty;
	}
	
	@Override
	public String getMsgOperacion(boolean venta, int qty) {
		return (venta) ? "Se compraron nuevos insumos de " + getNombre() :
						 "Se vendieron "+ qty + " " + getPresentacion() + " " + getSize() + " de " + getNombre();
	}
	

}
