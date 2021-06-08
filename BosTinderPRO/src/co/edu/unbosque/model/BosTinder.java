package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ManejoFile;

public class BosTinder {

	private ValidacionesInicio valIn;
	private ManejoFile maFi;
	private Email mail;
	private Estadisticas estad;
	private OpCRUD crud;

	private ArrayList<Integer> randoms;
	private int posicionU;

	public BosTinder() {

		valIn = new ValidacionesInicio();
		maFi = new ManejoFile();
		mail = new Email();
		randoms = new ArrayList<>();
		estad = new Estadisticas();
		crud = new OpCRUD();
	}

	/**
	 * Método que compara el login ingresado con la base de datos
	 * 
	 * @param user
	 * @param clave
	 * @return
	 */
	
	public boolean validarLogin(String user, String clave) {
		boolean validar = false;
		int tamBD = maFi.getId().size();
		for (int i = 1; i < tamBD; i++) {
			String userBD = maFi.getUsuario().get(i);
			String claveBD = maFi.getContraseña().get(i);
			validar = valIn.comprobarLoginUser(user, clave, userBD, claveBD);
			if (validar) {
				posicionU = i;
				i = tamBD;
			}
		}
		return validar;
	}

	/**
	 * Metodo que se utiliza par añadir un nuevo usuario a la base de datos
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param sexo
	 * @param user
	 * @param contraseña
	 * @param correo
	 * @param nacimiento
	 * @param edad
	 * @param ingresos
	 * @param divorcios
	 * @param likesR
	 * @param likesO
	 * @param estatura
	 * @param matches
	 * @param estado
	 */
	public void añadirUsuario(int id, String nombre, String apellido1, String apellido2, String sexo, String user,
			String contraseña, String correo, String nacimiento, int edad, double ingresos, String divorcios,
			int likesR, int likesO, int estatura, int matches, String estado) {
		maFi.getId().add(id);
		maFi.getNombre().add(nombre);
		maFi.getApellido1().add(apellido1);
		maFi.getApellido2().add(apellido2);
		maFi.getSexo().add(sexo);
		maFi.getUsuario().add(user);
		maFi.getContraseña().add(contraseña);
		maFi.getCorreo().add(correo);
		maFi.getNacimiento().add(nacimiento);
		maFi.getEdad().add(edad);
		maFi.getIngresos().add(ingresos);
		maFi.getDivorcios().add(divorcios);
		maFi.getNumeroLikesRecibidos().add(likesR);
		maFi.getNumeroLikesOtorgados().add(likesO);
		maFi.getNumeroMatches().add(matches);
		maFi.getEstatura().add(estatura);
		maFi.getEstado().add(estado);
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
	public String validacionR(String nombre, String apellido1, String apellido2, String user, String contraseña,
			String contraseña1, String correo, String correo1, int estatura, double ingresos) {
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

		if (!contraseña.equals(contraseña1)) {
			error = "error3";
		}
		for (int i = 0; i < correo.length(); i++) {
			if (correo.charAt(i) == '@') {
				if (!correo.equals(correo1)) {
					error = "error4";
				}
			}
		}
		return error;
	}

	/**
	 * Metodo que genera un numero ramdom que sera utilizado para mostrar los usuarios a quien ingrese a la plataforma.
	 * @param tam
	 * @return
	 */
	public int usuarioRandom(int tam) {
		int num;
		int contador;
		do {
			contador=0;
			num = (int) Math.round(Math.random() * tam);
			for (int i = 0; i < randoms.size(); i++) {
				if (randoms.get(i).equals(num) || num == posicionU) {
					contador++;
					i=randoms.size();
				}
			}
		} while (contador == 1);
		randoms.add(num);

		return num;
	}
	
	public int usuarioRandom() {
		int num;
		num = (int) Math.round(Math.random() * 2);
		return num;
	}

	public Estadisticas getEstad() {
		return estad;
	}

	public void setEstad(Estadisticas estad) {
		this.estad = estad;
	}

	public ArrayList<Integer> getRandoms() {
		return randoms;
	}

	public void setRandoms(ArrayList<Integer> randoms) {
		this.randoms = randoms;
	}

	public int getPosicionU() {
		return posicionU;
	}

	public void setPosicionU(int posicionU) {
		this.posicionU = posicionU;
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

	public Email getMail() {
		return mail;
	}

	public void setMail(Email mail) {
		this.mail = mail;
	}

	public OpCRUD getCrud() {
		return crud;
	}

	public void setCrud(OpCRUD crud) {
		this.crud = crud;
	}
}
