package co.edu.unbosque.test;

import co.edu.unbosque.model.BosTinder;
import co.edu.unbosque.model.persistence.ManejoFile;
import co.edu.unbosque.view.View;
import junit.framework.TestCase;

public class TestArchivos extends TestCase {

	private ManejoFile mj;
	private BosTinder bt;
	
	public void setUp() throws Exception {
		mj = new ManejoFile();
		bt = new BosTinder();
	}
	
	public void testleerCsv() {
		mj.leerCsv();
		assertEquals("error", "Id",mj.getId().get(2));
	}
	
	public void testArchivo () {
		String bd = mj.leerArchivo();		
		String [] a ;
		a = bd.split(";",7472);
		assertEquals(bd,"Id;Nombre");
	}
	
	public void testRandom() {
		mj.leerCsv();
		System.out.println(mj.getId()+"\n");
		int tam = mj.getId().size();
		int num = bt.usuarioRandom(tam);
		System.out.println(num);
		assertEquals(num,23);
	}
	
}
