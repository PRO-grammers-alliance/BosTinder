package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Clase de la interfaz grafica que permite poner una imagen de fondo a los paneles.
 * @author FELIPE SEGURA
 *
 */
public class Panelimagen extends JPanel {

	/**
	 * Objeto de tipo ImageIcon.
	 */
	private ImageIcon im;
	/**
	 * Objeto de tipo String que contiene la ruta para las imagenes.
	 */
	private String ruta;
	
	/**
	 * Método constructor.
	 * @param ruta
	 */
	public Panelimagen(String ruta) {
		this.ruta=ruta;
	}
	
	/**
	 * Método para dar dimenciones a la imagen.
	 */
	public void paint(Graphics g) {
		Dimension tam = getSize();
		 im = new ImageIcon(getClass().getResource(ruta));
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
}
