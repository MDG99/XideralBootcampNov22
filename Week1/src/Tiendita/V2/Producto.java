package Tiendita.V2;

public interface Producto {
	public void comprar(int qty);
	public void vender(int qty);
	public String getMsgImporte(int qty);
	public String getMsgOperacion(boolean venta, int qty);
}
