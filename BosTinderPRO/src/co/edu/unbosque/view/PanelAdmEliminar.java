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

	public JPanel getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(JPanel panelInfo) {
		this.panelInfo = panelInfo;
	}

	public JLabel getTextoEliminar() {
		return textoEliminar;
	}

	public void setTextoEliminar(JLabel textoEliminar) {
		this.textoEliminar = textoEliminar;
	}

	public JTextField getCampoTextoId() {
		return campoTextoId;
	}

	public void setCampoTextoId(JTextField campoTextoId) {
		this.campoTextoId = campoTextoId;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JTextArea getInfoUsuario() {
		return infoUsuario;
	}

	public void setInfoUsuario(JTextArea infoUsuario) {
		this.infoUsuario = infoUsuario;
	}

	public JScrollPane getSp() {
		return sp;
	}

	public void setSp(JScrollPane sp) {
		this.sp = sp;
	}
	
}
