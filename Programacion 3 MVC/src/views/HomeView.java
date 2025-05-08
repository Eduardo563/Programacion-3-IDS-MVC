package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.ProductController;

public class HomeView {
	
	private JFrame frame;
	private JPanel panelPrin;

	public HomeView() {
		
	}
	public void home() {
		
		frame = null;
		frame = new JFrame("Login");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 700);
	    frame.setLocationRelativeTo(null);
	    
	    frame.setBackground(new Color(224, 224, 224));
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setBounds(0, 0, 800, 85);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193, 213, 247));
		panel.setBounds(53, 105, 703, 376);
		frame.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(73, 96, 551, 126);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createLineBorder(new Color(118, 25, 178), 2));
		
		JLabel lblNewLabel_1 = new JLabel("Notificaciones");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_1.setBounds(0, 43, 130, 25);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("18");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_2.setBounds(40, 71, 49, 25);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Home.class.getResource("/images/alert_8021825.png")));
		lblNewLabel_5.setBounds(40, 0, 49, 36);
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createLineBorder(new Color(25, 134, 178), 2));
		
		JLabel lblNewLabel_3 = new JLabel("Clientes");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_3.setBounds(10, 43, 102, 25);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("27");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_4.setBounds(40, 71, 49, 25);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(Home.class.getResource("/images/user.png")));
		lblNewLabel_5_1.setBounds(52, 11, 49, 25);
		panel_3.add(lblNewLabel_5_1);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createLineBorder(new Color(25, 178, 120), 2));
		
		JLabel lblNewLabel_1_1 = new JLabel("Visitas");
		lblNewLabel_1_1.setBounds(10, 43, 112, 27);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("49");
		lblNewLabel_2_1.setBounds(50, 71, 21, 25);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
		panel_4.add(lblNewLabel_2_1);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBorder(BorderFactory.createLineBorder(new Color(178, 62, 25), 2));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hora Actual");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_1_1_1.setBounds(10, 41, 112, 27);
		panel_5.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("8:30 am");
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_2_1_1.setBounds(31, 71, 68, 25);
		panel_5.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon(Home.class.getResource("/images/statistics_12349816.png")));
		lblNewLabel_5_2.setBounds(47, 11, 49, 27);
		panel_4.add(lblNewLabel_5_2);
		
		
		JLabel lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setIcon(new ImageIcon(Home.class.getResource("/images/clock_12476674.png")));
		lblNewLabel_5_3.setBounds(50, 0, 49, 38);
		panel_5.add(lblNewLabel_5_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(193, 213, 247));
		panel_6.setBounds(116, 255, 477, 83);
		panel.add(panel_6);
		
		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel_6.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Accedido a Usuarios","Ingreso",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		JButton btnRegistros = new JButton("Registros");
		btnRegistros.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel_6.add(btnRegistros);
		btnRegistros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Accedido a Registros","Ingreso",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel_6.add(btnConfiguracion);
		btnConfiguracion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Accedido a Configuracion","Ingreso",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		JButton btnProductos = new JButton("Productos");
		btnProductos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel_6.add(btnProductos);
		btnProductos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ProductController productos = new ProductController();
				productos.obtenerProductos();
			}
			
		});
		frame.setVisible(true);

	}
		
	

}
