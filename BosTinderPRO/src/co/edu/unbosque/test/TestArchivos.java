package co.edu.unbosque.test;


import co.edu.unbosque.model.BosTinder;
import co.edu.unbosque.model.persistence.ManejoFile;
import junit.framework.TestCase;

public class TestArchivos extends TestCase {

	private ManejoFile mj;
	private BosTinder bt;
	
	public void setUp() throws Exception {
		mj = new ManejoFile();
		bt = new BosTinder();
		mj.leerCsv();
	}
	
	
	public void testleerCsv() {
		mj.leerCsv();
		assertEquals("error", "Id",mj.getId().get(2));
	}
	
	public void testRandom() {
		mj.leerCsv();
		int tam = mj.getId().size();
		int num = bt.usuarioRandom(tam);
		assertEquals(num,23);
	}
}
