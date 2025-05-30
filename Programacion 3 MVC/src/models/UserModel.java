package models;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserModel {
	
	ArrayList<User> usuarios = new ArrayList<User>();

	public UserModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<User> ObtenerUsers()
	{
		
		String query = "select * from users";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				
				Integer empId = rs.getInt(1);
				String firstName = rs.getString(2);
				String email = rs.getString(3); 
				String role = rs.getString(4); 
				String phone = rs.getString(5);
				
				usuarios.add(new User(empId,firstName,email,role,phone,null,null));
				
				/*System.out.println("empId:" + empId);
				System.out.println("firstName:" + firstName);
				System.out.println("email:" + email); 
				System.out.println("");*/
				
				
			}
			rs.close();
			
			return usuarios; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		
		
		return usuarios; 
		
	}
	public boolean add(String name,String email, String telefono , String role)
	{
		String query = "INSERT INTO `users` (`id`, `name`, `email`, `role`, `phone`, `create_at`, `update_at`) VALUES (NULL, '"+name+"', '"+email+"', '"+role+"', '"+telefono+"', NULL, NULL);";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
	
	
	public boolean update(User user)
	{
		String query = " UPDATE `users` SET `name` = '"+user.nombre+"', `email` = '"+user.email+"', `role` = '"+user.role+"', `phone` = '"+user.phone+"' WHERE `users`.`id` = "+user.id+"";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
	
	public boolean delete(int user_id)
	{
		String query =  "DELETE FROM users WHERE `users`.`id` = "+user_id;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}

}
