package co.edu.unbosque.view;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class PanelAdmEliminar extends JPanel{
	
	private JPanel panelInfo;
	private JLabel textoEliminar;
	private JTextField campoTextoId;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JTextArea infoUsuario;
	private JScrollPane sp;
	
	public PanelAdmEliminar() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		textoEliminar = new JLabel("ID Usuario a eliminar");
		textoEliminar.setBounds(267, 34, 127, 21);
		add(textoEliminar);
		
		campoTextoId = new JTextField();
		campoTextoId.setBounds(291, 62, 79, 27);
		add(campoTextoId);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(111, 126, 100, 27);
		btnBuscar.setActionCommand("BUSCAR");
		add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(445, 126, 100, 27);
		btnEliminar.setActionCommand("ELIMINAR");
		add(btnEliminar);
		
		infoUsuario = new JTextArea();
		infoUsuario.setLineWrap(false);
		infoUsuario.setEditable(false);
		
		sp = new JScrollPane(infoUsuario, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(0, 0, 644, 304);
		
		panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBounds(16, 180, 644, 304);
		panelInfo.add(sp);
		add(panelInfo);
	}

	
}
