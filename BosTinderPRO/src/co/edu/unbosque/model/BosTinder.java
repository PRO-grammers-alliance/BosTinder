package co.edu.unbosque.model;

public class BosTinder {

	private ValidacionesInicio valIn;
	
	public BosTinder () {
		
		valIn = new ValidacionesInicio();
		
	}

	public ValidacionesInicio getValIn() {
		return valIn;
	}

	public void setValIn(ValidacionesInicio valIn) {
		this.valIn = valIn;
	}
	
}
