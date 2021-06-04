package co.edu.unbosque.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import co.edu.unbosque.model.BosTinder;
import co.edu.unbosque.model.persistence.ManejoFile;
import junit.framework.TestCase;

public class TestArchivos extends TestCase {

	private ManejoFile mj;
	private BosTinder bt;
	
	public void setUp() throws Exception {
		mj = new ManejoFile();
		bt = new BosTinder();
		
	}
	
	public void testMediana() {
		mj.leerCsv();
		ArrayList<Integer> dato =mj.getEdad();
		System.out.println(dato);
		//dato.sort(Comparator.naturalOrder());
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
		System.out.println(dato);
		assertEquals("F",55, mediana);
	}
	
	public void testMedia() {
		mj.leerCsv();
		ArrayList<Double> dato =mj.getIngresos();
		Collections.sort(dato);
		System.out.println(dato);
		int contador = 0;
		int contadorMax = 0;
		Double num= 0.0;
		ArrayList<Double> moda= new ArrayList<>();
		moda.add(0.0);
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
			System.out.println(i+"||"+num+"||"+contador+"||"+moda);
			
		}
		assertEquals("error", 58, moda);
	}
	
	
	public void testMediaFelipe(){
		mj.leerCsv();
		ArrayList<Integer> dato =mj.getEdad();
		Collections.sort(dato);
        ArrayList<Integer> moda = new ArrayList<>();
        int contador = 0;
        int rep = 0;
        int repmax =0;
        int pos = 0;
        do {
            for(int i = 0; i<dato.size();i++) {
                for(int j =0;j<dato.size();j++) {
                    if(dato.get(i).equals(dato.get(j))) {
                        rep++;
                    }
                }
                if(rep>repmax) {
                    repmax=rep;
                    pos=i;
                }
            }
            moda.add(dato.get(pos));
            if(rep==repmax && pos!=contador) {
                moda.add(dato.get(contador));
            }
        }while(contador>dato.size());
        assertEquals("error", 58, moda);
    }
	
	public void testleerCsv() {
		mj.leerCsv();
		assertEquals("error", "1",mj.getId().get(0));
	}
	
	public void testRandom() {
		mj.leerCsv();
		int tam = mj.getId().size();
		int num = bt.usuarioRandom(tam);
		assertEquals(num,435);
	}
}
