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

}
