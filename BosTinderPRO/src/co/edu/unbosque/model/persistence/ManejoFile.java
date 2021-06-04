package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class ManejoFile {

	private String archivodata = ".\\Data\\datos.csv";
	private FileReader archCSV;
	private CSVReader csvReader;
	private CSVWriter csvWriter;
	private ArrayList<Integer> id;
	private ArrayList<String> nombre;
	private ArrayList<String> apellido1;
	private ArrayList<String> apellido2;
	private ArrayList<String> sexo;
	private ArrayList<String> usuario;
	private ArrayList<String> contraseña;
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
		contraseña =new ArrayList<>();
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
				contraseña.add(fila[6]);
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
				String clave = contraseña.get(i);
				String email = correo.get(i);
				String nac = nacimiento.get(i);
				String años = edad.get(i)+"";
				String salario = ingresos.get(i)+"";
				String divorcio = divorcios.get(i);
				String numLikesR = numeroLikesRecibidos.get(i)+"";
				String numLikesO = numeroLikesOtorgados.get(i)+"";
				String altura = estatura.get(i)+"";
				String numMatches = numeroMatches.get(i)+"";
				String est = estado.get(i);
				datosString = ids+";"+name+";"+apll1+";"+apll2+";"+genero+";"+user+";"+'"'+clave+'"'+";"+email+";"
						+nac+";"+años+";"+salario+";"+divorcio+";"+numLikesR+";"+numLikesO+";"+altura+";"+numMatches+";"+est;
				
				pw.println(datosString); 

			}
			
			fw.close();
			
		} catch (IOException e) {
			return "Registro no exitoso";
		}
		return "Registro exitoso";
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


	public ArrayList<String> getContraseña() {
		return contraseña;
	}


	public void setContraseña(ArrayList<String> contraseña) {
		this.contraseña = contraseña;
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
