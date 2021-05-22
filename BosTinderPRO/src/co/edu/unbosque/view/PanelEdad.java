package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelEdad extends JPanel{
	
	private JButton b_validar;
	private JLabel instruccion1;
	private JLabel instruccion2;
	private JLabel separar;
	private JLabel separar2;
	private JTextField dia;
	private JTextField mes;
	private JTextField año;
	
	public PanelEdad() {
		setLayout(null);
		inicializarComponentes();
		
	}
	public void inicializarComponentes() {
		instruccion1 = new JLabel("Ingrese su fecha de nacimiento");
		instruccion1.setFont(new Font(getName(), Font.BOLD, 14));
		instruccion1.setBounds(40, 25,300, 20);
		add(instruccion1);

		instruccion2 = new JLabel("DD   /   MM   /       AAAA");
		instruccion2.setFont(new Font(getName(), Font.BOLD, 14));
		instruccion2.setBounds(80, 55, 300, 20);
		add(instruccion2);

		separar = new JLabel("/");
		separar.setFont(new Font(getName(), Font.BOLD, 14));
		separar.setBounds(110, 90, 100, 20);
		add(separar);

		separar2 = new JLabel("/");
		separar2.setFont(new Font(getName(), Font.BOLD, 14));
		separar2.setBounds(165, 90, 100, 20);
		add(separar2);

		b_validar = new JButton("Validar Edad");
		b_validar.setFont(new Font(getName(), Font.BOLD, 14));
		b_validar.setActionCommand("VALIDAR");
		b_validar.setBounds(60, 200, 170, 30);
		add(b_validar);
		
		dia = new JTextField();
		dia.setBounds(65, 90, 40, 25);
		add(dia);

		mes = new JTextField();
		mes.setBounds(121, 90, 40, 25);
		add(mes);

		año = new JTextField();
		año.setBounds(179, 90, 80, 25);
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
