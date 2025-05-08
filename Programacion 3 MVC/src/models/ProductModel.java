package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductModel {

	public ProductModel() {
		
	}
	//Devuelve un JSONArray de lo leido en el archivo
	public JSONArray leerJson () {
		JSONParser jsonParser = new JSONParser();
		
		//String url = ProductModel.class.getResource("/archivos/products.json").getPath();
		
		try(FileReader lector = new FileReader("src/archivos/products.json")){
			
			Object obj = jsonParser.parse(lector);
			JSONArray listaProductos = (JSONArray) obj;
			return listaProductos;
		}
		catch (FileNotFoundException e){
	          e.printStackTrace();
	      }
		catch (IOException e){
	          e.printStackTrace();
	      }
		catch (ParseException e){
	          e.printStackTrace();
	      }

	      return null;
	 }
	
	//Este metodo devulve la lista de datos como objetos de la clase Producto
	public List<Producto> obtenerDatos(JSONArray listaObjetos){
		List<Producto> datosProductos = new ArrayList<>();
		try {
			for (Object producto:listaObjetos) {
				JSONObject objeto = (JSONObject) producto;
				int id = (int) ((Long)objeto.get("id")).intValue();
				String nombre = (String)objeto.get("title");
				double precio = (double)objeto.get("price");
				int stock = (int) ((Long)objeto.get("stock")).intValue();
				datosProductos.add(new Producto(id,nombre,precio,stock));
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosProductos;
	}

	

}
