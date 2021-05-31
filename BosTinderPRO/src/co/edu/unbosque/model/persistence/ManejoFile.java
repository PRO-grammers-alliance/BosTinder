package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;


import com.opencsv.*;

public class ManejoFile {

	private String archivodata = ".\\Data\\datos.csv";
	private FileReader archCSV;
	private CSVReader csvReader;
	private ArrayList<String> id;
	private ArrayList<String> nombre;
	private ArrayList<String> apellido1;
	private ArrayList<String> apellido2;
	private ArrayList<String> sexo;
	private ArrayList<String> usuario;
	private ArrayList<String> contraseña;
	private ArrayList<String> correo;
	private ArrayList<String> nacimiento;
	private ArrayList<String> edad;
	private ArrayList<String> ingresos;
	private ArrayList<String> divorcios;
	private ArrayList<String> numeroLikesRecividos;
	private ArrayList<String> numeroLikesOtorgados;
	private ArrayList<String> numeroMatches;
	private ArrayList<String> estado;
	
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
		numeroLikesRecividos =new ArrayList<>();
		numeroLikesOtorgados =new ArrayList<>();
		numeroMatches =new ArrayList<>();
		estado =new ArrayList<>();
		
	}
	

	public void leerCvs() {
		try {
			archCSV = new FileReader(archivodata);
			CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
			csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
			String[] fila = null;
			while ((fila = csvReader.readNext()) != null) {
				
				id.add(fila[0]);
				nombre.add(fila[1]);
				apellido1.add(fila[2]);
				apellido2.add(fila[3]);
				sexo.add(fila[4]);
				usuario.add(fila[5]);
				contraseña.add(fila[6]);
				correo.add(fila[7]);
				nacimiento.add(fila[8]);
				edad.add(fila[9]);
				ingresos.add(fila[10]);
				divorcios.add(fila[11]);
				numeroLikesRecividos.add(fila[12]);
				numeroLikesOtorgados.add(fila[13]);
				numeroMatches.add(fila[14]);
				estado.add(fila[15]);
				
			}
		} catch (IOException e) {

		}catch(Exception e) {
		
      }
		finally {
		      try { 
		        archCSV.close();
		        csvReader.close();
		      }
		      catch(IOException e) {
		        System.out.println(e);
		      }
		}
		
		
	}

	public int escribirArchivo(String dato) {
		File f = new File(this.archivodata);
		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);

			pw.println(dato);
			fw.close();
		} catch (IOException e) {
			return -1;
		}
		return 0;
	}

	public String leerArchivo() {
		String linea = "";
		String cadena = "";

		File f = new File(this.archivodata);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			linea = br.readLine();
			while (linea != null) {
				cadena += linea + "\n";
				linea = br.readLine();

			}
			fr.close();
		} catch (IOException e) {
			return null;
		}
		return cadena;
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


	public ArrayList<String> getId() {
		return id;
	}


	public void setId(ArrayList<String> id) {
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


	public ArrayList<String> getEdad() {
		return edad;
	}


	public void setEdad(ArrayList<String> edad) {
		this.edad = edad;
	}


	


	public ArrayList<String> getIngresos() {
		return ingresos;
	}


	public void setIngresos(ArrayList<String> ingresos) {
		this.ingresos = ingresos;
	}


	public ArrayList<String> getDivorcios() {
		return divorcios;
	}


	public void setDivorcios(ArrayList<String> divorcios) {
		this.divorcios = divorcios;
	}


	public ArrayList<String> getNumeroLikesRecividos() {
		return numeroLikesRecividos;
	}


	public void setNumeroLikesRecividos(ArrayList<String> numeroLikesRecividos) {
		this.numeroLikesRecividos = numeroLikesRecividos;
	}


	public ArrayList<String> getNumeroLikesOtorgados() {
		return numeroLikesOtorgados;
	}


	public void setNumeroLikesOtorgados(ArrayList<String> numeroLikesOtorgados) {
		this.numeroLikesOtorgados = numeroLikesOtorgados;
	}


	public ArrayList<String> getNumeroMatches() {
		return numeroMatches;
	}


	public void setNumeroMatches(ArrayList<String> numeroMatches) {
		this.numeroMatches = numeroMatches;
	}


	public ArrayList<String> getEstado() {
		return estado;
	}


	public void setEstado(ArrayList<String> estado) {
		this.estado = estado;
	}

}
