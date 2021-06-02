package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ManejoFile;
import co.edu.unbosque.model.persistence.UsuarioDAO;

public class BosTinder {

	private ValidacionesInicio valIn;
	private ManejoFile maFi;
	private UsuarioDAO usDao;
	
	public BosTinder () {
		
		valIn = new ValidacionesInicio();
		maFi = new ManejoFile();
		usDao = new UsuarioDAO();
		
	}

	public boolean validarLogin(String user, String clave) {
		boolean validar = false;
		int tamBD=maFi.getId().size();
		for(int i=1;i<tamBD;i++) {
			String userBD = maFi.getUsuario().get(i);
			String claveBD = maFi.getContraseña().get(i);
			validar=valIn.comprobarLoginUser(user, clave, userBD, claveBD);
			if(validar) {
				i=tamBD;
			}
		}
		return validar;
	}
	
	public int usuarioRandom(int tam) {
		int num;
		num = (int)Math.round(Math.random()*tam);
		return num;
	}
	
	
	/*public String validacionR(String nombre, String apellido1, String apellido2,String user,String correo,String correo2) {
		String error ="";
		
		return error;
	}*/
	
	
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
