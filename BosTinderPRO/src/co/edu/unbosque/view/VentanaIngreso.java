package co.edu.unbosque.view;


import javax.swing.JFrame;

public class VentanaIngreso extends JFrame {
	
	private PanelIngreso pIngreso;
	private Panelimagen pImagen;
	
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
