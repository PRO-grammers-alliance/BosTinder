package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaRegistro extends JFrame{
	
	private PanelRegistro pRegistro;
	private Panelimagen pim;
	private JLayeredPane lpane;
	
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
