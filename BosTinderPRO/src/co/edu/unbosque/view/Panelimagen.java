package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panelimagen extends JPanel {

	private ImageIcon im;
	
	public Panelimagen() {
		
	}
	
	public void paint(Graphics g) {
		Dimension tam = getSize();
		 im = new ImageIcon(getClass().getResource("/imagenes/ingreso.jpg"));
		 g.drawImage(im.getImage(), 0, 0, tam.width, tam.height, null);
		 setOpaque(false);
		 super.paint(g);

	}

	public ImageIcon getIm() {
		return im;
	}

	public void setIm(ImageIcon im) {
		this.im = im;
	}
}
