package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;

public class Estadisticas {

	private int  media;
	private double mediana;
	
	public Estadisticas() {
		
	}
	/**
	 * Metodo que mide la media aricmetica de los datos enviados a el.
	 * @param dato
	 * @return
	 */
	public int media(ArrayList<Integer> dato) {
		for(int i = 0; i<dato.size();i++) {
			media+=dato.get(i);
		}
		media = media/dato.size();
		return media;
	}
	
	/**
	 * metodo que devuelve la mediana de los datos enviadoa a el.
	 * @param dato
	 * @return
	 */
	public double mediana(ArrayList<Integer> dato) {
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
	
	public ArrayList<Integer> modaInt(ArrayList<Integer> dato) {
		ArrayList<Integer> moda = new ArrayList<>();
		moda.add(0);
		Collections.sort(dato);
		int contador = 0;
		int contadorMax = 0;
		int num=0;
		for(int i=0;i<dato.size();i+=contador) {
			contador = 0;
			num=dato.get(i);
			for (int j = i; j < dato.size(); j++) {
				if(num==dato.get(j)) {
					contador++;
				}else{
					j=dato.size();
				}
			}
			if(contadorMax<=contador) {
				if(moda.get(0)<num && contadorMax==contador) {
					moda.add(num);
				}else{
					moda.clear();
					moda.add(num);
				}
				contadorMax=contador;
			}
		}
		return moda;
	}
	
	public ArrayList<Double> modaDouble(ArrayList<Double> dato) {
		ArrayList<Double> moda = new ArrayList<>();
		moda.add(0.0);
		Collections.sort(dato);
		int contador = 0;
		int contadorMax = 0;
		Double num=0.0;
		for(int i=0;i<dato.size();i+=contador) {
			contador = 0;
			num=dato.get(i);
			for (int j = i; j < dato.size(); j++) {
				if(num.equals(dato.get(j))) {
					contador++;
				}else{
					j=dato.size();
				}
			}
			if(contadorMax<=contador) {
				if(moda.get(0)<num && contadorMax==contador) {
					moda.add(num);
				}else{
					moda.clear();
					moda.add(num);
				}
				contadorMax=contador;
			}
		}
		return moda;
	}
}
