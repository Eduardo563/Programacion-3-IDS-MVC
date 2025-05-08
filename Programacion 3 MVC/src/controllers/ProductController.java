package controllers;

import java.util.List;

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

}
