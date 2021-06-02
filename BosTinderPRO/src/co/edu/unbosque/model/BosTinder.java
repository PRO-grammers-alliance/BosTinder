package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ManejoFile;
import co.edu.unbosque.model.persistence.UsuarioDAO;

public class BosTinder {

	private ValidacionesInicio valIn;
	private ManejoFile maFi;
	private UsuarioDAO usDao;

	public BosTinder() {

		valIn = new ValidacionesInicio();
		maFi = new ManejoFile();
		usDao = new UsuarioDAO();

	}

	public boolean validarLogin(String user, String clave) {
		boolean validar = false;
		int tamBD = maFi.getId().size();
		for (int i = 1; i < tamBD; i++) {
			String userBD = maFi.getUsuario().get(i);
			String claveBD = maFi.getContraseña().get(i);
			validar = valIn.comprobarLoginUser(user, clave, userBD, claveBD);
			if (validar) {
				i = tamBD;
			}
		}
		return validar;
	}

	/**
	 * Este metodo se utiliza para validar la informacion ingresada por el usuario
	 * al momento del registro.
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param user
	 * @param correo
	 * @param correo2
	 * @return
	 */
	public String validacionR(String nombre, String apellido1, String apellido2, String user, String contraseña,String contraseña1,String correo,String correo1, int estatura,double ingreos) {
		String error = "no";
		for (int i = 0; i < nombre.length(); i++) {
			if (nombre.charAt(i) == '0' || nombre.charAt(i) == '1' || nombre.charAt(i) == '2' || nombre.charAt(i) == '3'
					|| nombre.charAt(i) == '4' || nombre.charAt(i) == '5' || nombre.charAt(i) == '6'
					|| nombre.charAt(i) == '7' || nombre.charAt(i) == '8' || nombre.charAt(i) == '9') {
				error = "error1";
			}
		}
		for (int i = 0; i < apellido1.length(); i++) {
			if (apellido1.charAt(i) == '0' || apellido1.charAt(i) == '1' || apellido1.charAt(i) == '2'
					|| apellido1.charAt(i) == '3' || apellido1.charAt(i) == '4' || apellido1.charAt(i) == '5'
					|| apellido1.charAt(i) == '6' || apellido1.charAt(i) == '7' || apellido1.charAt(i) == '8'
					|| apellido1.charAt(i) == '9') {
				error = "error1";
			}
		}
		for (int i = 0; i < apellido2.length(); i++) {
			if (apellido2.charAt(i) == '0' || apellido2.charAt(i) == '1' || apellido2.charAt(i) == '2'
					|| apellido2.charAt(i) == '3' || apellido2.charAt(i) == '4' || apellido2.charAt(i) == '5'
					|| apellido2.charAt(i) == '6' || apellido2.charAt(i) == '7' || apellido2.charAt(i) == '8'
					|| apellido2.charAt(i) == '9') {
				error = "error1";
			}
		}
		for (int i = 0; i < maFi.getUsuario().size(); i++) {
			if (user.equals(maFi.getUsuario().get(i))) {
				error = "error2";
			}
		}
		
		if(!contraseña.equals(contraseña1)) {
			error= "error3";
		}
		int contador=0;
		for (int i = 0; i < apellido1.length(); i++) {
			if (correo.charAt(i) == '@') {
				contador++;
				if(!correo.equals(correo1)) {
				error = "error4";
				}
			}
		}
		/*if(contador!=1) {
			error="error5";
		}*/
		
		return error;
	}

	public ValidacionesInicio getValIn() {
		return valIn;
	}

	public void setValIn(ValidacionesInicio valIn) {
		this.valIn = valIn;
	}

	public ManejoFile getMaFi() {
		return maFi;
	}

	public void setMaFi(ManejoFile maFi) {
		this.maFi = maFi;
	}

	public UsuarioDAO getUsDao() {
		return usDao;
	}

	public void setUsDao(UsuarioDAO usDao) {
		this.usDao = usDao;
	}

}
