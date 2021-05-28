package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ValidacionesInicio {

	public ValidacionesInicio() {
		
		
	}
	
	public boolean validadEdad(String fecha) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nacim = LocalDate.parse(fecha,formato);
		Period edad = Period.between(nacim, LocalDate.now());
		if(edad.getYears()>=18) {
			return true;
		}else{
			return false;
		}
	}
	
	
}
