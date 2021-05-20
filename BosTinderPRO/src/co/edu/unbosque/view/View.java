package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	private VentanaIngreso vIng;
	private VentanaRegistro vReg;
	
	public View(){
		
		vIng = new VentanaIngreso();
		vReg = new VentanaRegistro();
		
	}
	
	 public static void mostrarProblematica(String[] args) {
	       JOptionPane.showMessageDialog(null, "Debe ser mayor de edad"+"\n"+"para poder usar BosTinder"+ "\n"+"Hasta pronto");
	}

	public VentanaIngreso getvIng() {
		return vIng;
	}

	public void setvIng(VentanaIngreso vIng) {
		this.vIng = vIng;
	}

	public VentanaRegistro getvReg() {
		return vReg;
	}

	public void setvReg(VentanaRegistro vReg) {
		this.vReg = vReg;
	}
	
}
