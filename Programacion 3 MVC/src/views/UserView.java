package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.HomeController;
import controllers.UserController;
import models.User;
import models.UserModel;

public class UserView {

	public UserView() {
		// TODO Auto-generated constructor stub
	}
	
	public void vistaUsuarios(ArrayList<User> infoUsers) {
		JFrame vistU = new JFrame( );
		vistU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vistU.setBounds(100, 100, 1001, 700);
		JPanel panelPrin = new JPanel();
		panelPrin.setLayout(null);
		panelPrin.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrin.setBackground(new Color(147,201,255));

		vistU.add(panelPrin);
		
		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(142, 29, 743, 55);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panelPrin.add(lblNewLabel);
		
		JButton btnNewButton2 = new JButton("Añadir");
		btnNewButton2.setForeground(new Color(0, 64, 128));
		btnNewButton2.setBackground(Color.white);
		btnNewButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 192), 2));
		btnNewButton2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton2.setBounds(450, 600, 92, 40);
		panelPrin.add(btnNewButton2);
		btnNewButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserController uc = new UserController();
				uc.agregarUser();
				
			}
			
		});
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setForeground(new Color(0, 64, 128));
		btnNewButton.setBackground(Color.white);
		btnNewButton.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 192), 2));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 39, 92, 40);
		panelPrin.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeController regreso = new HomeController();
				vistU.dispose();
				regreso.home();
			}
			
		});
		
		String[] campos = {"ID","Nombre","Email","rol","phone"};
		Object[][] datos = new Object[infoUsers.size()][5]; 
		for (int i=0; i<infoUsers.size();i++) {
			User user = infoUsers.get(i);
			datos[i][0] = user.getId();
			datos[i][1] = user.getNombre();
			datos[i][2] = user.getEmail();
			datos[i][3] = user.getRole();
			datos[i][4] = user.getPhone();
		}
		
		DefaultTableModel modeloTabla = new DefaultTableModel(datos,campos);
		JTable tablaUsers = new JTable(modeloTabla);
		panelPrin.add(tablaUsers);
		
		JScrollPane scrollBar = new JScrollPane(tablaUsers);
		scrollBar.setBounds(200, 180, 600, 327);
		panelPrin.add(scrollBar);
		
		vistU.setVisible(true);
		
	}
	
	public void add() {
		JFrame addU = new JFrame( );
		addU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addU.setBounds(100, 100, 1001, 700);
		addU.setLayout(null);
		JPanel panelPrin = new JPanel();
		panelPrin.setBounds(186, 73, 438, 423);
		panelPrin.setLayout(null);
		panelPrin.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrin.setBackground(new Color(147,201,255));
		
		addU.add(panelPrin);
		
		JTextField textField;
		JTextField textField_1;
		JTextField textField_2;
		JTextField textField_3;
		
		JLabel lblNewLabel = new JLabel("Añadir Usuario");
		lblNewLabel.setForeground(Color.blue);
		lblNewLabel.setBackground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setBounds(400, 11, 780, 62);
		addU.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(48, 11, 90, 25);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panelPrin.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(44, 47, 337, 33);
		panelPrin.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(48, 91, 86, 25);
		panelPrin.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(48, 127, 333, 33);
		panelPrin.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefono");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(48, 171, 86, 25);
		panelPrin.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(48, 207, 333, 33);
		panelPrin.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(48, 298, 333, 33);
		panelPrin.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("rol:");
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(48, 262, 86, 25);
		panelPrin.add(lblNewLabel_1_1_1_1);
		
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnNewButton.setBounds(48, 361, 333, 51);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				String email = textField_1.getText();
				String role = textField_3.getText();
				String telefono = textField_2.getText();
				
				UserModel um = new UserModel();
				if (um.add(nombre, email, telefono, role)) {
					addU.dispose();
					UserController uc = new UserController();
					uc.llamarUsers();
				}
				
				
			}
			
		});
		panelPrin.add(btnNewButton);
		addU.setVisible(true);
		
	}
	

}
