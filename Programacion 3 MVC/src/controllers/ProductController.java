package controllers;

import java.util.List;

import javax.swing.JTable;

import models.ProductModel;
import models.Producto;
import views.ProductView;

public class ProductController {

	public ProductModel modelo;
	public ProductView vista;
	
	public ProductController() {
		modelo = new ProductModel();
		vista = new ProductView();
	}
	
	public void obtenerProductos() {
		List<Producto>obtenidos =modelo.obtenerDatos(modelo.leerJson());
		vista.productos(obtenidos);
	}
	
	public void añadir() {
		vista.add();
	}
	
	public void eliminar(int id) {
		modelo.remove(id);
	}
	
	public void recargarTabla(JTable tabla) {
		List<Producto>obtenidos =modelo.obtenerDatos(modelo.leerJson());
		vista.actualizarTabla(obtenidos, tabla);
	}

}
