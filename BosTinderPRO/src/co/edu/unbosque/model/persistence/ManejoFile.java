package co.edu.unbosque.model.persistence;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;
import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;


public class ManejoFile {

	private String archivodata = ".\\Data\\datos.csv";
	private FileReader archCSV;
	private CSVReader csvReader;
	private ArrayList<Integer> id;
	private ArrayList<String> nombre;
	private ArrayList<String> apellido1;
	private ArrayList<String> apellido2;
	private ArrayList<String> sexo;
	private ArrayList<String> usuario;
	private ArrayList<String> contrase�a;
	private ArrayList<String> correo;
	private ArrayList<String> nacimiento;
	private ArrayList<Integer> edad;
	private ArrayList<Double> ingresos;
	private ArrayList<String> divorcios;
	private ArrayList<Integer> numeroLikesRecibidos;
	private ArrayList<Integer> numeroLikesOtorgados;
	private ArrayList<Integer> numeroMatches;
	private ArrayList<String> estado;
	private ArrayList<Integer> estatura;
	
	public ManejoFile() {
		
		id =new ArrayList<>();
		nombre =new ArrayList<>();
		apellido1 =new ArrayList<>();
		apellido2 =new ArrayList<>();
		sexo =new ArrayList<>();
		usuario =new ArrayList<>();
		contrase�a =new ArrayList<>();
		correo =new ArrayList<>();
		nacimiento =new ArrayList<>();
		edad =new ArrayList<>();
		ingresos =new ArrayList<>();
		divorcios =new ArrayList<>();
		numeroLikesRecibidos =new ArrayList<>();
		numeroLikesOtorgados =new ArrayList<>();
		numeroMatches =new ArrayList<>();
		estado =new ArrayList<>();
		estatura = new ArrayList<>();
	}
	
/**
 * Metodo por medio de la libreria opencsv lee la base de datos y guarda cada valor en un correspondiente arrglo.
 */
	public void leerCsv() {
		try {
			archCSV = new FileReader(archivodata);
			CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
			csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
			String[] fila = null;
			while ((fila = csvReader.readNext()) != null) {
				
				int ids = Integer.parseInt(fila[0]);
				id.add(ids);
				nombre.add(fila[1]);
				apellido1.add(fila[2]);
				apellido2.add(fila[3]);
				sexo.add(fila[4]);
				usuario.add(fila[5]);
				contrase�a.add(fila[6]);
				correo.add(fila[7]);
				nacimiento.add(fila[8]);
				int ed = Integer.parseInt(fila[9]);
				edad.add(ed);
				double i = Double.parseDouble(fila[10]);
				ingresos.add(i);
				divorcios.add(fila[11]);
				int lr = Integer.parseInt(fila[12]);
				numeroLikesRecibidos.add(lr);
				int lo = Integer.parseInt(fila[13]);
				numeroLikesOtorgados.add(lo);
				int es = Integer.parseInt(fila[14]);
				estatura.add(es);
				int ma = Integer.parseInt(fila[15]);
				numeroMatches.add(ma);
				estado.add(fila[16]);
				
			}
			archCSV.close();
	        csvReader.close();
		} catch (IOException e) {

		} catch (CsvValidationException e) {
			
		}
		
	}
		
	/**
	 * Metodo que escribe nuevamente en  la base de datos liena por linea.
	 * @return
	 */
	public String escribirArchivo() {
		File f = new File(this.archivodata);
		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw); 
			String datosString = "";
			for(int i = 0;i<id.size();i++) {
				String ids = id.get(i)+"";
				String name = nombre.get(i);
				String apll1 = apellido1.get(i);
				String apll2 = apellido2.get(i);
				String genero = sexo.get(i);
				String user = usuario.get(i);
				String clave = contrase�a.get(i);
				String email = correo.get(i);
				String nac = nacimiento.get(i);
				String a�os = edad.get(i)+"";
				String salario = ingresos.get(i)+"";
				String divorcio = divorcios.get(i);
				String numLikesR = numeroLikesRecibidos.get(i)+"";
				String numLikesO = numeroLikesOtorgados.get(i)+"";
				String altura = estatura.get(i)+"";
				String numMatches = numeroMatches.get(i)+"";
				String est = estado.get(i);
				datosString = ids+";"+name+";"+apll1+";"+apll2+";"+genero+";"+user+";"+'"'+clave+'"'+";"+email+";"
						+nac+";"+a�os+";"+salario+";"+divorcio+";"+numLikesR+";"+numLikesO+";"+altura+";"+numMatches+";"+est;
				
				pw.println(datosString); 

			}
			
