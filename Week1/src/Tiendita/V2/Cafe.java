package Tiendita.V2;

public class Cafe implements Producto {

	// Atributos
	private String nombre;
	private int cantidad;
	private double precio;
	private String size;
	private String presentacion;
	
	// Constructor
	Cafe(String nombre, int cantidad, double precio, String size, String presentacion) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.size = size;
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
		return (venta) ? "Se compraron nuevos insumos de " + getNombre() :
						 "Se vendieron "+ qty + " " + getPresentacion() + " " + getSize() + " de " + getNombre();
	}
	

}
