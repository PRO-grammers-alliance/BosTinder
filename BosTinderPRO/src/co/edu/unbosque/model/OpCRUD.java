package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class OpCRUD {

	public OpCRUD() {

	}

	public String obtenerNombre(int tam, ArrayList<String> nombre) {
		int i = 0;
		String nom = "";
		while (i < tam) {
			nom += "Nombre: " + nombre.get(i) + "\n";
			i++;
		}
		return nom;
	}

	public String obtenerApellido(int tam, ArrayList<String> apellidos1, ArrayList<String> apellidos2) {
		int i = 0;
		String ap = "";
		while (i < tam) {
			ap += "Apellido: " + apellidos1.get(i) + " " + apellidos2.get(i) + "\n";
			i++;
		}
		return ap;
	}

	public String obtenerEdad(int tam, ArrayList<Integer> edad) {
		int i = 0;
		String ed = "";
		while (i < tam) {
			ed += "Edad: " + edad.get(i) + "\n";
			i++;
		}
		return ed;
	}

	public String obtenerAlias(int tam, ArrayList<String> alias) {
		int i = 0;
		String al = "";
		while (i < tam) {
			al += "Alias: " + alias.get(i) + "\n";
			i++;
		}
		return al;
	}

	public String obtenerNumLikes(int tam, ArrayList<Integer> numlikesR, ArrayList<Integer> numlikesO) {
		int i = 0;
		String likes = "";
		while (i < tam) {
			likes += "Numero Likes Recibidos: " + numlikesR.get(i) + ", Numero Likes Otorgados: " + numlikesO.get(i)
					+ "\n";
			i++;
		}
		return likes;
	}

	public String filtroIngresos(int tam, ArrayList<Double> ingresos, ArrayList<String> nombre) {
		String ing = "";
		for (int i = 0; i < tam; i++) {
			if (ingresos.get(i) >= 244.85) {
				ing += nombre.get(i) + " -> " + ingresos.get(i) + "$USD\n";
			}
		}
		return ing;
	}
	
	public String filtroIngresosE(int tam, ArrayList<Double> ingresos, ArrayList<Integer> edad) {
		String ing = "";
		for (int i = 0; i < tam; i++) {
			if (ingresos.get(i) >= 244.85) {
				ing += edad.get(i) + " -> " + ingresos.get(i) + "$USD\n";
			}
		}
		return ing;
	}

	public String genero(int tam, ArrayList<String> genero, ArrayList<String> nombre) {
		String gen = "";
		int i = 0;
		while (i < tam) {
			gen += "Nombre: " + nombre.get(i) + " -> " + genero.get(i) + "\n";
			i++;
		}
		return gen;
	}

	public String ascendente(String tipo, ArrayList<String> nombre, ArrayList<String> apellido1,
			ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias, ArrayList<Integer> numlikesR,
			ArrayList<Integer> numlikesO, ArrayList<Double> ingresos) {
		String des = "";
		Collections.sort(nombre);
		Collections.sort(apellido1);
		Collections.sort(apellido2);
		Collections.sort(edad);
		Collections.sort(alias);
		Collections.sort(numlikesR);
		Collections.sort(numlikesO);
		Collections.sort(ingresos);
		if (tipo.equals("Nombre")) {
			for (String listaNombreO : nombre) {
				des += listaNombreO + "\n";
			}
		} else if (tipo.equals("Apellido")) {
			int i = 0;
			while(i < apellido1.size()) {
				des += "Apellido 1 ";
				des += apellido1.get(i) + "\n";
				des += "Apellido 2 ";
				des += apellido2.get(i) + "\n";
				i++;
			}
		}else if(tipo.equals("Edad")) {
			int i = 0;
			while(i < edad.size()) {
				des += edad.get(i) + "\n";
				i++;
			}
		}else if(tipo.equals("Alias")) {
			int i = 0;
			while(i < alias.size()) {
				des += alias.get(i) + "\n";
				i++;
			}
		}else if(tipo.equals("Likes")) {
			int i = 0;
			while(i < numlikesR.size()) {
				des += "Likes Recibidos ";
				des += numlikesR.get(i) + "\n";
				des += "Likes Otorgados ";
				des += numlikesO.get(i) + "\n";
				i++;
			}
		}else if(tipo.equals("ingresos")) {
			int i = 0;
			while(i < ingresos.size()) {
				des += ingresos.get(i);
				i++;
			}
		}
		return des;
	}
	
	public String descendente(String tipo, ArrayList<String> nombre, ArrayList<String> apellido1,
			ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias, ArrayList<Integer> numlikesR,
			ArrayList<Integer> numlikesO, ArrayList<Double> ingresos) {
		String des = "";
		Collections.sort(nombre, Collections.reverseOrder());
		Collections.sort(apellido1, Collections.reverseOrder());
		Collections.sort(apellido2, Collections.reverseOrder());
		Collections.sort(edad, Collections.reverseOrder());
		Collections.sort(alias, Collections.reverseOrder());
		Collections.sort(numlikesR, Collections.reverseOrder());
		Collections.sort(numlikesO, Collections.reverseOrder());
		Collections.sort(ingresos, Collections.reverseOrder());
		if (tipo.equals("Nombre")) {
			int i = 0;
			while (i < nombre.size()) {
				des += nombre.get(i);
				i++;
			}
		} else if (tipo.equals("Apellido")) {
			int i = 0;
			while(i < apellido1.size()) {
				des += "Apellido 1 ";
				des += apellido1.get(i) + "\n";
				des += "Apellido 2 ";
				des += apellido2.get(i) + "\n";
				i++;
			}
		}else if(tipo.equals("Edad")) {
			int i = 0;
			while(i < edad.size()) {
				des += edad.get(i) + "\n";
				i++;
			}
		}else if(tipo.equals("Alias")) {
			int i = 0;
			while(i < alias.size()) {
				des += alias.get(i) + "\n";
				i++;
			}
		}else if(tipo.equals("Likes")) {
			int i = 0;
			while(i < numlikesR.size()) {
				des += "Likes Recibidos ";
				des += numlikesR.get(i) + "\n";
				des += "Likes Otorgados ";
				des += numlikesO.get(i) + "\n";
				i++;
			}
		}else if(tipo.equals("ingresos")) {
			int i = 0;
			while(i < ingresos.size()) {
				des += ingresos.get(i);
				i++;
			}
		}
		return des;
	}
}
