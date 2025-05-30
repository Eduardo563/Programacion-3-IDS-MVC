package models;

import java.sql.Date;

public class User {

	int id;
	String nombre;
	String email;
	String role;
	String phone;
	Date create_at;
	Date update_at;
	
	public User(int id,String nombre, String email, String role, String phone, Date create_at, Date updated_at) {
		this.id=id;
		this.nombre=nombre;
		this.email=email;
		this.role=role;
		this.phone=phone;
		this.create_at=create_at;
		this.update_at=updated_at;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String getPhone() {
		return phone;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	
	

}
