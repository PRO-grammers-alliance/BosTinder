package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Clase del modelo que consta de 4 métodos, el constructor y tres de tipo boolean
 * Se encarga de las validaciónes que se hacen para ingresar y para iniciar el registro
 * 
 * @author Felipe Segura
 * @author David Real
 * @author Oscar Florez
 * @author Santiago Zamora
 *
 */

public class ValidacionesInicio {

	/**
	 * Objeto de tipo int que permite guardar un número entero
	 */
	private int edad1;
	
	/**
	 * Método Constructor de la clase ValidacionesInicio 
	 */
	public ValidacionesInicio() {
	}
	
	/**
	 * Método que valida el login del Administrador
	 * 
	 * @param user
	 * @param clave
	 * @return <ul>
	 * 			<li>True:si el valor de la variable comprobar es True
	 * 			<li>False:si el valor de la variable comprobar es False
	 * 		   </ul>
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
	 * @return <ul>
	 * 			<li>True:si el valor de la variable comprobar es True
	 * 			<li>False:si el valor de la variable comprobar es False
	 * 		   </ul>
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
	 * @return <ul>
	 * 			<li>True:si el valor de la variable edad1 es mayor o igual a 18 
	 * 			<li>False:si el valor de la variable edad1 no es mayor o igual a 18
	 * 		   </ul>
	 */
	public boolean validadEdad(String fecha) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nacim = LocalDate.parse(fecha,formato);
		Period edad = Period.between(nacim, LocalDate.now());
		edad1=edad.getYears();
		if(edad1>=18) {
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
