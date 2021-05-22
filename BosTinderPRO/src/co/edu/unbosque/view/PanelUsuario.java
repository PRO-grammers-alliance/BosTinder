package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelUsuario extends JPanel{
	
	private  JLabel fotoSecreta;
	private JButton like;
	private JButton dislike;
	private JLabel nombreCompleto;
	private JLabel genero;
	private JLabel edad;
	private JLabel edadNumero;
	private JLabel estatura;
	private JLabel divircios;
	private JLabel EoD;
	private JLabel ingresos;
	private JLabel money;
	private ImageIcon foto;
	
	public PanelUsuario() {
		foto = new ImageIcon(getClass().getResource("/imagenes/3.jpg"));
		setLayout( null );
		
		fotoSecreta = new JLabel(foto);
		fotoSecreta.setBounds(234, 75, 234, 234);
		add(fotoSecreta);
		
		nombreCompleto = new JLabel("Felipe Segura Rodriguez");
		nombreCompleto.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		nombreCompleto.setForeground(Color.black);
		nombreCompleto.setBounds(150, 200, 600, 300);
		add(nombreCompleto);
		
		genero = new JLabel("Masculino");
		genero.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		genero.setForeground(Color.black);
		genero.setBounds(150, 225, 600, 300);
		add(genero);
		
		edadNumero = new JLabel("21");
		edadNumero.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		edadNumero.setForeground(Color.black);
		edadNumero.setBounds(205, 250, 600, 300);
		add(edadNumero);
		
		edad = new JLabel("Edad:");
		edad.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		edad.setForeground(Color.black);
		edad.setBounds(150, 250, 600, 300);
		add(edad);
		
		estatura = new JLabel("Estatura:");
		estatura.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		estatura.setForeground(Color.black);
		estatura.setBounds(150, 275, 600, 300);
		add(estatura);
		estatura.setVisible(true);
		
		divircios = new JLabel("Divircios:");
		divircios.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		divircios.setForeground(Color.black);
		divircios.setBounds(150, 275, 600, 300);
		add(divircios);
		divircios.setVisible(false);
		
		EoD = new JLabel("170 cm");
		EoD.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		EoD.setForeground(Color.black);
		EoD.setBounds(237, 275, 600, 300);
		add(EoD);
		
		ingresos = new JLabel("Ingresos:");
		ingresos.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		ingresos.setForeground(Color.black);
		ingresos.setBounds(150, 300, 600, 300);
		add(ingresos);
		
		money = new JLabel("1000000");
		money.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		money.setForeground(Color.black);
		money.setBounds(240, 300, 600, 300);
		add(money);
		
		like = new JButton("Me encorazona");
		like.setBounds(160, 500, 175, 40);
		add(like);
		
		dislike = new JButton("No gracias");
		dislike.setBounds(340, 500, 175, 40);
		add(dislike);
		
	}

	public JLabel getFotoSecreta() {
		return fotoSecreta;
	}

	public void setFotoSecreta(JLabel fotoSecreta) {
		this.fotoSecreta = fotoSecreta;
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
