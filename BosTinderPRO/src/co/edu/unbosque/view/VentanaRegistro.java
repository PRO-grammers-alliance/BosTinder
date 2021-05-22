package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaRegistro extends JFrame{
	
	private PanelRegistro pRegistro;
	private PanelEdad pEdad;
	
	public VentanaRegistro() {
		setTitle("BosTinder Registro");
		setSize(300,300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}

	private void inicializarComponentes() {
		
		pEdad = new PanelEdad();
		pEdad.setBounds(0, 0, 300, 300);
		getContentPane().add(pEdad);
		
		pRegistro = new PanelRegistro();
		pRegistro.setBounds(0, 0, 617, 373);
	}

	public PanelRegistro getpRegistro() {
		return pRegistro;
	}

	public void setpRegistro(PanelRegistro pRegistro) {
		this.pRegistro = pRegistro;
	}

	public PanelEdad getpEdad() {
		return pEdad;
	}

	public void setpEdad(PanelEdad pEdad) {
		this.pEdad = pEdad;
	}
	
}
