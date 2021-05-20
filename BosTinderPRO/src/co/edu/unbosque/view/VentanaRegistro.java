package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaRegistro extends JFrame{
	
	private PanelRegistro pRegistro;
	
	public VentanaRegistro() {
		setTitle("BosTinder Registro");
		setSize(250,250);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}

	private void inicializarComponentes() {
		pRegistro = new PanelRegistro();
		pRegistro.setBounds(0, 0, 270, 270);
		getContentPane().add(pRegistro);
	}

	public PanelRegistro getpRegistro() {
		return pRegistro;
	}

	public void setpRegistro(PanelRegistro pRegistro) {
		this.pRegistro = pRegistro;
	}
	
}
