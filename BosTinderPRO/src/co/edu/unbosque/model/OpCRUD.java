package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class OpCRUD {

	public OpCRUD() {

	}

	public String orden(String tipo, int tam, ArrayList<String> nombre, ArrayList<String> apellido1,
			ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias, ArrayList<Integer> numlikesR,
			ArrayList<Integer> numlikesO, ArrayList<Double> ingresos) {
		int i = 0;
		String nom = "";
		while (i < tam) {
			if (tipo.equals("Nombre")) {
				nom += nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i) + " -> " + edad.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + "\n";
				nom += "\n";
				i++;
			} else if (tipo.equals("Apellido")) {
				nom += apellido1.get(i) + " -> " + apellido2.get(i) + " -> " + nombre.get(i) + " -> " + edad.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + "\n";
				nom += "\n";
				i++;
			} else if (tipo.equals("Edad")) {
				nom += edad.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + "\n";
				nom += "\n";
				i++;
			} else if (tipo.equals("Alias")) {
				nom += alias.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i)
						+ " -> " + edad.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + "\n";
				nom += "\n";
				i++;
			} else if (tipo.equals("Likes")) {
				nom += numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i)
						+ " -> " + apellido2.get(i) + " -> " + edad.get(i) + " -> " + alias.get(i) + " -> "
						+ ingresos.get(i) + "\n";
				nom += "\n";
				i++;
			}
			i++;
		}
		return nom;
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

	public String generoM(int tam, ArrayList<String> genero, ArrayList<String> nombre) {
		String gen = "";
		int i = 0;
		while (i < tam) {
			if (genero.get(i).equals("M")) {
				gen += "Nombre: " + nombre.get(i) + " -> " + genero.get(i) + "\n";
			}
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
			while (i < apellido1.size()) {
				des += "Apellido 1 ";
				des += apellido1.get(i) + "\n";
				des += "Apellido 2 ";
				des += apellido2.get(i) + "\n";
				i++;
			}
		} else if (tipo.equals("Edad")) {
			int i = 0;
			while (i < edad.size()) {
				des += edad.get(i) + "\n";
				i++;
			}
		} else if (tipo.equals("Alias")) {
			int i = 0;
			while (i < alias.size()) {
				des += alias.get(i) + "\n";
				i++;
			}
		} else if (tipo.equals("Likes")) {
			int i = 0;
			while (i < numlikesR.size()) {
				des += "Likes Recibidos ";
				des += numlikesR.get(i) + "\n";
				des += "Likes Otorgados ";
				des += numlikesO.get(i) + "\n";
				i++;
			}
		} else if (tipo.equals("ingresos")) {
			int i = 0;
			while (i < ingresos.size()) {
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
			while (i < apellido1.size()) {
				des += "Apellido 1 ";
				des += apellido1.get(i) + "\n";
				des += "Apellido 2 ";
				des += apellido2.get(i) + "\n";
				i++;
			}
		} else if (tipo.equals("Edad")) {
			int i = 0;
			while (i < edad.size()) {
				des += edad.get(i) + "\n";
				i++;
			}
		} else if (tipo.equals("Alias")) {
			int i = 0;
			while (i < alias.size()) {
				des += alias.get(i) + "\n";
				i++;
			}
		} else if (tipo.equals("Likes")) {
			int i = 0;
			while (i < numlikesR.size()) {
				des += "Likes Recibidos ";
				des += numlikesR.get(i) + "\n";
				des += "Likes Otorgados ";
				des += numlikesO.get(i) + "\n";
				i++;
			}
		} else if (tipo.equals("ingresos")) {
			int i = 0;
			while (i < ingresos.size()) {
				des += ingresos.get(i);
				i++;
			}
		}
		return des;
	}
}