package Tiendita.V1;

public abstract class Producto {
	// Atributos
	private String nombre;
	private int cantidad;
	private double precio;
	
	// Constructor
	Producto(String nombre, int cantidad, double precio) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	// Getters y setters
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
	
	// Métodos abstractos
	public abstract void comprar(int qty);
	public abstract void vender(int qty);
	
	// Métodos
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
