package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
/**
 * Clase Ventana Admin
 *
 * Clase de la vista que cuenta con 2 metodos, el constructor y otro de tipo void.
 * 
 * @author Felipe Segura
 * @author David Real
 * @author Oscar Florez
 * @author Santiago Zamora
 */
public class VentanaAdmin extends JFrame {
	/**
	 * Objeto de PanelAdmConsultar que permite llamar a sus atributos y m�todos
	 */
	private PanelAdmConsultar pConsul;
	/**
	 * Objeto de PanelAdmEliminar que permite llamar a sus atributos y m�todos
	 */
	private PanelAdmEliminar pElim;
	/**
	 * Objeto de PanelAdmInformes que permite llamar a sus atributos y m�todos
	 */
	private PanelAdmInformes pInf;
	/**
	 * Objeto de JTabbedPane
	 */
	private JTabbedPane tabs;
	
	/**
	 * M�todo constructor de la clase 
	 */
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
	/**
	 * M�todo que inicializa los componentes de la ventana
	 */
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
