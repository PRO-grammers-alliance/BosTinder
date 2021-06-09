package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * Clase de la interfaz grafica que permite la introduccion de la fecha de nacimiento
 * @author Santiago Zamora
 *
 */
public class VentanaEdad extends JFrame{
	/**
	 * Objeto de tipo Panelimagen para el fondo de la ventana.
	 */
	private Panelimagen pim;
	/**
	 * Objeto de tipo JLayeredPane para la organizacion de la ventana.
	 */
	private JLayeredPane lpane;
	/**
	 * Objeto de tipo PanelEdad para el ingreso de los datos en la ventana.
	 */
	private PanelEdad pEdad;
	
	/**
	 * Método constructor.
	 */
	public VentanaEdad() {
		setTitle("BosTinder Registro");
		setSize(300,300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}

	/**
	 * Método que inicializa las componentes de la ventana.
	 */
	private void inicializarComponentes() {
		
		lpane = new JLayeredPane();
		lpane.setBounds(0, 0, 300, 300);
		getContentPane().add(lpane,BorderLayout.CENTER);
		
		pEdad = new PanelEdad();
		pEdad.setBounds(0, 0, 300, 300);
		pEdad.setOpaque(false);
		lpane.add(pEdad);
		
		pim = new Panelimagen("/imagenes/edad.jpg");
		pim.setBounds(0, 0, 300, 261);
		lpane.add(pim);
		
	}

	
	
	public JLayeredPane getLpane() {
		return lpane;
	}

	public void setLpane(JLayeredPane lpane) {
		this.lpane = lpane;
	}

	public Panelimagen getPim() {
		return pim;
	}

	public void setPim(Panelimagen pim) {
		this.pim = pim;
	}

	public PanelEdad getpEdad() {
		return pEdad;
	}

	public void setpEdad(PanelEdad pEdad) {
		this.pEdad = pEdad;
	}
	
}
