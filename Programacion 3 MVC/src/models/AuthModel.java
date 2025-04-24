package models;

public class AuthModel {

	public AuthModel() {
		
	}
	
	
	public boolean autenticar(String usuario, String contra) {
		if (usuario.equals("admin")) {
			if (contra.equals("1234")) {
				return true;
			}
			else {
				return false;
			}
		}
		else
			return false;
	}
	
	public void registro(String usuario,String bio, String preferencias, String  terminos, String colonia ) {
		System.out.println("Usuario: "+usuario);
		System.out.println("Biografia: "+bio);
		System.out.println("Preferencias: "+preferencias);
		System.out.println("Colonia en la que reside: "+colonia);
		System.out.println("Aceptacion de Términos: "+terminos);
	}

}
