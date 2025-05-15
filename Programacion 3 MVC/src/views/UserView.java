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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.HomeController;
import models.User;

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
	

}
