package co.edu.unbosque.view;

public class View {

	private VentanaIngreso vIng;
	private VentanaRegistro vReg;
	
	public View(){
		
		vIng = new VentanaIngreso();
		vReg = new VentanaRegistro();
		
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
