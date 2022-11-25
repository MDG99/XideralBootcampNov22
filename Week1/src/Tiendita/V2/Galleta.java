package Tiendita.V2;

public class Galleta implements Producto {
	
	// Atributos
	private String nombre;
	private int cantidad;
	private double precio;

	// Constructor
	Galleta(String nombre, int cantidad, double precio) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	// Métodos (Definidos por la interface)
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
	
	public String getMsgImporte(int qty) {
		return "Se Gastó $"+ getPrecio() * qty;
	}
	
	public String getMsgOperacion(boolean venta, int qty) {
		return (venta) ? "Se compraron "+ qty + " unidades de " + getNombre() :
						 "Se vendieron "+ qty + " unidades de " + getNombre();
	}
	
	public String getMsgStock() {
		return "Ahora tienes " + getCantidad() + " unidades de " + getNombre();
	}

	

}
