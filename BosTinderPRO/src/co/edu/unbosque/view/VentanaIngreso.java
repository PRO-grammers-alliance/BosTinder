package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.TrayIcon;

import javax.swing.JFrame;

public class VentanaIngreso extends JFrame {
	
	private PanelIngreso pIngreso;
	
	public VentanaIngreso() {
		setTitle("Login");
		setSize(250, 230);
		Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/LogoMachines.png")); 
		int trayIconWidth = new TrayIcon(icono).getSize().width;
		TrayIcon trayIcon = new TrayIcon(icono.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH));
		setIconImage(trayIcon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		inicializarComponentes();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		
		pIngreso = new PanelIngreso();
		pIngreso.setBounds(0, 0, 250, 230);
		getContentPane().add(pIngreso);
		
	}

	public PanelIngreso getpIngreso() {
		return pIngreso;
	}

	public void setpIngreso(PanelIngreso pIngreso) {
		this.pIngreso = pIngreso;
	}
	
}
