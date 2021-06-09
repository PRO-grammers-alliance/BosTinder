package co.edu.unbosque.view;


import javax.swing.JOptionPane;

/**
 * Esta clase permite la comunicacion del controller con las demas clases de la interfaz grafica.
 * @author FELIPE SEGURA
 * @author David Real
 * @author Oscar Florez
 * @author Santiago Zamora
 *
 */
public class View {

	/**
	 * Objeto de tipo VentanaIngreso que permite la introduccion de usuario, contraseña .
	 */
	private VentanaIngreso vIng;
	/**
	 * Objeto de tipo VentanaEdad para la validacion de edad.
	 */
	private VentanaEdad vEdad;
	/**
	 * Objeto de tipo VentanaRegistro para el ingreso de daros necesario para el registro.
	 */
	private VentanaRegistro vReg;
	/**
	 * Objeto de tipo VentanaPrincipal para la interaccion del usuario con el programa.
	 */
	private VentanaPrincipal vPri;
	/**
	 * Objeto de tipo VentanaAdmin para administrar el programa.
	 */
	private VentanaAdmin vAdm;
	
	/**
	 * Método constructor.
	 */
	public View(){
		vIng = new VentanaIngreso();
		vEdad = new VentanaEdad();
		vReg = new VentanaRegistro();
		vPri = new VentanaPrincipal();
		vAdm = new VentanaAdmin(); 
	}
	
	/**
	 * método para mostrar un mensaje por JOptionPane
	 * @param mensaje
	 * @param tipo
	 */
	 public void mostrarMensaje(String mensaje, String tipo) {
		 if(tipo == "info") {
			 JOptionPane.showMessageDialog(null, mensaje, "BosTinder", JOptionPane.INFORMATION_MESSAGE);
		 }else if(tipo == "error") {
			 JOptionPane.showMessageDialog(null, mensaje, "BosTinder", JOptionPane.ERROR_MESSAGE);
		 }
	}

	public VentanaIngreso getvIng() {
		return vIng;
	}

	public void setvIng(VentanaIngreso vIng) {
		this.vIng = vIng;
	}

	public VentanaEdad getvEdad() {
		return vEdad;
	}

	public void setvEdad(VentanaEdad vEdad) {
		this.vEdad = vEdad;
	}

	public VentanaRegistro getvReg() {
		return vReg;
	}

	public void setvReg(VentanaRegistro vReg) {
		this.vReg = vReg;
	}

	public VentanaPrincipal getvPri() {
		return vPri;
	}

	public void setvPri(VentanaPrincipal vPri) {
		this.vPri = vPri;
	}

	public VentanaAdmin getvAdm() {
		return vAdm;
	}

	public void setvAdm(VentanaAdmin vAdm) {
		this.vAdm = vAdm;
	}

	 
	
}
