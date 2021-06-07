package co.edu.unbosque.view;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdmInformes extends JPanel{
	
	private JLabel e_Info;
	private JLabel e_Media;
	private JLabel e_Mediana;
	private JLabel e_Moda;
	private JCheckBox box_Edad1;
	private JCheckBox box_Edad2;
	private JCheckBox box_Edad3;
	private JCheckBox box_Ingresos1;
	private JCheckBox box_Ingresos2;
	private JCheckBox box_Ingresos3;
	private JCheckBox box_LikesOt1;
	private JCheckBox box_LikesOt2;
	private JCheckBox box_LikesOt3;
	private JCheckBox box_LikesRec1;
	private JCheckBox box_LikesRec2;
	private JCheckBox box_LikesRec3;
	private JButton b_GenerarInf;
	
	public PanelAdmInformes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		
		e_Info = new JLabel("Seleccione el contenido del Informe");
		e_Info.setFont(new Font(getName(),Font.BOLD, 20));
		e_Info.setBounds(80, 120, 400, 20);
		add(e_Info);
		
		e_Media = new JLabel("Media");
		e_Media.setFont(new Font(getName(),Font.BOLD, 18));
		e_Media.setBounds(130, 190, 100, 20);
		add(e_Media);
		
		e_Mediana = new JLabel("Mediana");
		e_Mediana.setFont(new Font(getName(),Font.BOLD, 18));
		e_Mediana.setBounds(300, 190, 100, 20);
		add(e_Mediana);
		
		e_Moda = new JLabel("Moda");
		e_Moda.setFont(new Font(getName(),Font.BOLD, 18));
		e_Moda.setBounds(460, 190, 100, 20);
		add(e_Moda);
		
		box_Edad1 = new JCheckBox("Edad");
		box_Edad1.setFont(new Font(getName(),Font.PLAIN, 15));
		box_Edad1.setBounds(130, 240, 100, 20);
		box_Edad1.setActionCommand("EDADMEDIA");
		box_Edad1.setOpaque(false);
		add(box_Edad1);
		
		box_Edad2 = new JCheckBox("Edad");
		box_Edad2.setFont(new Font(getName(),Font.PLAIN, 15));
		box_Edad2.setBounds(300, 240, 100, 20);
		box_Edad2.setActionCommand("EDADMEDIANA");
		box_Edad2.setOpaque(false);
		add(box_Edad2);
		
		box_Edad3 = new JCheckBox("Edad");
		box_Edad3.setFont(new Font(getName(),Font.PLAIN, 15));
		box_Edad3.setBounds(460, 240, 100, 20);
		box_Edad3.setActionCommand("EDADMODA");
		box_Edad3.setOpaque(false);
		add(box_Edad3);
		
		box_Ingresos1 = new JCheckBox("Ingresos");
		box_Ingresos1.setFont(new Font(getName(),Font.PLAIN, 15));
		box_Ingresos1.setBounds(130, 290, 100, 20);
		box_Ingresos1.setActionCommand("INGRESOSMEDIA");
		box_Ingresos1.setOpaque(false);
		add(box_Ingresos1);
		
		box_Ingresos2 = new JCheckBox("Ingresos");
		box_Ingresos2.setFont(new Font(getName(),Font.PLAIN, 15));
		box_Ingresos2.setBounds(300, 290, 100, 20);
		box_Ingresos2.setActionCommand("INGRESOSMEDIANA");
		box_Ingresos2.setOpaque(false);
		add(box_Ingresos2);
		
		box_Ingresos3 = new JCheckBox("Ingresos");
		box_Ingresos3.setFont(new Font(getName(),Font.PLAIN, 15));
		box_Ingresos3.setBounds(460, 290, 100, 20);
		box_Ingresos3.setActionCommand("INGRESOSMODA");
		box_Ingresos3.setOpaque(false);
		add(box_Ingresos3);
		
		box_LikesOt1 = new JCheckBox("Likes Otorgados");
		box_LikesOt1.setFont(new Font(getName(),Font.PLAIN, 15));
		box_LikesOt1.setBounds(130, 340, 150, 20);
		box_LikesOt1.setActionCommand("LIKESOMEDIA");
		box_LikesOt1.setOpaque(false);
		add(box_LikesOt1);
		
		box_LikesOt2 = new JCheckBox("Likes Otorgados");
		box_LikesOt2.setFont(new Font(getName(),Font.PLAIN, 15));
		box_LikesOt2.setBounds(300, 340, 150, 20);
		box_LikesOt2.setActionCommand("LIKESOMEDIANA");
		box_LikesOt2.setOpaque(false);
		add(box_LikesOt2);
		
		box_LikesOt3 = new JCheckBox("Likes Otorgados");
		box_LikesOt3.setFont(new Font(getName(),Font.PLAIN, 15));
		box_LikesOt3.setBounds(460, 340, 150, 20);
		box_LikesOt3.setActionCommand("LIKESOMODA");
		box_LikesOt3.setOpaque(false);
		add(box_LikesOt3);
		
		box_LikesRec1 = new JCheckBox("Likes Recibidos");
		box_LikesRec1.setFont(new Font(getName(),Font.PLAIN, 15));
		box_LikesRec1.setBounds(130, 390, 150, 20);
		box_LikesRec1.setActionCommand("LIKESRMEDIA");
		box_LikesRec1.setOpaque(false);
		add(box_LikesRec1);
		
		box_LikesRec2 = new JCheckBox("Likes Recibidos");
		box_LikesRec2.setFont(new Font(getName(),Font.PLAIN, 15));
		box_LikesRec2.setBounds(300, 390, 150, 20);
		box_LikesRec2.setActionCommand("LIKESRMEDIANA");
		box_LikesRec2.setOpaque(false);
		add(box_LikesRec2);
		
		box_LikesRec3 = new JCheckBox("Likes Recibidos");
		box_LikesRec3.setFont(new Font(getName(),Font.PLAIN, 15));
		box_LikesRec3.setActionCommand("LIKESRMODA");
		box_LikesRec3.setBounds(460, 390, 150, 20);
		box_LikesRec3.setOpaque(false);
		add(box_LikesRec3);
		
		b_GenerarInf = new JButton("Generar Informe");
		b_GenerarInf.setActionCommand("GENERARPDF");
		b_GenerarInf.setBounds(260, 470, 200, 30);
		add(b_GenerarInf);
		
		
	}

	public JLabel getE_Info() {
		return e_Info;
	}

	public void setE_Info(JLabel e_Info) {
		this.e_Info = e_Info;
	}

	public JLabel getE_Media() {
		return e_Media;
	}

	public void setE_Media(JLabel e_Media) {
		this.e_Media = e_Media;
	}

	public JLabel getE_Mediana() {
		return e_Mediana;
	}

	public void setE_Mediana(JLabel e_Mediana) {
		this.e_Mediana = e_Mediana;
	}

	public JLabel getE_Moda() {
		return e_Moda;
	}

	public void setE_Moda(JLabel e_Moda) {
		this.e_Moda = e_Moda;
	}

	public JCheckBox getBox_Edad1() {
		return box_Edad1;
	}

	public void setBox_Edad1(JCheckBox box_Edad1) {
		this.box_Edad1 = box_Edad1;
	}

	public JCheckBox getBox_Edad2() {
		return box_Edad2;
	}

	public void setBox_Edad2(JCheckBox box_Edad2) {
		this.box_Edad2 = box_Edad2;
	}

	public JCheckBox getBox_Edad3() {
		return box_Edad3;
	}

	public void setBox_Edad3(JCheckBox box_Edad3) {
		this.box_Edad3 = box_Edad3;
	}

	public JCheckBox getBox_Ingresos1() {
		return box_Ingresos1;
	}

	public void setBox_Ingresos1(JCheckBox box_Ingresos1) {
		this.box_Ingresos1 = box_Ingresos1;
	}

	public JCheckBox getBox_Ingresos2() {
		return box_Ingresos2;
	}

	public void setBox_Ingresos2(JCheckBox box_Ingresos2) {
		this.box_Ingresos2 = box_Ingresos2;
	}

	public JCheckBox getBox_Ingresos3() {
		return box_Ingresos3;
	}

	public void setBox_Ingresos3(JCheckBox box_Ingresos3) {
		this.box_Ingresos3 = box_Ingresos3;
	}

	public JCheckBox getBox_LikesOt1() {
		return box_LikesOt1;
	}

	public void setBox_LikesOt1(JCheckBox box_LikesOt1) {
		this.box_LikesOt1 = box_LikesOt1;
	}

	public JCheckBox getBox_LikesOt2() {
		return box_LikesOt2;
	}

	public void setBox_LikesOt2(JCheckBox box_LikesOt2) {
		this.box_LikesOt2 = box_LikesOt2;
	}

	public JCheckBox getBox_LikesOt3() {
		return box_LikesOt3;
	}

	public void setBox_LikesOt3(JCheckBox box_LikesOt3) {
		this.box_LikesOt3 = box_LikesOt3;
	}

	public JCheckBox getBox_LikesRec1() {
		return box_LikesRec1;
	}

	public void setBox_LikesRec1(JCheckBox box_LikesRec1) {
		this.box_LikesRec1 = box_LikesRec1;
	}

	public JCheckBox getBox_LikesRec2() {
		return box_LikesRec2;
	}

	public void setBox_LikesRec2(JCheckBox box_LikesRec2) {
		this.box_LikesRec2 = box_LikesRec2;
	}

	public JCheckBox getBox_LikesRec3() {
		return box_LikesRec3;
	}

	public void setBox_LikesRec3(JCheckBox box_LikesRec3) {
		this.box_LikesRec3 = box_LikesRec3;
	}

	public JButton getB_GenerarInf() {
		return b_GenerarInf;
	}

	public void setB_GenerarInf(JButton b_GenerarInf) {
		this.b_GenerarInf = b_GenerarInf;
	}

}
