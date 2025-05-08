package models;

public class Producto {

	int id;
	String nombre;
	double precio;
	int stock;
	
	public Producto(int id, String nombre, double precio, int stock) {
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.stock=stock;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}
	
	
	

}
