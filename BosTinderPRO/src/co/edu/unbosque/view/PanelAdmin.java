package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelAdmin extends JPanel{
	
	private ImageIcon foto;
	
	public PanelAdmin() {
		foto = new ImageIcon(getClass().getResource("/imagenes/3.jpg"));
		setLayout( null );
		
	}

}
