package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.format.DateTimeParseException;


import co.edu.unbosque.model.BosTinder;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener{
	
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
		vista.getvAdm().getPConsul().getBox_ordenar().addActionListener(this);
		vista.getvAdm().getPConsul().getB_ascendente().addActionListener(this);
		vista.getvAdm().getPConsul().getB_descendente().addActionListener(this);
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
				vista.getvAdm().setVisible(true);
			}else if (bosT.validarLogin(user, claveT)){
				vista.getvIng().setVisible(false);
				vista.getvPri().setVisible(true);
			}else {
				vista.getvIng().getpIngreso().getC_usuario().setText("");
				vista.getvIng().getpIngreso().getC_clave().setText("");
				vista.mostrarMensaje("Ingrese un usuario y contrase�a v�lidos", "error");
			}
		}
		
		if(arg0.getActionCommand().equals("REGISTRO")){
			vista.getvReg().setBounds(0, 0, 300, 300);
			vista.getvReg().remove(vista.getvReg().getpRegistro());
			vista.getvReg().add(vista.getvReg().getpEdad());
			vista.getvReg().getpEdad().getA�o().setText("");
			vista.getvReg().getpEdad().getMes().setText("");
			vista.getvReg().getpEdad().getDia().setText("");
			vista.getvIng().setVisible(false);
			vista.getvReg().setVisible(true);
			
		}
		
		if(arg0.getActionCommand().equals("VALIDAR")){
			String a�o = vista.getvReg().getpEdad().getA�o().getText();
			String mes = vista.getvReg().getpEdad().getMes().getText();
			String dia = vista.getvReg().getpEdad().getDia().getText();
			fecha = dia +"/"+ mes + "/"+ a�o;
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
				vista.mostrarMensaje("Ingrese fecha v�lida DD/MM/YYYY", "error");
				vista.getvReg().getpEdad().getA�o().setText("");
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
			String item = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
			if(item.equals("Nombre")) {
				vista.getvAdm().getPConsul().getT_info().setText("Nombres");
			} else if(item.equals("Apellido")) {
				vista.getvAdm().getPConsul().getT_info().setText("Apellidos");
			} else if(item.equals("Edad")) {
				vista.getvAdm().getPConsul().getT_info().setText("Edades");
			} else if(item.equals("Alias")) {
				vista.getvAdm().getPConsul().getT_info().setText("Alias");
			} else if(item.equals("N�mero Likes")) {
				vista.getvAdm().getPConsul().getT_info().setText("N�meros Likes");
			} 
		}
		
		if(arg0.getActionCommand().equals("ASCENDENTE")) {
			if(vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_descendente().setSelected(false);
			}else if(!vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_descendente().setSelected(true);
			}
		}
		
		if(arg0.getActionCommand().equals("DESCENDENTE")) {
			if(vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_ascendente().setSelected(false);
			}else if(!vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_ascendente().setSelected(true);
			}
		}
		
	}

}