			fw.close();
			
		} catch (IOException e) {
			return "Registro no exitoso";
		}
		return "Registro exitoso";
	}
	
	public JFreeChart crearGraficoPie(String sobreque ,PieDataset data) {
		
		 JFreeChart chart = ChartFactory.createPieChart(
				 "Porcentajes "+sobreque, 
		         data, 
		         true, 
		         true, 
		         false);

	    return chart;
	}
	
	public JFreeChart crearGrafico(String sobreque ,DefaultCategoryDataset data) {
		
		 JFreeChart chart = ChartFactory.createBarChart
			        ("Repeticion por "+sobreque,sobreque, "repeticiones", 
			        data, PlotOrientation.VERTICAL, true,true, false);
			        chart.setBackgroundPaint(Color.cyan);
			        chart.getTitle().setPaint(Color.black); 
			        CategoryPlot p = chart.getCategoryPlot(); 
			        p.setRangeGridlinePaint(Color.red); 
		return chart;
	}
	//	codigo para generar pdf de esdades bosT.getMaFi().generarPDF(bosT.getEstad().media(bosT.getMaFi().getEdad()), bosT.getEstad().modaInt(bosT.getMaFi().getEdad()), bosT.getEstad().mediana(bosT.getMaFi().getEdad()), "Edades", bosT.getEstad().datos(bosT.getEstad().repetidos_Datos(bosT.getMaFi().getEdad())),bosT.getEstad().datosPie(bosT.getEstad().repetidos_Datos(bosT.getMaFi().getEdad()), bosT.getMaFi().getEdad()));

	public void generarPDF(int media, ArrayList<Integer> moda,double mediana, String sobreque ,DefaultCategoryDataset data, DefaultPieDataset<String> pie) {
		JFreeChart chart = crearGrafico(sobreque, data);
		JFreeChart chart1 = crearGraficoPie(sobreque, pie);
		PDFDocument pdfDoc = new PDFDocument();
		pdfDoc.setTitle("Estadistica "+sobreque);
		pdfDoc.setAuthor("Bos Tinder");
		
		com.orsonpdf.Page page0 = pdfDoc.createPage(new Rectangle(612, 468));
		PDFGraphics2D g = page0.getGraphics2D();
		g.setFont(new Font("Arial", Font.BOLD, 26));
		String texto = "Informe Bos tinder sobre "+sobreque;
		Rectangle2D esp0 =g.getFontMetrics().getStringBounds(texto, g);
		
		g.setColor(Color.black);
		g.drawString(texto, 15, 10 + (int)esp0.getHeight());
		
		PDFGraphics2D g1 = page0.getGraphics2D();
		g1.setFont(new Font("Arial", Font.BOLD, 15));
		String mediatex = "El promedio de l@s "+sobreque+" es de : "+media+"%";
		Rectangle2D esp1 =g1.getFontMetrics().getStringBounds(mediatex, g1);
		
		g1.create(15, 40, 30, 100);
		g1.setColor(Color.black);
		g1.drawString(mediatex, 15, 40);
		
		PDFGraphics2D g2 = page0.getGraphics2D();
		g2.setFont(new Font("Arial", Font.BOLD, 15));
		String modatex = "L@s "+sobreque+" la mas repetidad es : "+moda+".";
		Rectangle2D esp2 =g2.getFontMetrics().getStringBounds(modatex, g2);
		
		g2.create(15, 60, 300, 300);
		g2.setColor(Color.black);
		g2.drawString(modatex, 15, 40);
		
		PDFGraphics2D g3 = page0.getGraphics2D();
		g3.setFont(new Font("Arial", Font.BOLD, 15));
		String medianatex = "El dato de la mitad es : "+mediana+".";
		Rectangle2D espa3 =g3.getFontMetrics().getStringBounds(medianatex, g3);
		
		g3.create(15, 80, 300, 300);
		g3.setColor(Color.black);
		g3.drawString(medianatex, 15, 40);
		
		
		com.orsonpdf.Page page1 = pdfDoc.createPage(new Rectangle(612, 468));
		PDFGraphics2D g4 = page1.getGraphics2D();
		
		chart.draw(g4, new Rectangle(0, 0, 612, 468));
		
		com.orsonpdf.Page page3 = pdfDoc.createPage(new Rectangle(612, 468));
		PDFGraphics2D g5 = page3.getGraphics2D();
		
		chart1.draw(g5, new Rectangle(0, 0, 612, 468));

		pdfDoc.writeToFile(new File(".\\Data\\Estadisticas "+sobreque+".pdf"));
		
		
	}
	
	public void generarPDFDouble (int media, ArrayList<Double> moda,double mediana, String sobreque ,DefaultCategoryDataset data, DefaultPieDataset<String> pie) {
		JFreeChart chart = crearGrafico(sobreque, data);
		JFreeChart chart1 = crearGraficoPie(sobreque, pie);
		PDFDocument pdfDoc = new PDFDocument();
		pdfDoc.setTitle("Estadistica "+sobreque);
		pdfDoc.setAuthor("Bos Tinder");
		
		com.orsonpdf.Page page0 = pdfDoc.createPage(new Rectangle(612, 468));
		PDFGraphics2D g = page0.getGraphics2D();
		g.setFont(new Font("Arial", Font.BOLD, 26));
		String texto = "Informe Bos tinder sobre "+sobreque;
		Rectangle2D esp0 =g.getFontMetrics().getStringBounds(texto, g);
		
		g.setColor(Color.black);
		g.drawString(texto, 15, 10 + (int)esp0.getHeight());
		
		PDFGraphics2D g1 = page0.getGraphics2D();
		g1.setFont(new Font("Arial", Font.BOLD, 15));
		String mediatex = "El promedio de l@s "+sobreque+" es de : "+media+"%";
		Rectangle2D esp1 =g1.getFontMetrics().getStringBounds(mediatex, g1);
		
		g1.create(15, 40, 30, 100);
		g1.setColor(Color.black);
		g1.drawString(mediatex, 15, 40);
		
		PDFGraphics2D g2 = page0.getGraphics2D();
		g2.setFont(new Font("Arial", Font.BOLD, 15));
		String modatex = "L@s "+sobreque+" la mas repetidad es : "+moda+".";
		Rectangle2D esp2 =g2.getFontMetrics().getStringBounds(modatex, g2);
		
		g2.create(15, 60, 300, 300);
		g2.setColor(Color.black);
		g2.drawString(modatex, 15, 40);
		
		PDFGraphics2D g3 = page0.getGraphics2D();
		g3.setFont(new Font("Arial", Font.BOLD, 15));
		String medianatex = "El dato de la mitad es : "+mediana+".";
		Rectangle2D espa3 =g3.getFontMetrics().getStringBounds(medianatex, g3);
		
		g3.create(15, 80, 300, 300);
		g3.setColor(Color.black);
		g3.drawString(medianatex, 15, 40);
		
		
		com.orsonpdf.Page page1 = pdfDoc.createPage(new Rectangle(612, 468));
		PDFGraphics2D g4 = page1.getGraphics2D();
		
		chart.draw(g4, new Rectangle(0, 0, 612, 468));
		
		com.orsonpdf.Page page3 = pdfDoc.createPage(new Rectangle(612, 468));
		PDFGraphics2D g5 = page3.getGraphics2D();
		
		chart1.draw(g5, new Rectangle(0, 0, 612, 468));

		pdfDoc.writeToFile(new File(".\\Data\\Estadisticas "+sobreque+".pdf"));
		
		
	}
	
	
	public String getArchivodata() {
		return archivodata;
	}


	public void setArchivodata(String archivodata) {
		this.archivodata = archivodata;
	}


	public FileReader getArchCSV() {
		return archCSV;
	}


	public void setArchCSV(FileReader archCSV) {
		this.archCSV = archCSV;
	}


	public CSVReader getCsvReader() {
		return csvReader;
	}


	public void setCsvReader(CSVReader csvReader) {
		this.csvReader = csvReader;
	}


	public ArrayList<Integer> getId() {
		return id;
	}


	public void setId(ArrayList<Integer> id) {
		this.id = id;
	}


	public ArrayList<String> getNombre() {
		return nombre;
	}


	public void setNombre(ArrayList<String> nombre) {
		this.nombre = nombre;
	}


	public ArrayList<String> getApellido1() {
		return apellido1;
	}


	public void setApellido1(ArrayList<String> apellido1) {
		this.apellido1 = apellido1;
	}


	public ArrayList<String> getApellido2() {
		return apellido2;
	}


	public void setApellido2(ArrayList<String> apellido2) {
		this.apellido2 = apellido2;
	}


	public ArrayList<String> getSexo() {
		return sexo;
	}


	public void setSexo(ArrayList<String> sexo) {
		this.sexo = sexo;
	}


	public ArrayList<String> getUsuario() {
		return usuario;
	}


	public void setUsuario(ArrayList<String> usuario) {
		this.usuario = usuario;
	}


	public ArrayList<String> getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(ArrayList<String> contrase�a) {
		this.contrase�a = contrase�a;
	}


	public ArrayList<String> getCorreo() {
		return correo;
	}


	public void setCorreo(ArrayList<String> correo) {
		this.correo = correo;
	}


	public ArrayList<String> getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(ArrayList<String> nacimiento) {
		this.nacimiento = nacimiento;
	}


	public ArrayList<Integer> getEdad() {
		return edad;
	}


	public void setEdad(ArrayList<Integer> edad) {
		this.edad = edad;
	}

	public ArrayList<Double> getIngresos() {
		return ingresos;
	}


	public void setIngresos(ArrayList<Double> ingresos) {
		this.ingresos = ingresos;
	}


	public ArrayList<String> getDivorcios() {
		return divorcios;
	}



	public ArrayList<Integer> getEstatura() {
		return estatura;
	}


	public void setEstatura(ArrayList<Integer> estatura) {
		this.estatura = estatura;
	}


	public void setDivorcios(ArrayList<String> divorcios) {
		this.divorcios = divorcios;
	}

	public ArrayList<Integer> getNumeroLikesRecibidos() {
		return numeroLikesRecibidos;
	}


	public void setNumeroLikesRecibidos(ArrayList<Integer> numeroLikesRecibidos) {
		this.numeroLikesRecibidos = numeroLikesRecibidos;
	}
	
	public ArrayList<Integer> getNumeroLikesOtorgados() {
		return numeroLikesOtorgados;
	}


	public void setNumeroLikesOtorgados(ArrayList<Integer> numeroLikesOtorgados) {
		this.numeroLikesOtorgados = numeroLikesOtorgados;
	}


	public ArrayList<Integer> getNumeroMatches() {
		return numeroMatches;
	}


	public void setNumeroMatches(ArrayList<Integer> numeroMatches) {
		this.numeroMatches = numeroMatches;
	}


	public ArrayList<String> getEstado() {
		return estado;
	}


	public void setEstado(ArrayList<String> estado) {
		this.estado = estado;
	}

}
