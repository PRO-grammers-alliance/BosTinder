package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VentanaAdmin extends JFrame {
	
	private PanelAdmConsultar pConsul;
	private PanelAdmEliminar pElim;
	private PanelAdmInformes pInf;
	private JTabbedPane tabs;
	
	public VentanaAdmin() {
		setTitle("Bos Tinder");
		setPreferredSize(new Dimension(700, 650));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(tabs = new JTabbedPane());
		setBackground(Color.LIGHT_GRAY);
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		setVisible(false);
	}
	
	public void inicializarComponentes() {
		
		pConsul = new PanelAdmConsultar();
		pConsul.setOpaque(true);
		tabs.addTab("Consultar Base de Datos",pConsul);
		
		pElim = new PanelAdmEliminar();
		tabs.addTab("Eliminar Usuario",pElim);
		
		pInf = new PanelAdmInformes();
		pInf.setOpaque(true);
		tabs.addTab("Generar Informes",pInf);
		
	}

	public PanelAdmConsultar getPConsul() {
		return pConsul;
	}

	public void setPConsul(PanelAdmConsultar pConsul) {
		this.pConsul = pConsul;
	}

	public PanelAdmConsultar getpConsul() {
		return pConsul;
	}

	public void setpConsul(PanelAdmConsultar pConsul) {
		this.pConsul = pConsul;
	}

	public PanelAdmEliminar getpElim() {
		return pElim;
	}

	public void setpElim(PanelAdmEliminar pElim) {
		this.pElim = pElim;
	}

	public PanelAdmInformes getpInf() {
		return pInf;
	}

	public void setpInf(PanelAdmInformes pInf) {
		this.pInf = pInf;
	}

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

}
