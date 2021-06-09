package co.edu.unbosque.test;


import java.util.ArrayList;
import java.util.Collections;

import co.edu.unbosque.model.BosTinder;
import co.edu.unbosque.model.persistence.ManejoFile;
import junit.framework.TestCase;
/**
 * Clase del paquete test que contiene las pruebas JUnit
 * 
 * @author Felipe Segura
 * @author David Real
 * @author Oscar Florez
 * @author Santiago Zamora
 *
 */
public class TestArchivos extends TestCase {

	/**
	 * Objeto de ManejoFile que permite llamar a sus métodos y sus atributos
	 */
	private ManejoFile mj;
	
	/**
	 * Método de setUp de las pruebas JUnit
	 */
	public void setUp() throws Exception {
		mj = new ManejoFile();
		
	}

	/**
	 * Método que prueba el cálculo de la mediana del arreglo Edad 
	 */
	public void testMediana() {
		mj.leerCsv();
		ArrayList<Integer> dato =mj.getEdad();
		Collections.sort(dato);
		int mediana=0;
		if(dato.size()%2==0) {
			int mitad =dato.size()/2;
			int mitaduno = mitad+1;
			mediana= (dato.get(mitad)+dato.get(mitaduno))/2;
		}else if(dato.size()%2!=0) {
			int mitad =dato.size()/2;
			mediana = dato.get(mitad);
		}
		assertEquals("Incorrecto",55, mediana);
	}
	
	/**
	 * Método que prueba el cálculo de la moda del arreglo Ingresos
	 */
	public void testModaDouble() {
		mj.leerCsv();
		ArrayList<Double> dato =mj.getIngresos();
		Collections.sort(dato);
		ArrayList<Double> moda= new ArrayList<>();
		moda.add(0.0);
		int contador = 0;
		int contadorMax = 0;
		Double num= 0.0;
		
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
		assertEquals("error", 0.0, moda.get(0));
	}
	
	/**
	 * Método que prueba el cálculo de la moda del arreglo Edad
	 */
	public void testModaint(){
		mj.leerCsv();
		ArrayList<Integer> dato = mj.getEdad();
		Collections.sort(dato);
        ArrayList<Integer> moda = new ArrayList<>();
        moda.add(0);
        int contadorMax = 0;
        int contador= 0;
        int num=0;
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
        assertEquals("error", "58,75", moda.get(0)+","+moda.get(1));
    }
	
	/**
	 * Método que prueba la lectura del archivo Csv
	 */
	public void testleerCsv() {
		mj.leerCsv();
		assertEquals("error","1",mj.getId().get(0)+"");
	}
	
}
