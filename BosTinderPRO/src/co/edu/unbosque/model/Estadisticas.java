package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 * Esta clase genera la informacion sobre medidas de tendencia central asi como lo nesesario para los graficos.
 * @author FELIPE SEGURA
 * @author David Real
 *
 */
public class Estadisticas {

	/**
	 * Objeto de tipo Double que representa la la tendencia central conocida como media.
	 */
	private double media;
	/**
	 * Objeto de tipo Double que representa la la tendencia central conocida como mediana.
	 */
	private double mediana;

	public Estadisticas() {

	}

	/**
	 * M?todo que mide la media aritm?tica de los datos enviados a ?l.
	 * 
	 * @param dato
	 * @return double medida de tendencia central.
	 */
	public double media(ArrayList<Integer> dato) {
		for (int i = 0; i < dato.size(); i++) {
			media += dato.get(i);
		}
		media = media / dato.size();
		return media;
	}
	
	/**
	 * M?todo que mide la media aritm?tica de los datos enviados a ?l.
	 * 
	 * @param dato
	 * @returndouble medida de tendencia central.
	 */
	public double mediaDouble(ArrayList<Double> dato) {
		for (int i = 0; i < dato.size(); i++) {
			media += dato.get(i);
		}
		media = media / dato.size();
		return media;
	}

	/**
	 * M?todo que devuelve la mediana de los datos enviados a ?l.
	 * 
	 * @param dato
	 * @return double medida de tendencia central.
	 */
	public double mediana(ArrayList<Integer> dato) {
		Collections.sort(dato);
		if (dato.size() % 2 == 0) {
			int mitad = dato.size() / 2;
			int mitaduno = mitad + 1;
			mediana = (dato.get(mitad) + dato.get(mitaduno)) / 2;
		} else if (dato.size() % 2 != 0) {
			int mitad = dato.size() / 2;
			mediana = dato.get(mitad);
		}
		return mediana;
	}
	
	/**
	 * M?todo que devuelve la mediana de los datos con datos Double   enviados a ?l. 
	 * @param dato
	 * @return double medida de tendencia central.
	 */
	public double medianaDouble(ArrayList<Double> dato) {
		Collections.sort(dato);
		if (dato.size() % 2 == 0) {
			int mitad = dato.size() / 2;
			int mitaduno = mitad + 1;
			mediana = (dato.get(mitad) + dato.get(mitaduno)) / 2;
		} else if (dato.size() % 2 != 0) {
			int mitad = dato.size() / 2;
			mediana = dato.get(mitad);
		}
		return mediana;
	}

	/**
	 * M?todo que calcula la moda del arraylist con datos Int pasado por par?metro 
	 * 
	 * @param dato
	 * @return ArrayList<Integer> medida de tendencia central (modal o bimodal).
	 */
	
	public ArrayList<Integer> modaInt(ArrayList<Integer> dato) {
		ArrayList<Integer> moda = new ArrayList<>();
		moda.add(0);
		Collections.sort(dato);
		int contador = 0;
		int contadorMax = 0;
		int num = 0;
		for (int i = 0; i < dato.size(); i += contador) {
			contador = 0;
			num = dato.get(i);
			for (int j = i; j < dato.size(); j++) {
				if (num == dato.get(j)) {
					contador++;
				} else {
					j = dato.size();
				}
			}
			if (contadorMax <= contador) {
				if (moda.get(0) < num && contadorMax == contador) {
					moda.add(num);
				} else {
					moda.clear();
					moda.add(num);
				}
				contadorMax = contador;
			}
		}
		return moda;
	}

	/**
	 * M?todo que calcula la moda del arraylist con datos Double pasado por par?metro
	 * 
	 * @param dato
	 * @return ArrayList<Double> medida de tendencia central (modal o bimodal).
	 */
	
