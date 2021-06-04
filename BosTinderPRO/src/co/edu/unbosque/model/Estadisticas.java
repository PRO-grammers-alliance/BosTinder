package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;

public class Estadisticas {

	private int  media;
	private int mediana;
	
	public Estadisticas() {
		
	}
	
	public int media(ArrayList<Integer> dato) {
		for(int i = 0; i<dato.size();i++) {
			media+=dato.get(i);
		}
		media = media/dato.size();
		return media;
	}
	
	public int mediana(ArrayList<Integer> dato) {
		Collections.sort(dato);
		if(dato.size()%2==0) {
			int mitad =dato.size()/2;
			int mitaduno = mitad+1;
			mediana= (dato.get(mitad)+dato.get(mitaduno))/2;
		}else if(dato.size()%2!=0) {
			int mitad =dato.size()/2;
			mediana = dato.get(mitad);
		}
		return mediana;
	}
}
