package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 * Clase de la interfaz grafica que permite la interracion del usuarion con el programa.
 * @author FELIPE SEGURA
 *
 */
public class PanelUsuario extends JPanel{
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private  JLabel fotoSecreta;
	/**
	 * Objeto de tipo JLabel.
	 */
	private  JLabel fotoSecreta1;
	/**
	 * Objeto de tipo JLabel.
	 */
	private  JLabel fotoSecreta2;
	/**
	 * Objeto de tipo JButton.
	 */
	private JButton like;
	/**
	 * Objeto de tipo JButton.
	 */
	private JButton dislike;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel nombreCompleto;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel genero;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel edad;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel edadNumero;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel estatura;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel divircios;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel EoD;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel ingresos;
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel money;
	/**
	 * Objeto de tipo ImageIcon.
	 */
	private ImageIcon foto;
	/**
	 * Objeto de tipo ImageIcon.
	 */
	private ImageIcon foto1;
	/**
	 * Objeto de tipo ImageIcon.
	 */
	private ImageIcon foto2;
	
	/**
	 * Método constructor.
	 */
	public PanelUsuario() {
		setLayout( null );
		inicializarComponentes();
	}
	
	/**
	 * Método que inicializa las componentes del panel.
	 */
	public void inicializarComponentes() {
		foto = new ImageIcon(getClass().getResource("/imagenes/0.jpg"));
		foto1 = new ImageIcon(getClass().getResource("/imagenes/1.jpg"));
		foto2 = new ImageIcon(getClass().getResource("/imagenes/2.jpg"));
		
		fotoSecreta = new JLabel(foto);
		fotoSecreta.setBounds(234, 75, 234, 234);
		fotoSecreta.setVisible(false);
		add(fotoSecreta);
		
		fotoSecreta1 = new JLabel(foto1);
		fotoSecreta1.setVisible(false);
		fotoSecreta1.setBounds(234, 75, 234, 234);
		add(fotoSecreta1);
		
		fotoSecreta2 = new JLabel(foto2);
		fotoSecreta2.setVisible(false);
		fotoSecreta2.setBounds(234, 75, 234, 234);
		add(fotoSecreta2);
		
		nombreCompleto = new JLabel("");
		nombreCompleto.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		nombreCompleto.setBorder(new LineBorder(Color.black));
		nombreCompleto.setForeground(Color.black);
		nombreCompleto.setBounds(150, 325, 400, 30);
		add(nombreCompleto);
		
		genero = new JLabel("");
		genero.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		genero.setBorder(new LineBorder(Color.black));
		genero.setForeground(Color.black);
		genero.setBounds(150, 355, 400, 30);
		add(genero);
		
		edadNumero = new JLabel("");
		edadNumero.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		edadNumero.setForeground(Color.black);
		edadNumero.setBounds(205, 385, 400, 30);
		add(edadNumero);
		
		edad = new JLabel("Edad:");
		edad.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		edad.setBorder(new LineBorder(Color.black));
		edad.setBorder(new LineBorder(Color.black));
		edad.setForeground(Color.black);
		edad.setBounds(150, 385, 400, 30);
		add(edad);
		
		estatura = new JLabel("Estatura:");
		estatura.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		estatura.setBorder(new LineBorder(Color.black));
		estatura.setForeground(Color.black);
		estatura.setBounds(150, 415, 400, 30);
		add(estatura);
		estatura.setVisible(true);
		
		divircios = new JLabel("Divircios:");
		divircios.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		divircios.setBorder(new LineBorder(Color.black));
		divircios.setForeground(Color.black);
		divircios.setBounds(150, 415, 400, 30);
		add(divircios);
		divircios.setVisible(false);
		
		EoD = new JLabel("");
		EoD.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		EoD.setForeground(Color.black);
		EoD.setBounds(237, 415, 400, 30);
		add(EoD);
		
		ingresos = new JLabel("Ingresos:");
		ingresos.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		ingresos.setBorder(new LineBorder(Color.black));
		ingresos.setForeground(Color.black);
		ingresos.setBounds(150, 445, 400, 30);
		add(ingresos);
		
		money = new JLabel("");
		money.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		money.setForeground(Color.black);
		money.setBounds(240, 445, 400, 30);
		add(money);
		
		like = new JButton("Like");
		like.setActionCommand("LIKE");
		like.setBounds(160, 500, 175, 40);
		add(like);
		
		dislike = new JButton("Next");
		dislike.setActionCommand("NOLIKE");
		dislike.setBounds(340, 500, 175, 40);
		add(dislike);
		
	}

	

	public JLabel getFotoSecreta1() {
		return fotoSecreta1;
	}

	public void setFotoSecreta1(JLabel fotoSecreta1) {
		this.fotoSecreta1 = fotoSecreta1;
	}

	public JLabel getFotoSecreta2() {
		return fotoSecreta2;
	}

	public void setFotoSecreta2(JLabel fotoSecreta2) {
		this.fotoSecreta2 = fotoSecreta2;
	}

	public ImageIcon getFoto1() {
		return foto1;
	}

	public void setFoto1(ImageIcon foto1) {
		this.foto1 = foto1;
	}

	public ImageIcon getFoto2() {
		return foto2;
	}

	public void setFoto2(ImageIcon foto2) {
		this.foto2 = foto2;
	}

	public JLabel getFotoSecreta() {
		return fotoSecreta;
	}

	public void setFotoSecreta(JLabel imageIcon) {
		this.fotoSecreta = imageIcon;
	}

	public JButton getLike() {
		return like;
	}

	public void setLike(JButton like) {
		this.like = like;
	}

	public JButton getDislike() {
		return dislike;
	}

	public void setDislike(JButton dislike) {
		this.dislike = dislike;
	}

	public JLabel getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(JLabel nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public JLabel getGenero() {
		return genero;
	}

	public void setGenero(JLabel genero) {
		this.genero = genero;
	}

	public JLabel getEdad() {
		return edad;
	}

	public void setEdad(JLabel edad) {
		this.edad = edad;
	}

	public JLabel getEoD() {
		return EoD;
	}

	public void setEoD(JLabel eoD) {
		EoD = eoD;
	}

	public JLabel getMoney() {
		return money;
	}

	public void setMoney(JLabel money) {
		this.money = money;
	}

	public ImageIcon getFoto() {
		return foto;
	}

	public void setFoto(ImageIcon foto) {
		this.foto = foto;
	}

	public JLabel getEdadNumero() {
		return edadNumero;
	}

	public void setEdadNumero(JLabel edadNumero) {
		this.edadNumero = edadNumero;
	}

	public JLabel getEstatura() {
		return estatura;
	}

	public void setEstatura(JLabel estatura) {
		this.estatura = estatura;
	}

	public JLabel getDivircios() {
		return divircios;
	}

	public void setDivircios(JLabel divircios) {
		this.divircios = divircios;
	}

	public JLabel getIngresos() {
		return ingresos;
	}

	public void setIngresos(JLabel ingresos) {
		this.ingresos = ingresos;
	}

}
