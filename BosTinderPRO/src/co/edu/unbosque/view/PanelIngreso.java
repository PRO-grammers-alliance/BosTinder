package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase Panel Ingreso
 * 
 * Clase de la vista que cuenta con 2 metodos, el constructor y otro de tipo void.
 * 
 * @author Felipe Segura
 * @author David Real
 * @author Oscar Florez
 * @author Santiago Zamora
 *
 */
public class PanelIngreso extends JPanel{
	/**
	 * Objeto de JButton
	 */
	private JButton b_ingresar;
	/**
	 * Objeto de JButton
	 */
	private JButton b_registro;
	/**
	 * Objeto de JLabel
	 */
	private JLabel e_usuario;
	/**
	 * Objeto de JLabel
	 */
	private JLabel e_clave;
	/**
	 * Objeto de JTextField
	 */
	private JTextField c_usuario;
	/**
	 * Objeto de JPasswordField
	 */
	private JPasswordField c_clave;
	
	/**
	 * M�todo constuctor del panel
	 */
	public PanelIngreso() {
	
		setLayout(null);
		inicializarComponentes();
	}
	
	/**
	 * M�todo que inicializa los componentes del Panel
	 */
	public void inicializarComponentes() {
		
		setBackground(Color.WHITE);
		
		e_usuario = new JLabel("Usuario: ");
		e_usuario.setFont(new Font(getName(), Font.BOLD, 14));
		e_usuario.setBounds(20,10,100,20);
		add(e_usuario);
		
		c_usuario = new JTextField();
		c_usuario.setBounds(20,40,210,25);
		add(c_usuario);
		
		e_clave =  new JLabel("Clave: ");
		e_clave.setFont(new Font(getName(), Font.BOLD, 14));
		e_clave.setBounds(20, 70, 100, 20);
		add(e_clave);
		
		c_clave = new JPasswordField();
		c_clave.setBounds(20, 100, 210, 25);
		add(c_clave);
		
		b_ingresar = new JButton("Ingresar");
		b_ingresar.setFont(new Font(getName(), Font.BOLD, 14));
		b_ingresar.setActionCommand("INGRESAR");
		b_ingresar.setBounds(70,140,100,30);
		add(b_ingresar);
		
		b_registro = new JButton("Registro");
		b_registro.setFont(new Font(getName(), Font.BOLD, 14));
		b_registro.setActionCommand("REGISTRO");
		b_registro.setBounds(70,180,100,30);
		add(b_registro);
	}
	
	public JLabel getE_usuario() {
		return e_usuario;
	}

	public void setE_usuario(JLabel e_usuario) {
		this.e_usuario = e_usuario;
	}

	public JLabel getE_clave() {
		return e_clave;
	}

	public void setE_clave(JLabel e_clave) {
		this.e_clave = e_clave;
	}

	public JTextField getC_usuario() {
		return c_usuario;
	}

	public void setC_usuario(JTextField c_usuario) {
		this.c_usuario = c_usuario;
	}

	public JPasswordField getC_clave() {
		return c_clave;
	}

	public void setC_clave(JPasswordField c_clave) {
		this.c_clave = c_clave;
	}

	public JButton getB_ingresar() {
		return b_ingresar;
	}

	public void setB_ingresar(JButton b_ingresar) {
		this.b_ingresar = b_ingresar;
	}

	public JButton getB_registro() {
		return b_registro;
	}

	public void setB_registro(JButton b_registro) {
		this.b_registro = b_registro;
	}
	
}
