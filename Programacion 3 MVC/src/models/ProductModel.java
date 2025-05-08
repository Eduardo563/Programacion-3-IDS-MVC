package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
				int id = Integer.parseInt(objeto.get("id").toString());
				String nombre = (String)objeto.get("title");
				double precio = Double.parseDouble(objeto.get("price").toString());
				int stock = Integer.parseInt(objeto.get("stock").toString());
				datosProductos.add(new Producto(id,nombre,precio,stock));
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datosProductos;
	}
	
	public void remove()
	{
		
		JSONArray productList = leerJson();
		
		String url = AuthModel.class.getResource("/archivos/products.json").getPath();
        
		 productList.remove(0); 
         
         System.out.println(productList); 
         
         // Write the JSON array to a file
         try (FileWriter file = new FileWriter(url)) {
             file.write(productList.toString()); // Use toString(2) for pretty printing
             file.flush();
             file.close();
             System.out.println("JSON array written to file successfully!");
         } catch (IOException e) {
             e.printStackTrace();
         }
	}

	public boolean addProduct(int id,String n, double p,int s)
	{
		
		JSONArray productList = leerJson();
		JSONObject jsonObject = new JSONObject();
		
		//String url = AuthModel.class.getResource("src/archivos/products.json").getPath();
		
		
		//jsonObject.put("name", n);
		jsonObject.put("id", id);
		jsonObject.put("title", n);
		jsonObject.put("price", p);
		jsonObject.put("stock",s);
		
		productList.add(jsonObject);
		
		try (FileWriter file = new FileWriter("src/archivos/products.json")) {
            file.write(productList.toString()); // Use toString(2) for pretty printing
            file.flush();
            file.close();
            System.out.println("JSON array written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return false;
	}

}
