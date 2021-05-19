package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelIngreso extends JPanel{
	private JButton b_ingresar;
	private JLabel e_usuario;
	private JLabel e_clave;
	private JTextField c_usuario;
	private JPasswordField c_clave;
	
	public PanelIngreso() {
	
		setLayout(null);
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		
		e_usuario = new JLabel("Usuario: ");
		e_usuario.setFont(new Font(getName(), Font.BOLD, 14));
		e_usuario.setBounds(10,10,100,20);
		add(e_usuario);
		
		c_usuario = new JTextField();
		c_usuario.setBounds(10,40,210,25);
		add(c_usuario);
		
		e_clave =  new JLabel("Clave: ");
		e_clave.setFont(new Font(getName(), Font.BOLD, 14));
		e_clave.setBounds(10, 70, 100, 20);
		add(e_clave);
		
		c_clave = new JPasswordField();
		c_clave.setBounds(10, 100, 210, 25);
		add(c_clave);
		
		b_ingresar = new JButton("Ingresar");
		b_ingresar.setFont(new Font(getName(), Font.BOLD, 14));
		b_ingresar.setActionCommand("INGRESAR");
		b_ingresar.setBounds(60,140,100,30);
		add(b_ingresar);
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
	
}
