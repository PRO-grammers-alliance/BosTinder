package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ValidacionesInicio {

	private int edad1;
	
	public ValidacionesInicio() {
		
	}
	
	public boolean comprobarLoginAdmin(String user, String clave) {
		boolean comprobar= false;
		if (user.equals("admin") && clave.equals("1234")){
			comprobar=true;
		}
		return comprobar;
	}
	
	
	public boolean validadEdad(String fecha) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nacim = LocalDate.parse(fecha,formato);
		Period edad = Period.between(nacim, LocalDate.now());
		edad1=edad.getYears();
		if(edad.getYears()>=18) {
			return true;
		}else{
			return false;
		}
	}


	public int getEdad1() {
		return edad1;
	}


	public void setEdad1(int edad1) {
		this.edad1 = edad1;
	}
	
	
}
