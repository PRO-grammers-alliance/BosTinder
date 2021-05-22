package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import co.edu.unbosque.view.View;

public class Controller implements ActionListener{
	
	private View vista;
	
	public Controller() {
		vista = new View();
		
			asignarOyentes();
	}
	
	public void asignarOyentes() {
		vista.getvIng().getpIngreso().getB_ingresar().addActionListener(this);
		vista.getvIng().getpIngreso().getB_registro().addActionListener(this);
		vista.getvReg().getpEdad().getB_validar().addActionListener(this);
		vista.getvPri().getPu().getLike().addActionListener(this);
		vista.getvPri().getPu().getDislike().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			
		if(arg0.getActionCommand().equals("INGRESAR")){
			vista.getvIng().setVisible(false);
			vista.getvPri().setVisible(true);
		}
		
		if(arg0.getActionCommand().equals("REGISTRO")){
			vista.getvIng().setVisible(false);
			vista.getvReg().setVisible(true);
		}
		
		if(arg0.getActionCommand().equals("VALIDAR")){
			vista.getvReg().setBounds(0, 0, 625, 429);
			vista.getvReg().remove(vista.getvReg().getpEdad());
			vista.getvReg().add(vista.getvReg().getpRegistro());
			vista.getvReg().getpRegistro().setVisible(true);
			
		}
		
		if(arg0.getActionCommand().equals("LIKE")) {
			
		}
		
		if(arg0.getActionCommand().equals("NOLIKE")) {
			
		}

	}
}
