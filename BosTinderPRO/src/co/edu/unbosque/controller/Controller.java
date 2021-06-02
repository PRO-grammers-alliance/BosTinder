package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.format.DateTimeParseException;


import co.edu.unbosque.model.BosTinder;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener, ItemListener{
	
	private View vista;
	private BosTinder bosT;
	
	private String fecha;
	
	public Controller() {
		vista = new View();
		bosT = new BosTinder();
		asignarOyentes();
	}
	
	public void asignarOyentes() {
		vista.getvIng().getpIngreso().getB_ingresar().addActionListener(this);
		vista.getvIng().getpIngreso().getB_registro().addActionListener(this);
		vista.getvReg().getpEdad().getB_validar().addActionListener(this);
		vista.getvReg().getpRegistro().getValidarRegistro().addActionListener(this);
		vista.getvPri().getPu().getLike().addActionListener(this);
		vista.getvPri().getPu().getDislike().addActionListener(this);
		vista.getvReg().getpRegistro().getSexoH().addActionListener(this);
		vista.getvReg().getpRegistro().getSexoM().addActionListener(this);
		vista.getvPri().getPa().getBox_ordenar().addActionListener(this);
		vista.getvPri().getPa().getB_ascendente().addActionListener(this);
		vista.getvPri().getPa().getB_descendente().addActionListener(this);
		vista.getvPri().getPa().getBox_ordenar().addItemListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			
		if(arg0.getActionCommand().equals("INGRESAR")){
			vista.mostrarMensaje(bosT.getMaFi().leerCsv().toString(),"info");
			String user = vista.getvIng().getpIngreso().getC_usuario().getText();
			char[] clave = vista.getvIng().getpIngreso().getC_clave().getPassword();
			String claveT =String.valueOf(clave);
			
			if(bosT.getValIn().comprobarLoginAdmin(user, claveT)) {
				vista.getvIng().setVisible(false);
				vista.getvPri().getPu().setVisible(false);
				vista.getvPri().getPim().setVisible(false);
				vista.getvPri().add(vista.getvPri().getPa());
				vista.getvPri().getPa().setVisible(true);
				vista.getvPri().setVisible(true);
			}else if (bosT.validarLogin(user, claveT)){
				vista.getvIng().setVisible(false);
				vista.getvPri().setVisible(true);
			}else {
				vista.getvIng().getpIngreso().getC_usuario().setText("");
				vista.getvIng().getpIngreso().getC_clave().setText("");
				vista.mostrarMensaje("Ingrese un usuario y contraseña válidos", "error");
			}
		}
		
		if(arg0.getActionCommand().equals("REGISTRO")){
			vista.getvReg().setBounds(0, 0, 300, 300);
			vista.getvReg().remove(vista.getvReg().getpRegistro());
			vista.getvReg().add(vista.getvReg().getpEdad());
			vista.getvReg().getpEdad().getAño().setText("");
			vista.getvReg().getpEdad().getMes().setText("");
			vista.getvReg().getpEdad().getDia().setText("");
			vista.getvIng().setVisible(false);
			vista.getvReg().setVisible(true);
			
		}
		
		if(arg0.getActionCommand().equals("VALIDAR")){
			String año = vista.getvReg().getpEdad().getAño().getText();
			String mes = vista.getvReg().getpEdad().getMes().getText();
			String dia = vista.getvReg().getpEdad().getDia().getText();
			fecha = dia +"/"+ mes + "/"+ año;
			try {
			if(bosT.getValIn().validadEdad(fecha)) {	
				vista.getvReg().setBounds(0, 0, 625, 429);
				vista.getvReg().remove(vista.getvReg().getpEdad());
				vista.getvReg().add(vista.getvReg().getpRegistro());
				vista.getvReg().getpRegistro().setVisible(true);
			}else{
				vista.mostrarMensaje("Debe ser mayor de edad"+"\n"+"para poder usar BosTinder"+ "\n"+"Hasta pronto", "error");
				vista.getvReg().setVisible(false);
				vista.getvIng().setVisible(true);
			}
			}catch(DateTimeParseException e) {
				vista.mostrarMensaje("Ingrese fecha válida DD/MM/YYYY", "error");
				vista.getvReg().getpEdad().getAño().setText("");
				vista.getvReg().getpEdad().getMes().setText("");
				vista.getvReg().getpEdad().getDia().setText("");
			}
		}

		if(arg0.getActionCommand().equals("VALIDARREGISTRO")) {
			vista.getvReg().setVisible(false);
			vista.getvIng().setVisible(true);
		}
		
		if(arg0.getActionCommand().equals("LIKE")) {
			
		}
		
		if(arg0.getActionCommand().equals("NOLIKE")) {
			
		}

		if(arg0.getActionCommand().equals("ORDENAR")) {
		}
		
		if(arg0.getActionCommand().equals("ASCENDENTE")) {
			if(vista.getvPri().getPa().getB_ascendente().isSelected()) {
				vista.getvPri().getPa().getB_descendente().setSelected(false);
			}else if(!vista.getvPri().getPa().getB_ascendente().isSelected()) {
				vista.getvPri().getPa().getB_descendente().setSelected(true);
			}
		}
		
		if(arg0.getActionCommand().equals("DESCENDENTE")) {
			if(vista.getvPri().getPa().getB_descendente().isSelected()) {
				vista.getvPri().getPa().getB_ascendente().setSelected(false);
			}else if(!vista.getvPri().getPa().getB_descendente().isSelected()) {
				vista.getvPri().getPa().getB_ascendente().setSelected(true);
			}
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getItem().equals("Nombre")) {
			vista.getvPri().getPa().getT_info().setText("Nombre");
		}
	}
}
