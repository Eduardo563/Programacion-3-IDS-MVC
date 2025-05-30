package controllers;

import java.util.ArrayList;

import models.User;
import models.UserModel;
import views.UserView;

public class UserController {
	
	UserModel modelo;
	UserView vista;

	public UserController() {
		modelo = new UserModel();
		vista = new UserView();
	}
	
	public void llamarUsers() {
		ArrayList<User> usuarios = modelo.ObtenerUsers();
		vista.vistaUsuarios(usuarios);
	}
	public void agregarUser() {
		vista.add();
	}
	
	public void update(User user)
	{
		vista.formUpdate(user);
	}
	
	public void delete(int user_id)
	{
		modelo.delete(user_id);
		llamarUsers();
	}


}
