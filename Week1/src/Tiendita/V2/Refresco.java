package Tiendita.V2;

public class Refresco implements Producto {

	// Atributos
	private String nombre;
	private int cantidad;
	private double precio;
	private String presentacion;
	
	// Constructor
	Refresco(String nombre, int cantidad, double precio, String presentacion) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.presentacion = presentacion;
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

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	// Métodos (Definidos por la interface)
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
	
	public String getMsgImporte(int qty) {
		return "Se Gastó $"+ getPrecio() * qty;
	}
	
	public String getMsgOperacion(boolean venta, int qty) {
		return (venta) ? "Se compraron "+ qty + " " + getPresentacion() + " de " + getNombre() :
						 "Se vendieron "+ qty + " " + getPresentacion() + " de " + getNombre();
	}
	
	public String getMsgStock() {
		return "Ahora tienes " + getCantidad() + getPresentacion() + " de " + getNombre();
	}
}