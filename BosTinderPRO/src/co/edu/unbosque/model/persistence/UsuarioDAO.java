package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class UsuarioDAO {
	private ArrayList<UsuarioDTO> usuario ;
	private String rutaReg = "./data/Usuarios.txt";
	
	public UsuarioDAO() {
		usuario = new ArrayList<>();
	}
	
	public void crearUsuario(int id, String nombre, String apellido1, String apellido2, String sexo, String user, String contraseña, String correo, String nacimineto, int edad, double ingresos, String divircios, int likesR, int likesO,int maches, String estado) {
		usuario.add(new UsuarioDTO( id, nombre, apellido1, apellido2, sexo, user, contraseña, correo, nacimineto, edad, ingresos, divircios, likesR, likesO, maches, estado));
		
	}
	public void eliminarEmpleado(UsuarioDTO usuarios) {
		usuario.remove(usuarios.getId());
		System.out.println("Empleado "+usuarios.getId()+" eliminado satisfactoriamente");
	}
	
	public ArrayList<UsuarioDTO> obtenerEmpleado(){
		return usuario;
	}
	
	public UsuarioDTO obtenerEmpleado(int id) {
		return usuario.get(id-1);
	}
	
	public void actualizarEmpleado(UsuarioDTO usuarios) {
		usuario.get(usuarios.getId()).setNombre(usuarios.getNombre());
		usuario.get(usuarios.getId()).setApellido1(usuarios.getApellido1());
		usuario.get(usuarios.getId()).setApellido2(usuarios.getApellido2());
		usuario.get(usuarios.getId()).setSexo(usuarios.getSexo());
		usuario.get(usuarios.getId()).setUsuario(usuarios.getUsuario());
		usuario.get(usuarios.getId()).setContraseña(usuarios.getContraseña());
		usuario.get(usuarios.getId()).setCorreo(usuarios.getCorreo());
		usuario.get(usuarios.getId()).setNacimiento(usuarios.getNacimiento());
		usuario.get(usuarios.getId()).setEdad(usuarios.getEdad());
		usuario.get(usuarios.getId()).setIngresos(usuarios.getIngresos());
		usuario.get(usuarios.getId()).setDivorcios(usuarios.getDivorcios());
		usuario.get(usuarios.getId()).setNumLikesRecibidos(usuarios.getNumLikesRecibidos());
		usuario.get(usuarios.getId()).setNumLikesOrtorgados(usuarios.getNumLikesOrtorgados());
		usuario.get(usuarios.getId()).setNumMatches(usuarios.getNumMatches());
		usuario.get(usuarios.getId()).setEstado(usuarios.getEstado());
		System.out.println("Cliente id: "+ usuarios.getId()+" actualizado satisfactoriamente");		
	}

	public ArrayList<UsuarioDTO> getUsuario() {
		return usuario;
	}

	public void setUsuario(ArrayList<UsuarioDTO> usuario) {
		this.usuario = usuario;
	}

	public String getRutaReg() {
		return rutaReg;
	}

	public void setRutaReg(String rutaReg) {
		this.rutaReg = rutaReg;
	}

}
