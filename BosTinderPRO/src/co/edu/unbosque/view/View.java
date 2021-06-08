package co.edu.unbosque.view;


import javax.swing.JOptionPane;

public class View {

	private VentanaIngreso vIng;
	private VentanaEdad vEdad;
	private VentanaRegistro vReg;
	private VentanaPrincipal vPri;
	private VentanaAdmin vAdm;
	private String ruta;
	
	public View(){
		vIng = new VentanaIngreso();
		vEdad = new VentanaEdad();
		vReg = new VentanaRegistro();
		vPri = new VentanaPrincipal();
		vAdm = new VentanaAdmin(); 
	}
	
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
