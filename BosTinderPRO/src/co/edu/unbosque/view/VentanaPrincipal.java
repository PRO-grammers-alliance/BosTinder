package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaPrincipal extends JFrame {
	
	private PanelUsuario pu;
	private Panelimagen pim;
	private JLayeredPane lpane;
	
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
	
	public void inicializarComponentes() {
		lpane = new JLayeredPane();
		getContentPane().add(lpane,BorderLayout.CENTER);
		lpane.setBounds(0, 0, 700, 650);
		
		pu = new PanelUsuario();
		pu.setBounds(0, 0, 700, 650);
		pu.setOpaque(false);
		lpane.add(pu);
		
		pim = new Panelimagen();
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
