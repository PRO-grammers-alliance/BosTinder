package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaIngreso extends JFrame {
	
	private PanelIngreso pIngreso;
	private Panelimagen pImagen;
	private JLayeredPane lpane;
	
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
		
		lpane = new JLayeredPane();
		getContentPane().add(lpane,BorderLayout.CENTER);
		lpane.setBounds(0, 0, 700, 300);
		
		pImagen = new Panelimagen();
		pImagen.setBounds(0, 0, 700, 300);
		pImagen.setIm( new ImageIcon(getClass().getResource("/imagenes/ingreso.jpg")));
		getContentPane().add(pImagen);
		
		pIngreso = new PanelIngreso();
		pIngreso.setBounds(410, 0, 290, 230);
		getContentPane().add(pIngreso);
		
	}

	public PanelIngreso getpIngreso() {
		return pIngreso;
	}

	public void setpIngreso(PanelIngreso pIngreso) {
		this.pIngreso = pIngreso;
	}
	
}