	public ArrayList<Double> modaDouble(ArrayList<Double> dato) {
		ArrayList<Double> moda = new ArrayList<>();
		moda.add(0.0);
		Collections.sort(dato);
		int contador = 0;
		int contadorMax = 0;
		Double num = 0.0;
		for (int i = 0; i < dato.size(); i += contador) {
			contador = 0;
			num = dato.get(i);
			for (int j = i; j < dato.size(); j++) {
				if (num.equals(dato.get(j))) {
					contador++;
				} else {
					j = dato.size();
				}
			}
			if (contadorMax <= contador) {
				if (moda.get(0) < num && contadorMax == contador) {
					moda.add(num);
				} else {
					moda.clear();
					moda.add(num);
				}
				contadorMax = contador;
			}
		}
		return moda;
	}
	/**
	 * Seg?n el parametro que se pida el m?todo regresa otro arreglo en el cual se va a mostrar cuantas veces se repite cada dato
	 * @param dato
	 * @return ArrayList<String> nos permite observar cuantas veces se repiten los datos.
	 */
	public ArrayList<String> repetidos_Datos(ArrayList<Integer> dato){
		ArrayList<String> arreglo = new ArrayList<>();
		Collections.sort(dato);
		int repetidos = 0;
		int m = 0;
		for(int i = 0; i<dato.size();i++) {
			for(int j = i;j<dato.size();j++) {
				if(dato.get(i).equals(dato.get(j))) {
					repetidos++;
					m = repetidos-1;
					
				}else if(!dato.get(i).equals(dato.get(j)) ) {
					arreglo.add(repetidos+";"+dato.get(i));
					i += m;
					j=dato.size();
					repetidos = 0;
				}  
				
				if (dato.size()-j==1) {
					arreglo.add(repetidos+";"+dato.get(i));
					i=dato.size();
					
				}
			}
		}
		return arreglo;
	}
	
	/**
	 * Seg?n el parametro que se pida el m?todo regresa otro arrelgo en el cual se va a mostrar cuantas veces se repite cada dato
	 * @param dato
	 * @return ArrayList<String> nos permite observar cuantas veces se repiten los datos.
	 */
	public ArrayList<String> repetidos_DatosDouble(ArrayList<Double> dato){
		ArrayList<String> arreglo = new ArrayList<>();
		Collections.sort(dato);
		int repetidos = 0;
		int m = 0;
		for(int i = 0; i<dato.size();i++) {
			for(int j = i;j<dato.size();j++) {
				if(dato.get(i).equals(dato.get(j))) {
					repetidos++;
					m = repetidos-1;
					
				}else if(!dato.get(i).equals(dato.get(j)) ) {
					arreglo.add(repetidos+";"+dato.get(i));
					i += m;
					j=dato.size();
					repetidos = 0;
				}  
				
				if (dato.size()-j==1) {
					arreglo.add(repetidos+";"+dato.get(i));
					i=dato.size();
					
				}
			}
		}
		return arreglo;
	}
	
	/**
	 * Devuelve la informacion para el grafico de pie.
	 * @param dato
	 * @param tipo
	 * @return DefaultPieDataset<String> Informacion para el grafico de pie.
	 */
	public DefaultPieDataset<String> datosPie( ArrayList<String> dato,ArrayList<Integer>tipo) {
		DefaultPieDataset<String> pie = new DefaultPieDataset<String>();
		for(int i =0 ; i<dato.size();i++) {
			String[] valorx = dato.get(i).split(";");
			String valor = valorx[0];
			String texto = valorx[1];
			int n = Integer.parseInt(valor);
			double p =((double)n/tipo.size())*100;
			pie.setValue(texto, p);
		}
		return pie;
	}
	/**
	 * Devuelve la informacion para el grafico de pie.
	 * @param dato
	 * @param tipo
	 * @return DefaultPieDataset<String> Informacion para el grafico de pie.
	 */
	public DefaultPieDataset<String> datosPieDouble( ArrayList<String> dato,ArrayList<Double>tipo) {
		DefaultPieDataset<String> pie = new DefaultPieDataset<String>();
		for(int i =0 ; i<dato.size();i++) {
			String[] valorx = dato.get(i).split(";");
			String valor = valorx[0];
			String texto = valorx[1];
			int n = Integer.parseInt(valor);
			double p =((double)n/tipo.size())*100;
			pie.setValue(texto, p);
		}
		return pie;
	}
	
	/**
	 * Devuelve la informacion para el grafico de barras
	 * @param string 
	 * @param dato
	 * @return  DefaultCategoryDataset Informacion para el grafico de barras.
	 */
	public DefaultCategoryDataset datos(ArrayList<String> dato) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i = 0; i<dato.size();i++) {
			String[] valorx = dato.get(i).split(";");
			String valor = valorx[0];
			String texto = valorx[1];
		 dataset.setValue(Integer.parseInt(valor), texto,texto );
		}
		return dataset;
	}

	public double getMedia() {
		return media;
	}
	
	public void setMedia(double media) {
		this.media = media;
	}
	
	public double getMediana() {
		return mediana;
	}
	
	public void setMediana(double mediana) {
		this.mediana = mediana;
	}
	
}
