package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class PanelAdmConsultar extends JPanel {

	private JComboBox<String> box_ordenar;
	private JComboBox<String> box_filtrar;
	private JRadioButton b_ascendente;
	private JRadioButton b_descendente;
	private JTextArea t_info;
	private JPanel abajo;
	public JScrollPane sp;

	public PanelAdmConsultar() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		setBorder(new TitledBorder("Panel"));

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
		b_ascendente.setBounds(220, 25, 100, 20);
		b_ascendente.setActionCommand("ASCENDENTE");
		b_ascendente.setOpaque(false);
		add(b_ascendente);

		b_descendente = new JRadioButton("Descendente");
		b_descendente.setBounds(340, 25, 100, 20);
		b_descendente.setActionCommand("DESCENDENTE");
		b_descendente.setOpaque(false);
		b_descendente.setSelected(true);
		add(b_descendente);

		t_info = new JTextArea();
		t_info.setEditable(true);//lo pongo true para que pongan mucho texto y vean como funciona 
		t_info.setLineWrap(true);//salto de linea automatico al llegar al borde
		sp = new JScrollPane(t_info, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBounds(13, 13, 634, 474);
		abajo = new JPanel();
		abajo.setLayout(null);
		abajo.setBounds(10, 60, 660, 500);
		add(abajo);
		abajo.add(sp);

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

	public JPanel getAbajo() {
		return abajo;
	}

	public void setAbajo(JPanel abajo) {
		this.abajo = abajo;
	}

	public JScrollPane getSp() {
		return sp;
	}

	public void setSp(JScrollPane sp) {
		this.sp = sp;
	}
}