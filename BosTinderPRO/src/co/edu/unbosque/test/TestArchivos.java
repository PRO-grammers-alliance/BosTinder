package co.edu.unbosque.test;

import co.edu.unbosque.model.persistence.ManejoFile;
import co.edu.unbosque.view.View;
import junit.framework.TestCase;

public class TestArchivos extends TestCase {

	private ManejoFile mj;
	private View v;
	
	public void setUp() throws Exception {
		mj = new ManejoFile();
		v = new View();
	}
	/*
	public void testArchivo () {
		String bd = mj.leerArchivo();		
		String [] a ;
		a = bd.split(";",7472);
		assertEquals(bd,"Id;Nombre");
	}
	*/
	public void testleerCsv() {
		mj.leerCvs();
		assertEquals("error", "Id",mj.getId().get(2));
		
	}
	
}
