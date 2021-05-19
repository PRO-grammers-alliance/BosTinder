package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaIngreso extends JFrame {
	
	private PanelIngreso pIngreso;
	
	public VentanaIngreso() {
		setTitle("BosTinderLogin");
		setSize(270, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		
		pIngreso = new PanelIngreso();
		pIngreso.setBounds(0, 0, 270, 230);
		getContentPane().add(pIngreso);
		
	}

	public PanelIngreso getpIngreso() {
		return pIngreso;
	}

	public void setpIngreso(PanelIngreso pIngreso) {
		this.pIngreso = pIngreso;
	}
	
}
