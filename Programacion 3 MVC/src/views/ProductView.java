package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProductController;
import models.ProductModel;
import models.Producto;

public class ProductView {
	

	public ProductView() {
		
	}
	
	public void productos(List<Producto> productosRecibidos) {
		System.out.println(productosRecibidos);
		JFrame frame = new JFrame();
		frame.setSize(1000,700);
		frame.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(74, 50, 671, 446);
		frame.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Tabla de Productos");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel,BorderLayout.NORTH);
		
		
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1,BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Añadir");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ProductController llamado_Aañadir = new ProductController();
				llamado_Aañadir.añadir();
				
			}
			
		});
		
		String [] columnas = {"ID","Nombre","Precio","Stock"};
		Object[][] datos = new Object[productosRecibidos.size()][4]; 
		for (int i = 0; i < productosRecibidos.size(); i++) {
		  Producto p = productosRecibidos.get(i);
		  datos[i][0] = p.getId();
		  datos[i][1] = p.getNombre();
		  datos[i][2] = p.getPrecio();
		  datos[i][3] = p.getStock();
		}
		JTable tabla = new JTable();
		tabla.setModel(new DefaultTableModel(datos, columnas));
		JScrollPane scroll = new JScrollPane(tabla);
		panel.add(scroll,BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	
	public void add() {
		JFrame añadir = new JFrame();
		añadir.setSize(800,500);
		añadir.setLayout(null);
		
		JTextField textField;
		JTextField textField_1;
		JTextField textField_2;
		JTextField textField_3;
		
		JLabel lblNewLabel = new JLabel("Añadir Producto");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 780, 62);
		añadir.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(186, 73, 438, 423);
		añadir.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(48, 11, 21, 25);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(44, 47, 337, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(48, 91, 86, 25);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(48, 127, 333, 33);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Precio");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(48, 171, 86, 25);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(48, 207, 333, 33);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(48, 298, 333, 33);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Stock:");
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(48, 262, 86, 25);
		panel.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnNewButton.setBounds(48, 361, 333, 51);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				String nombre = textField_1.getText();
				double precio = Double.parseDouble(textField_2.getText());
				int stock = Integer.parseInt(textField_3.getText());
				
				ProductModel pm = new ProductModel();
				pm.addProduct(id,nombre,precio,stock);
				
				añadir.dispose();
				
				ProductController pc = new ProductController();
				pc.obtenerProductos();
				
			}
			
		});
		añadir.setVisible(true);
	}

}
