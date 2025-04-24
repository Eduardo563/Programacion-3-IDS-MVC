package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import models.AuthModel;

public class AuthView {

	Font Titulo = new Font("	SansSerif",Font.BOLD,30);
	Font Campos = new Font("Arial",Font.PLAIN,18);
	Font media = new Font("SansSerif",Font.ITALIC,15);
	
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private AuthModel functions;
	
	
	public AuthView() {
		functions = new AuthModel();
	}
	
	
	public void login() {
		frame = new JFrame("Login");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 700);
	    frame.setLocationRelativeTo(null);
	    
	    JPanel principal = new JPanel();
		principal.setLayout(null);
		principal.setLocation(0, 0);
		principal.setSize(1000, 700);
		principal.setVisible(true);
		principal.setBackground(new Color(31, 104, 59));
		frame.setContentPane(principal);
		
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setLocation(100, 80);
		login.setSize(800, 500);
		//login.setOpaque(true);
		login.setBackground(Color.WHITE);
		login.setVisible(true);
		principal.add(login);
		
		JPanel credencial = new JPanel();
		credencial.setLayout(null);
		credencial.setLocation(5, 5);
		credencial.setSize(350, 480);
		credencial.setOpaque(true);
		credencial.setBackground(Color.white);
		credencial.setVisible(true);
		login.add(credencial);
		
		//Label para el texto iniciar sesion
		JLabel etiqueta1 = new JLabel("User Login");
		etiqueta1.setBounds(85, 70, 230, 35);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(Titulo);
		credencial.add(etiqueta1);
		
		//Label para el texto usuario o email
		JLabel etiqueta2 = new JLabel("Username or email");
		etiqueta2.setSize(200, 20);
		etiqueta2.setLocation(70,140);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		etiqueta2.setVerticalAlignment(JLabel.CENTER);
		etiqueta2.setFont(Campos);
		credencial.add(etiqueta2);
		
		ImageIcon sobre = new ImageIcon(AuthView.class.getResource("/images/sobreR.png"));
		Image redimensionS = sobre.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		ImageIcon sobreR = new ImageIcon(redimensionS);
		JLabel iconoSobre = new JLabel(sobreR);
		iconoSobre.setLocation(40, 170);
		iconoSobre.setSize(30, 30);
		credencial.add(iconoSobre);
		
		
		//Campo de texto
		textField = new JTextField();
		textField.setSize(270,30);
		textField.setLocation(70, 170);
		textField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2, false));
		credencial.add(textField);
		
		//Label indicando contraseña
		JLabel etiqueta3 = new JLabel("Password");
		etiqueta3.setSize(150, 20);
		etiqueta3.setLocation(70,220);
		etiqueta3.setHorizontalAlignment(JLabel.LEFT);
		etiqueta3.setVerticalAlignment(JLabel.CENTER);
		etiqueta3.setFont(Campos);
		credencial.add(etiqueta3);
		
		//Label con icono de candado
		ImageIcon candado = new ImageIcon(AuthView.class.getResource("/images/candado.png"));
		Image redimensionC = candado.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon candadoR = new ImageIcon(redimensionC);
		JLabel iconoCandado = new JLabel(candadoR);
		iconoCandado.setLocation(40, 250);
		iconoCandado.setSize(30, 30);
		credencial.add(iconoCandado);
		
		passwordField = new JPasswordField();
		passwordField.setSize(270,30);
		passwordField.setLocation(70, 250);
		passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2, false));
		credencial.add(passwordField);
		
		//Casilla para marcar recordar el inicio de sesion
		JCheckBox marca = new JCheckBox("Remember");
		marca.setSize(120, 25);
		marca.setLocation(60,290);
		marca.setHorizontalAlignment(JLabel.LEFT);
		marca.setOpaque(false);
		marca.setFont(media);
		credencial.add(marca);
		
		//etiqueta para la opcion de olvidar contraseña
		JLabel olvidado = new JLabel("Forgot password");
		olvidado.setSize(155, 20);
		olvidado.setLocation(180, 292);
		olvidado.setHorizontalAlignment(JLabel.RIGHT);
		olvidado.setFont(media);
		credencial.add(olvidado);
		
		
		JButton iniciar = new JButton("Login");
		iniciar.setSize(170, 45);
		iniciar.setLocation(120, 330);
		iniciar.setForeground(Color.white);
		iniciar.setFont(new Font("Arial",Font.BOLD,18));
		iniciar.setBackground(new Color(46, 174, 91));
		iniciar.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
		        iniciar.setBackground(new Color(31, 104, 59));
		    }
			public void mouseExited(MouseEvent e) {
		        iniciar.setBackground(new Color(46, 174, 91));
		    }
		});
		//Agregar acciones y restricciones de acceso de acuerdo a usuario y contraseña almacenados
		iniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean control1=false,control2=false;
				String textContra = new String(passwordField.getPassword());
				String usuario = textField.getText();
				System.out.println("Funciona");
				
				if (textField.getText().trim().isEmpty() || textField.getText().matches(".*\\s.*")){
					textField.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
				}
				else {
					textField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					control1=true;
				}
				if (passwordField.getPassword().length<4 || textContra.matches(".*\\s.*")) {
					passwordField.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
				}
				else {
					passwordField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					control2=true;
				}
				if (control1 & control2) {
					boolean autenticacion = functions.autenticar(usuario, textContra);
					if (autenticacion) {
						JOptionPane.showMessageDialog(null, "Ingreso exitoso", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos", "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
					}
						
				}	
			}
			
		});
		credencial.add(iniciar);
		
		JButton crear = new JButton("SignUp");
		crear.setSize(170, 45);
		crear.setLocation(120, 390);
		crear.setForeground(Color.WHITE);
		crear.setFont(new Font("Arial",Font.BOLD,18));
		crear.setBackground(new Color(47, 115, 176));
		crear.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
		        crear.setBackground(new Color(35, 96, 120));
		    }
			public void mouseExited(MouseEvent e) {
		        crear.setBackground(new Color(47, 115, 176));
		    }
		});
		
		ImageIcon imagen= new ImageIcon(AuthView.class.getResource("/images/vaca.jpg"));
		Image redimension= imagen.getImage().getScaledInstance(390, 480, Image.SCALE_SMOOTH);
		ImageIcon nuevaImagen = new ImageIcon(redimension);
		JLabel icono = new JLabel(nuevaImagen);
		icono.setLayout(null);
		icono.setBounds(400, 10, 390, 480);
		login.add(icono);
		frame.setVisible(true);
	}

}
