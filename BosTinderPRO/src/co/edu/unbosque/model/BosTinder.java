package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ManejoFile;

public class BosTinder {

	private ValidacionesInicio valIn;
	private ManejoFile maFi;
	
	public BosTinder () {
		
		valIn = new ValidacionesInicio();
		maFi = new ManejoFile();
		
		
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
	
	
}
