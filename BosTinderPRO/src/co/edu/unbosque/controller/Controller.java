package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

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
		vista.getvReg().getpRegistro().getB_validar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			
		if(arg0.getActionCommand().equals("INGRESAR")){
			vista.getvPri().getPim().setIm(new  ImageIcon(getClass().getResource("/imagenes/b2.jpg")));
		}
		
		
		if(arg0.getActionCommand().equals("REGISTRO")){
		
		}
		
		if(arg0.getActionCommand().equals("VALIDAR")){
			
		}

	}
}
