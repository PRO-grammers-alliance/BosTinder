package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Clase de la interfaz grafica que permite el ingreso de la fecha de nacimiento para validar la edad del usuario.
 * @author Santiago Zamora
 *
 */
public class PanelEdad extends JPanel{
	
	/**
	 * Objeto de tipo JButton.
	 */
	private JButton b_validar;
	/**
	 * Objeto de tipo Jlabel.
	 */
	private JLabel instruccion1;
	/**
	 * Objeto de tipo Jlabel.
	 */
	private JLabel instruccion2;
	/**
	 * Objeto de tipo Jlabel.
	 */
	private JLabel separar;
	/**
	 * Objeto de tipo Jlabel.
	 */
	private JLabel separar2;
	/**
	 * Objeto de tipo JTextField para el ingreso del dia.
	 */
	private JTextField dia;
	/**
	 * Objeto de tipo JTextField para el ingreso del mes.
	 */
	private JTextField mes;
	/**
	 * Objeto de tipo JTextField para el ingreso del año.
	 */
	private JTextField año;
	
	
	/**
	 * Método constructor.
	 */
	public PanelEdad() {
		setLayout(null);
		inicializarComponentes();
		
	}
	
	/**
	 * Método que inicializa las componentes del panel.
	 */
	public void inicializarComponentes() {
		
		
		
		instruccion1 = new JLabel("Ingrese su fecha de nacimiento");
		instruccion1.setFont(new Font(getName(), Font.BOLD, 14));
		instruccion1.setBounds(40, 45,300, 20);
		instruccion1.setVisible(true);
		add(instruccion1);

		instruccion2 = new JLabel(" DD    /   MM    /    AAAA");
		instruccion2.setFont(new Font(getName(), Font.BOLD, 14));
		instruccion2.setBounds(70, 63, 300, 20);
		add(instruccion2);

		separar = new JLabel("/");
		separar.setFont(new Font(getName(), Font.BOLD, 25));
		separar.setBounds(110, 100, 100, 20);
		add(separar);

		separar2 = new JLabel("/");
		separar2.setFont(new Font(getName(), Font.BOLD, 25));
		separar2.setBounds(165, 100, 100, 20);
		add(separar2);

		b_validar = new JButton("Validar Edad");
		b_validar.setFont(new Font(getName(), Font.BOLD, 14));
		b_validar.setActionCommand("VALIDAR");
		b_validar.setBounds(60, 180, 170, 30);
		add(b_validar);
		
		dia = new JTextField();
		dia.setBounds(65, 100, 40, 25);
		add(dia);

		mes = new JTextField();
		mes.setBounds(121, 100, 40, 25);
		add(mes);

		año = new JTextField();
		año.setBounds(179, 100, 57, 25);
		add(año);
		
	}
	
	public JButton getB_validar() {
		return b_validar;
	}

	public void setB_validar(JButton b_validar) {
		this.b_validar = b_validar;
	}

	public JLabel getInstruccion1() {
		return instruccion1;
	}

	public void setInstruccion1(JLabel instruccion1) {
		this.instruccion1 = instruccion1;
	}

	public JLabel getInstruccion2() {
		return instruccion2;
	}

	public void setInstruccion2(JLabel instruccion2) {
		this.instruccion2 = instruccion2;
	}

	public JLabel getSeparar() {
		return separar;
	}

	public void setSeparar(JLabel separar) {
		this.separar = separar;
	}

	public JLabel getSeparar2() {
		return separar2;
	}

	public void setSeparar2(JLabel separar2) {
		this.separar2 = separar2;
	}

	public JTextField getDia() {
		return dia;
	}

	public void setDia(JTextField dia) {
		this.dia = dia;
	}

	public JTextField getMes() {
		return mes;
	}

	public void setMes(JTextField mes) {
		this.mes = mes;
	}

	public JTextField getAño() {
		return año;
	}

	public void setAño(JTextField año) {
		this.año = año;
	}
}
