package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * Clase de la interfaz grafica que permite la interccion del usuario con el programa
 * @author Felipe Segura
 * 
 */
public class VentanaPrincipal extends JFrame {
	
	/**
	 * Objeto de tipo PanelUsuario para la interracion en la ventana.
	 */
	private PanelUsuario pu;
	/**
	 * Objeto de tipo Panelimagen para el fondo de la ventana.
	 */
	private Panelimagen pim;
	/**
	 * Objeto de tipo JLayeredPane para la organizacion de la ventana.
	 */
	private JLayeredPane lpane;
	
	/**
	 * Método constructor.
	 */
	public VentanaPrincipal() {
		setTitle("Bos Tinder");
		setPreferredSize(new Dimension(700, 650));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		setVisible(false);
		
	}
	
	/**
	 * Método que inicializa las componentes de la ventana.
	 */
	public void inicializarComponentes() {
		lpane = new JLayeredPane();
		getContentPane().add(lpane,BorderLayout.CENTER);
		lpane.setBounds(0, 0, 700, 650);
		
		pu = new PanelUsuario();
		pu.setBounds(0, 0, 700, 650);
		pu.setOpaque(false);
		lpane.add(pu);
		
		pim = new Panelimagen("/imagenes/b2.jpg");
		pim.setBounds(0, 0, 700, 650);
		pim.setOpaque(true);
		lpane.add(pim);
		 
	}

	public PanelUsuario getPu() {
		return pu;
	}

	public void setPu(PanelUsuario pu) {
		this.pu = pu;
	}

	public Panelimagen getPim() {
		return pim;
	}

	public void setPim(Panelimagen pim) {
		this.pim = pim;
	}

	public JLayeredPane getLpane() {
		return lpane;
	}

	public void setLpane(JLayeredPane lpane) {
		this.lpane = lpane;
	}

}
