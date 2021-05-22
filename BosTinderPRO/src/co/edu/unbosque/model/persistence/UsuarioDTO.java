package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = -3454983834468203527L;
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String sexo;
	private String usuario;
	private String contraseña;
	private String correo;
	private String nascimiento;
	private int edad;
	private double ingresos;
	private String divorcios;
	private int numLikesRecibidos;
	private int numLikesOrtorgados;
	private int numMatches;
	private String estado;
	
	public UsuarioDTO(int id, String nombre, String apellido1, String apellido2, String sexo, String usuario,
			String contraseña, String correo, String nascimiento, int edad, double ingresos, String divorcios,
			int numLikesRecibidos, int numLikesOtorgados, int numMatches, String estado) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.correo = correo;
		this.nascimiento = nascimiento;
		this.edad = edad;
		this.ingresos = ingresos;
		this.divorcios = divorcios;
		this.numLikesRecibidos = numLikesRecibidos;
		this.numLikesOrtorgados = numLikesOtorgados;
		this.numMatches = numMatches;
		this.estado = estado;
		
	}

	public String toString() {
		return "Id:"+this.id+"\nNombre:"+this.nombre+"\nApellido 1:"+this.apellido1+"\nApellido 2:"+this.apellido2
				+"\nSexo:"+this.sexo+"\nUsuario:"+this.usuario+"\nContraseña:"+this.contraseña+"\nCorreo:"+this.correo
				+"\nNascimiento:"+this.nascimiento+"\nEdad:"+this.edad+"\nIngresos:"+this.ingresos+"\nDivorcios:"+this.divorcios
				+"\nNúmero likes Recibidos:"+this.numLikesRecibidos+"\nNúmero likes Otorgados:"+this.numLikesOrtorgados
				+"\nMatches:"+this.numMatches+"\nEstado:"+this.estado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNascimiento() {
		return nascimiento;
	}

	public void setNascimiento(String nascimiento) {
		this.nascimiento = nascimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	public String getDivorcios() {
		return divorcios;
	}

	public void setDivorcios(String divorcios) {
		this.divorcios = divorcios;
	}

	public int getNumLikesRecibidos() {
		return numLikesRecibidos;
	}

	public void setNumLikesRecibidos(int numLikesRecibidos) {
		this.numLikesRecibidos = numLikesRecibidos;
	}

	public int getNumLikesOrtorgados() {
		return numLikesOrtorgados;
	}

	public void setNumLikesOrtorgados(int numLikesOrtorgados) {
		this.numLikesOrtorgados = numLikesOrtorgados;
	}

	public int getNumMatches() {
		return numMatches;
	}

	public void setNumMatches(int numMatches) {
		this.numMatches = numMatches;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
