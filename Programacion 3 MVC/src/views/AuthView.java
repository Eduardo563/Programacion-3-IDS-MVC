package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.HomeController;
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
		if (frame == null) {
			frame = new JFrame("Login");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(1000, 700);
		    frame.setLocationRelativeTo(null);
		}
		
	    
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
						HomeController inicio = new HomeController();
						frame.dispose();
						inicio.home();
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
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
		credencial.add(crear);
		crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				register2();
				
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
	
	public void register() {
		frame.getContentPane().removeAll();
		JPanel registro = new JPanel();
		registro.setLayout(null);
		registro.setLocation(100,50);
		registro.setSize(800, 500);
		registro.setOpaque(true);
		registro.setBackground(new Color (227, 227, 227));
		registro.setVisible(true);
		frame.add(registro);
		
		
		//Label para el texto registro
		JLabel etiqueta1 = new JLabel("Registro");
		etiqueta1.setBounds(330, 30, 140, 35);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(Titulo);
		registro.add(etiqueta1);
		
		//Label para el texto usuario o email
		JLabel etiqueta2 = new JLabel("Nombre de usuario");
		etiqueta2.setSize(200, 20);
		etiqueta2.setLocation(330,90);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		etiqueta2.setVerticalAlignment(JLabel.CENTER);
		etiqueta2.setFont(Campos);
		registro.add(etiqueta2);
		
		//Campo de texto
		JTextField ingreso = new JTextField();
		ingreso.setSize(270,30);
		ingreso.setLocation(280, 120);
		ingreso.setBorder(BorderFactory.createLineBorder(Color.BLACK,2, false));
		registro.add(ingreso);
		
		
		JLabel bioEtiqueta = new JLabel("Bio");
		bioEtiqueta.setSize(150, 20);
		bioEtiqueta.setLocation(395, 160);
		bioEtiqueta.setFont(Campos);
		registro.add(bioEtiqueta);
		
		//Area de texto
		JTextArea bio = new JTextArea();
		bio.setSize(270, 50);
		bio.setLocation(280, 190);
		bio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		registro.add(bio);
		
		
		//Label indicando preferencias
		JLabel etiqueta3 = new JLabel("Preferencias");
		etiqueta3.setSize(150, 20);
		etiqueta3.setLocation(360,250);
		etiqueta3.setHorizontalAlignment(JLabel.LEFT);
		etiqueta3.setVerticalAlignment(JLabel.CENTER);
		etiqueta3.setFont(Campos);
		registro.add(etiqueta3);
		
		
		
		//Casillas para marcar 
		JCheckBox P1 = new JCheckBox("Dulces");
		P1.setSize(80, 25);
		P1.setLocation(280,270);
		P1.setHorizontalAlignment(JLabel.LEFT);
		P1.setOpaque(false);
		P1.setFont(media);
		registro.add(P1);
		
		JCheckBox P2 = new JCheckBox("Salado");
		P2.setSize(80, 25);
		P2.setLocation(370,270);
		P2.setHorizontalAlignment(JLabel.LEFT);
		P2.setOpaque(false);
		P2.setFont(media);
		registro.add(P2);
		
		JCheckBox P3 = new JCheckBox("Saludable");
		P3.setSize(100, 25);
		P3.setLocation(470,270);
		P3.setHorizontalAlignment(JLabel.LEFT);
		P3.setOpaque(false);
		P3.setFont(media);
		registro.add(P3);
		
		
		JLabel terminos = new JLabel("Terminos");
		terminos.setSize(150, 20);
		terminos.setLocation(290, 300);
		terminos.setHorizontalAlignment(JLabel.RIGHT);
		terminos.setFont(media);
		registro.add(terminos);
		
		//Creacion de grupo de botones para uso de radioButton
		ButtonGroup terminosG = new ButtonGroup();
		
		JRadioButton terminosA = new JRadioButton("Acepto los terminos");
		terminosA.setLocation(250, 330);
		terminosA.setSize(160, 30);
		terminosA.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		terminosA.setBorderPainted(true);
		registro.add(terminosA);
		
		JRadioButton terminosN = new JRadioButton(" No acepto los terminos");
		terminosN.setLocation(430, 330);
		terminosN.setSize(180, 30);
		terminosN.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		terminosN.setBorderPainted(true);
		registro.add(terminosN);
		
		terminosG.add(terminosA);
		terminosG.add(terminosN);
		
		//Creacion de lista para desplegar en un comboBox
		String lista [] = {"Camino Real","Puesta del Sol","Agua Escondida","Pedregal","Centro","Los Olivos"};
		JComboBox desplegado = new JComboBox(lista);
		desplegado.setSize(270, 20);
		desplegado.setLocation(280, 380);
		registro.add(desplegado);
		
		
		
		JButton crear = new JButton("Crear cuenta");
		crear.setSize(170, 30);
		crear.setLocation(330, 420);
		crear.setForeground(Color.WHITE);
		crear.setFont(new Font("Arial",Font.BOLD,16));
		crear.setBackground(new Color(46, 125, 187));
		crear.setBorder(BorderFactory.createLineBorder(new Color(18, 78, 124), 2, false));
		registro.add(crear);
		
		//Creacion de un action listener y restricciones para el ingreso de acuerdo a contraseña y usuario almacenado
		crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean control1=false,control2=false,control3=false,control4=false;
				boolean control5=false;
				
				String preferencias="";
				
				if (ingreso.getText().equals("")||ingreso.getText().matches(".*\\s.*") ) {
					ingreso.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				}
				else {
					ingreso.setBorder(BorderFactory.createLineBorder(Color.green, 5));
					control1=true;
				}
				if(bio.getText().length()>0 & bio.getText().length()<5) {
					bio.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				}
				else {
					bio.setBorder(BorderFactory.createLineBorder(Color.green, 5));
					control2=true;
				}
				if (!terminosA.isSelected()) {
					terminosA.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				}
				else {
					terminosA.setBorder(BorderFactory.createLineBorder(Color.green, 5));
					control3=true;
				}
				if(!P1.isSelected() && !P2.isSelected() && !P3.isSelected()) {
					//Solo para indicar que por lo menos uno se debe elegir se pone en rojo el primero
					P1.setBorder(BorderFactory.createLineBorder(Color.red, 5));
					JOptionPane.showMessageDialog(null, "Escoga por lo menos una preferencia", "Preferencias invalidas", JOptionPane.WARNING_MESSAGE);
				}
				else {
					control4=true;
					if (P1.isSelected()) {
						preferencias +="Dulce";
					}
					if (P2.isSelected()) {
						if(!preferencias.equals("")) {
							preferencias+=", ";
						}
						
						 preferencias+="Salado";
						
					}
					if (P3.isSelected()) {
						if(!preferencias.equals("")) {
							preferencias+=", ";
						}
			
						preferencias+="Saludable";
						
					}
				}
				
				String coloniaSelec = desplegado.getSelectedItem().toString();
				if (control1 && control2 && control3 && control4 ) {
					control5=true;
					if (control5) {
						functions.registro(ingreso.getText(), bio.getText(), preferencias, terminosA.getText(), coloniaSelec);
						JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		
		JButton iniciar = new JButton("Login");
		iniciar.setSize(170, 30);
		iniciar.setLocation(330, 460);
		iniciar.setForeground(Color.WHITE);
		iniciar.setFont(new Font("Arial",Font.BOLD,16));
		iniciar.setBackground(new Color(46, 125, 187));
		iniciar.setBorder(BorderFactory.createLineBorder(new Color(18, 78, 124), 2, false));
		iniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					login();
			}
		});
		registro.add(iniciar);
		
		frame.revalidate();
		frame.repaint();
		
	}
	
	public void home() {
		frame.getContentPane().removeAll();
		JPanel home = new JPanel();
		home.setLayout(null);
		home.setLocation(100,50);
		home.setSize(800, 500);
		home.setOpaque(true);
		home.setBackground(new Color (227, 227, 227));
		home.setVisible(true);
		frame.add(home);
		
		
		//Label para el texto home
		JLabel etiqueta1 = new JLabel("Home");
		etiqueta1.setBounds(330, 30, 140, 35);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(Titulo);
		home.add(etiqueta1);
		
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
	}
	public void register2() {
		frame.getContentPane().removeAll();
		JPanel home;
		JTextField nombreText;
		JTextField apellidosText;
		JTextField empresaTxt;
		JTextField cargoTxt;
		JTextField userTxt;
		JPasswordField contraTxt;
		JPasswordField contraTxt2;
		JTextField emailTxt;
		
		home = new JPanel();
		home.setBackground(new Color(31, 104, 69));
		home.setBorder(new EmptyBorder(5, 5, 5, 5));
		home.setLayout(null);
		frame.setContentPane(home);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(200, 22, 634, 619);
		panel.setVisible(true);
		panel.setOpaque(true);
		home.add(panel);
		
		JLabel registroLabel = new JLabel("Registro");
		registroLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		registroLabel.setBounds(286, 23, 79, 44);
		panel.add(registroLabel);
		
		JLabel apellidos = new JLabel("Apellidos");
		apellidos.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		apellidos.setBounds(84, 157, 79, 20);
		panel.add(apellidos);
		
		JLabel empresa = new JLabel("Empresa");
		empresa.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		empresa.setBounds(84, 200, 79, 29);
		panel.add(empresa);
		
		
		
		JLabel cargo = new JLabel("Cargo");
		cargo.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		cargo.setBounds(84, 298, 49, 20);
		panel.add(cargo);
		
		JLabel user = new JLabel("Nombre de Usuario");
		user.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		user.setBounds(84, 348, 151, 14);
		panel.add(user);
		
		JLabel contra = new JLabel("Contraseña");
		contra.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		contra.setBounds(84, 400, 93, 14);
		panel.add(contra);
		
		JLabel contraVer = new JLabel("Confirmar Contraseña");
		contraVer.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		contraVer.setBounds(84, 447, 169, 14);
		panel.add(contraVer);
		
		JLabel email = new JLabel("Correo Electrónico");
		email.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		email.setBounds(84, 494, 151, 14);
		panel.add(email);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		nombre.setBounds(84, 114, 79, 14);
		panel.add(nombre);
		
		nombreText = new JTextField();
		nombreText.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		nombreText.setBounds(276, 104, 271, 36);
		nombreText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel.add(nombreText);
		nombreText.setColumns(10);
		
		apellidosText = new JTextField();
		apellidosText.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		apellidosText.setColumns(10);
		apellidosText.setBounds(276, 151, 271, 36);
		apellidosText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel.add(apellidosText);
		
		empresaTxt = new JTextField();
		empresaTxt.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		empresaTxt.setColumns(10);
		empresaTxt.setBounds(276, 198, 271, 36);
		empresaTxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel.add(empresaTxt);
		
		cargoTxt = new JTextField();
		cargoTxt.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		cargoTxt.setColumns(10);
		cargoTxt.setBounds(276, 292, 271, 36);
		cargoTxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel.add(cargoTxt);
		
		userTxt = new JTextField();
		userTxt.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		userTxt.setColumns(10);
		userTxt.setBounds(276, 339, 271, 36);
		userTxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel.add(userTxt);
		
		contraTxt = new JPasswordField();
		contraTxt.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		contraTxt.setColumns(10);
		contraTxt.setBounds(276, 391, 271, 36);
		contraTxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel.add(contraTxt);
		
		contraTxt2 = new JPasswordField();
		contraTxt2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		contraTxt2.setColumns(10);
		contraTxt2.setBounds(276, 438, 271, 36);
		contraTxt2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel.add(contraTxt2);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		emailTxt.setColumns(10);
		emailTxt.setBounds(276, 485, 271, 36);
		emailTxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panel.add(emailTxt);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(276, 245, 271, 36);
		comboBox.addItem("Tecnología");
		comboBox.addItem("Salud");
		comboBox.addItem("Eduación");
		comboBox.addItem("Comercio");
		comboBox.addItem("Otro");
		panel.add(comboBox);
		
		JLabel lblmbitoDeLa = new JLabel("Ámbito de la Empresa");
		lblmbitoDeLa.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblmbitoDeLa.setBounds(84, 247, 169, 29);
		panel.add(lblmbitoDeLa);
		
		JButton registro = new JButton("Registrarse");
		registro.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		registro.setBackground(new Color(47, 115, 176));
		registro.setForeground(Color.white);
		registro.setBounds(238, 560, 182, 44);
		panel.add(registro);
		registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = new String(nombreText.getText());
				String apellido = new String(apellidosText.getText());
				String empresa = new String(empresaTxt.getText());
				String ambito = new String(comboBox.getSelectedItem().toString());
				String cargo = new String(cargoTxt.getText());
				String usuario = new String(userTxt.getText());
				String textContra = new String(contraTxt.getPassword());
				String textContra2=new String(contraTxt2.getPassword());
				String correo = new String(emailTxt.getText());
				boolean c1=false,c2=false,c3=false,c4=false,c5=false,c6=false,c7=false,c8=false,c9=false;
				
				if (nombreText.getText().matches("^[\\p{L} ]+$")) {
					nombreText.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c1=true;
				}
				else {
					nombreText.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					JOptionPane.showMessageDialog(null, "Solo se admiten letras y espacios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (apellidosText.getText().matches("^[\\p{L} ]+$")) {
					apellidosText.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c2=true;
				}
				else {
					apellidosText.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					JOptionPane.showMessageDialog(null, "Solo se admiten letras y espacios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (empresaTxt.getText().matches("^[\\p{L}\\p{Nd} ]+$")) {
					empresaTxt.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c3=true;
				}
				else {
					empresaTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					JOptionPane.showMessageDialog(null, "Solo se admiten letras, numeros y espacios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (comboBox.getSelectedIndex()>=0) {
					comboBox.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c4=true;
				}
				else {
					comboBox.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
				}
				if (cargoTxt.getText().matches("^[\\p{L} ]+$")) {
					cargoTxt.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c5=true;
				}
				else {
					cargoTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					JOptionPane.showMessageDialog(null, "Solo se admiten letras y espacios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (userTxt.getText().matches("^[\\p{L}\\p{Nd} ]+$")) {
					userTxt.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c6=true;
				}
				else {
					userTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					JOptionPane.showMessageDialog(null, "Solo se admiten letras, numeros y espacios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textContra.matches("^(?=\\S+$)(?=.*\\W)[\\p{L}\\p{Nd}\\W]+$")) {
					contraTxt.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c7=true;
				}
				else {
					contraTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					JOptionPane.showMessageDialog(null, "Solo se admiten letras, numeros y al menos un caracter especial", "Error de Validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textContra2.equals(textContra)) {
					contraTxt2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c8=true;
				}
				else {
					contraTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					JOptionPane.showMessageDialog(null, "La contraseña no coincide", "Error de Validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (emailTxt.getText().matches("^\\S+$")) {
					emailTxt.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
					c9=true;
				}
				else {
					emailTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
					JOptionPane.showMessageDialog(null, "Elimine los espacios", "Error de Validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (c1 && c2 && c3 && c4 && c5 && c6 && c7 && c8 && c9) {
					try {
						functions.escritura(nombre, apellido, empresa, ambito, cargo, usuario, textContra, correo);
						JOptionPane.showMessageDialog(null, "Registro exitoso", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
						login();
					} catch (IOException e1) {
						System.out.println("Ocurrio un error"+e1.getMessage());
						e1.printStackTrace();
					}
					
				}
			}
			
		});
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
		
		
		
		}
	


}
