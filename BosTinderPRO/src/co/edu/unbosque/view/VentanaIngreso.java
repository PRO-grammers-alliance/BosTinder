package co.edu.unbosque.view;


import javax.swing.JFrame;

/**
 * Clase Ventana Ingreso
 *
 * Clase de la vista que cuenta con 2 metodos, el constructor y otro de tipo void.
 * 
 * @author Felipe Segura
 * @author David Real
 * @author Oscar Florez
 * @author Santiago Zamora
 */
public class VentanaIngreso extends JFrame {
	/**
	 * Objeto de PanelIngreso que permite llamar a sus atributos y métodos
	 */
	private PanelIngreso pIngreso;
	/**
	 * Objeto de Panelimagen que permite llamar a sus atributos y métodos
	 */
	private Panelimagen pImagen;
	
	/**
	 * Método constructor de la clase 
	 */
	public VentanaIngreso() {
		setTitle("BosTinderLogin");
		setSize(700, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Método que inicializa los componentes de la ventana
	 */
	public void inicializarComponentes() {
		
		pIngreso = new PanelIngreso();
		pIngreso.setBounds(410, 0, 290, 230);
		pIngreso.setOpaque(false);
		getContentPane().add(pIngreso);
		
		pImagen = new Panelimagen("/imagenes/ingreso.jpg");
		pImagen.setBounds(0, 0, 700, 300);
		getContentPane().add(pImagen);
		
	}

	public PanelIngreso getpIngreso() {
		return pIngreso;
	}

	public void setpIngreso(PanelIngreso pIngreso) {
		this.pIngreso = pIngreso;
	}
	
}
