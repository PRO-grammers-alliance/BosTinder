package co.edu.unbosque.view;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdmInformes extends JPanel{
	
	private JLabel e_Info;
	private JCheckBox box_Edad;
	private JCheckBox box_Ingresos;
	private JCheckBox box_LikesOt;
	private JCheckBox box_LikesRec;
	private JButton b_GenerarInf;
	
	public PanelAdmInformes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		
		e_Info = new JLabel("<html><body>Seleccione el contenido del Informe "
				+ "<br> Media, Mediana y Moda de: </body></html>");
		e_Info.setFont(new Font(getName(),Font.BOLD, 20));
		e_Info.setBounds(80, 120, 450, 50);
		add(e_Info);
		
		box_Edad = new JCheckBox("Edad");
		box_Edad.setFont(new Font(getName(),Font.PLAIN, 15));
		box_Edad.setBounds(260, 240, 100, 20);
		box_Edad.setActionCommand("EDADINFO");
		box_Edad.setOpaque(false);
		add(box_Edad);
		
		box_Ingresos = new JCheckBox("Ingresos");
		box_Ingresos.setFont(new Font(getName(),Font.PLAIN, 15));
		box_Ingresos.setBounds(260, 290, 100, 20);
		box_Ingresos.setActionCommand("INGRESOSINFO");
		box_Ingresos.setOpaque(false);
		add(box_Ingresos);
		
		box_LikesOt = new JCheckBox("Likes Otorgados");
		box_LikesOt.setFont(new Font(getName(),Font.PLAIN, 15));
		box_LikesOt.setBounds(260, 340, 150, 20);
		box_LikesOt.setActionCommand("LIKESOINFO");
		box_LikesOt.setOpaque(false);
		add(box_LikesOt);
		
		box_LikesRec = new JCheckBox("Likes Recibidos");
		box_LikesRec.setFont(new Font(getName(),Font.PLAIN, 15));
		box_LikesRec.setBounds(260, 390, 150, 20);
		box_LikesRec.setActionCommand("LIKESRINFO");
		box_LikesRec.setOpaque(false);
		add(box_LikesRec);
		
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

	public JCheckBox getBox_Edad1() {
		return box_Edad;
	}

	public void setBox_Edad1(JCheckBox box_Edad1) {
		this.box_Edad = box_Edad1;
	}

	public JCheckBox getBox_Ingresos1() {
		return box_Ingresos;
	}

	public void setBox_Ingresos1(JCheckBox box_Ingresos1) {
		this.box_Ingresos = box_Ingresos1;
	}

	public JCheckBox getBox_LikesOt1() {
		return box_LikesOt;
	}

	public void setBox_LikesOt1(JCheckBox box_LikesOt1) {
		this.box_LikesOt = box_LikesOt1;
	}

	public JCheckBox getBox_LikesRec1() {
		return box_LikesRec;
	}

	public void setBox_LikesRec1(JCheckBox box_LikesRec1) {
		this.box_LikesRec = box_LikesRec1;
	}

	public JButton getB_GenerarInf() {
		return b_GenerarInf;
	}

	public void setB_GenerarInf(JButton b_GenerarInf) {
		this.b_GenerarInf = b_GenerarInf;
	}

}
