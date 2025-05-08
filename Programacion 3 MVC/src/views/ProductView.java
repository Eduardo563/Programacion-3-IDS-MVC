package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

}
