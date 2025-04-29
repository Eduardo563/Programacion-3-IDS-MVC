package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthModel {

	public AuthModel() {
		
	}
	
	
	public boolean autenticar(String usuario, String contra) {
		
		
		try {
			BufferedReader lector = new BufferedReader(new FileReader("src/archivos/users.txt"));
			String bfreader="";
			
			while((bfreader = lector.readLine()) != null) {
				String [] lineas = bfreader.trim().split(",");
				
				if (lineas[1].equals(usuario) && lineas[2].equals(contra)) {
					return true;
				}
				
			}
		return false;
		}
		
		catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	public void registro(String usuario,String bio, String preferencias, String  terminos, String colonia ) {
		System.out.println("Usuario: "+usuario);
		System.out.println("Biografia: "+bio);
		System.out.println("Preferencias: "+preferencias);
		System.out.println("Colonia en la que reside: "+colonia);
		System.out.println("Aceptacion de Términos: "+terminos);
	}
	
	
	public void escritura(String a,String b,String c,String d,String e,String f,String g,String h) throws IOException {
		FileWriter archivo=null;
		PrintWriter escritor=null;
		
		try {
			archivo = new FileWriter("src/archivos/registros.txt",true);
			escritor = new PrintWriter(archivo);
			String lineaRegister= String.join("|", a,b,c,d,e,f,g,h);
			escritor.println(lineaRegister);
			
		}
		catch(Exception x) {
			System.out.println(x.getMessage());
		}
		finally {
			archivo.close();
		}
	}

}
