package co.edu.unbosque.view;


import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class PanelAdmConsultar extends JPanel{
	
	private JComboBox<String> box_ordenar;
	private JComboBox<String> box_filtrar;
	private JRadioButton b_ascendente;
	private JRadioButton b_descendente;
	private JTextArea t_info;
	
	public PanelAdmConsultar() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		
		box_ordenar = new JComboBox<String>();
		box_ordenar.setBounds(10, 25, 200, 20);
		box_ordenar.addItem("Nombre");
		box_ordenar.addItem("Apellido");
		box_ordenar.addItem("Edad");
		box_ordenar.addItem("Alias");
		box_ordenar.addItem("Número Likes");
		box_ordenar.setActionCommand("ORDENAR");
		add(box_ordenar);
		
		box_filtrar = new JComboBox<String>();
		box_filtrar.setBounds(460, 25, 200, 20);
		box_filtrar.addItem("Sin Filtro");
		box_filtrar.addItem("Top 10 Más Likes");
		box_filtrar.addItem("Ingresos >= a 244.85 USD");
		box_filtrar.addItem("Género");
		box_filtrar.setActionCommand("FILTRAR");
		add(box_filtrar);
		
		b_ascendente = new JRadioButton("Ascendente");
		b_ascendente.setBounds(220,25,100,20);
		b_ascendente.setActionCommand("ASCENDENTE");
		b_ascendente.setOpaque(false);
		add(b_ascendente);
		
		b_descendente = new JRadioButton("Descendente");
		b_descendente.setBounds(340,25,100,20);
		b_descendente.setActionCommand("DESCENDENTE");
		b_descendente.setOpaque(false);
		b_descendente.setSelected(true);
		add(b_descendente);
		
		t_info = new JTextArea();
		t_info.setBounds(10, 60, 660, 400);
		t_info.setEditable(false);
		add(t_info);
	}

	public JComboBox<String> getBox_ordenar() {
		return box_ordenar;
	}

	public void setBox_ordenar(JComboBox<String> box_ordenar) {
		this.box_ordenar = box_ordenar;
	}
	
	public JComboBox<String> getBox_filtrar() {
		return box_filtrar;
	}

	public void setBox_filtrar(JComboBox<String> box_filtrar) {
		this.box_filtrar = box_filtrar;
	}
	
	public JRadioButton getB_ascendente() {
		return b_ascendente;
	}

	public void setB_ascendente(JRadioButton b_ascendente) {
		this.b_ascendente = b_ascendente;
	}

	public JRadioButton getB_descendente() {
		return b_descendente;
	}

	public void setB_descendente(JRadioButton b_descendente) {
		this.b_descendente = b_descendente;
	}

	public JTextArea getT_info() {
		return t_info;
	}

	public void setT_info(JTextArea t_info) {
		this.t_info = t_info;
	}
	
}
