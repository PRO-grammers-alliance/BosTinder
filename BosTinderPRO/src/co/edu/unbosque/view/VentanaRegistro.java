package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * Clase de la interfaz grafica que permite la introduccion de los datos para el registro de usuario.
 * @author Oscar Florez
 *
 */
public class VentanaRegistro extends JFrame{
	
	/**
	 * Objeto de tipo PanelRegistro para el ingresos de datos en la ventana.
	 */
	private PanelRegistro pRegistro;
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
	public VentanaRegistro() {
		setTitle("BosTinder Registro");
		setSize(617,420);
		
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
		lpane.setBounds(0, 0, 617, 420);
		getContentPane().add(lpane,BorderLayout.CENTER);
		
		pRegistro = new PanelRegistro();
		pRegistro.setBounds(0, 0, 617, 373);
		pRegistro.setOpaque(false);
		lpane.add(pRegistro);
		
		pim = new Panelimagen("/imagenes/registro.jpg");
		pim.setBounds(0, 0, 600, 380);
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

	public PanelRegistro getpRegistro() {
		return pRegistro;
	}

	public void setpRegistro(PanelRegistro pRegistro) {
		this.pRegistro = pRegistro;
	}
}
