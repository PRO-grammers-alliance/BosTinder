package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ValidacionesInicio {

	private int edad1;
	
	public ValidacionesInicio() {
		
	}
	/**
	 * Método que valida el login del Administrador
	 * 
	 * @param user
	 * @param clave
	 * @return
	 */
	public boolean comprobarLoginAdmin(String user, String clave) {
		boolean comprobar= false;
		if (user.equals("admin") && clave.equals("1234")){
			comprobar=true;
		}
		return comprobar;
	}
	/**
	 * Método que valida el login del usuario
	 * 
	 * @param user
	 * @param clave
	 * @param userBD
	 * @param claveBD
	 * @return
	 */
	public boolean comprobarLoginUser(String user, String clave, String userBD, String claveBD) {
		boolean comprobar= false;
		if (user.equals(userBD) && clave.equals(claveBD)){
			comprobar=true;
		}
		return comprobar;
	}
	
	/**
	 * Método que valida la edad ingresada en el registro
	 * 
	 * @param fecha
	 * @return
	 */
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
