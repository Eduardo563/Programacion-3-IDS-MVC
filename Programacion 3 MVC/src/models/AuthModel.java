package models;

import java.io.BufferedReader;
import java.io.FileReader;

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

}
