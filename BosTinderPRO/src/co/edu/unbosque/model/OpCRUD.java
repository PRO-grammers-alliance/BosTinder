package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;

public class OpCRUD {

	public OpCRUD() {

	}

	public String filtroIngresos(String tipo, String tipo2, int tam, ArrayList<String> nombre,
			ArrayList<String> apellido1, ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias,
			ArrayList<Integer> numlikesR, ArrayList<Double> ingresos) {
		String ing = "";
		ArrayList<String> nom = new ArrayList<>();
		int i = 0;
		while (i < nombre.size()) {
			if (tipo2.equals("Nombre") && tipo.equals("Ascendente") && ingresos.get(i) >= 244.85) {
				ing = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom);
			} else if (tipo2.equals("Nombre") && tipo.equals("Descendente") && ingresos.get(i) >= 244.85) {
				ing = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo2.equals("Apellido") && tipo.equals("Descendente") && ingresos.get(i) >= 244.85) {
				ing = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo2.equals("Apellido") && tipo.equals("Ascendente") && ingresos.get(i) >= 244.85) {
				ing = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom);
			} else if (tipo2.equals("Edad") && tipo.equals("Ascendente") && ingresos.get(i) >= 244.85) {
				ing = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom);
			} else if (tipo2.equals("Edad") && tipo.equals("Descendente") && ingresos.get(i) >= 244.85) {
				ing = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo2.equals("Alias") && tipo.equals("Ascendente") && ingresos.get(i) >= 244.85) {
				ing = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom);
			} else if (tipo2.equals("Alias") && tipo.equals("Descendente") && ingresos.get(i) >= 244.85) {
				ing = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo2.equals("Likes") && tipo.equals("Ascendente") && ingresos.get(i) >= 244.85) {
				ing = numlikesR.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom);
			} else if (tipo2.equals("Likes") && tipo.equals("Descendente") && ingresos.get(i) >= 244.85) {
				ing = numlikesR.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(ing);
				Collections.sort(nom, Collections.reverseOrder());
			}
			i++;
		}
		int j = 0;
		String g = "";
		while (j < nom.size()) {
			g += nom.get(j);
			j++;
		}
		return g;
	}

	public String generoM(String tipo, String tipo2, int tam, ArrayList<String> genero, ArrayList<String> nombre,
			ArrayList<String> apellido1, ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias,
			ArrayList<Integer> numlikesR, ArrayList<Double> ingresos) {
		String gen = "";
		ArrayList<String> nom = new ArrayList<>();
		int i = 0;
		while (i < tam) {
			if (tipo.equals("Nombre") && tipo2.equals("Ascendente") && genero.get(i).equals("M")) {
				gen = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Nombre") && tipo2.equals("Descendente") && genero.get(i).equals("M")) {
				gen = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Apellido") && tipo2.equals("Ascendente") && genero.get(i).equals("M")) {
				gen = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Apellido") && tipo2.equals("Descendente") && genero.get(i).equals("M")) {
				gen = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Edad") && tipo2.equals("Ascendente") && genero.get(i).equals("M")) {
				gen = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Edad") && tipo2.equals("Descendente") && genero.get(i).equals("M")) {
				gen = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Alias") && tipo2.equals("Ascendente") && genero.get(i).equals("M")) {
				gen = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Alias") && tipo2.equals("Descendente") && genero.get(i).equals("M")) {
				gen = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Likes") && tipo2.equals("Ascendente") && genero.get(i).equals("M")) {
				gen = numlikesR.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Likes") && tipo2.equals("Descendente") && genero.get(i).equals("M")) {
				gen = numlikesR.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			}
			i++;
		}
		int j = 0;
		String g = "";
		while (j < nom.size()) {
			g += nom.get(j);
			j++;
		}
		return g;
	}

	public String generoH(String tipo, String tipo2, int tam, ArrayList<String> genero, ArrayList<String> nombre,
			ArrayList<String> apellido1, ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias,
			ArrayList<Integer> numlikesR, ArrayList<Double> ingresos) {
		String gen = "";
		ArrayList<String> nom = new ArrayList<>();
		int i = 0;
		while (i < tam) {
			if (tipo.equals("Nombre") && tipo2.equals("Ascendente") && genero.get(i).equals("H")) {
				gen = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Nombre") && tipo2.equals("Descendente") && genero.get(i).equals("H")) {
				gen = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Apellido") && tipo2.equals("Ascendente") && genero.get(i).equals("H")) {
				gen = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Apellido") && tipo2.equals("Descendente") && genero.get(i).equals("H")) {
				gen = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Edad") && tipo2.equals("Ascendente") && genero.get(i).equals("H")) {
				gen = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Edad") && tipo2.equals("Descendente") && genero.get(i).equals("H")) {
				gen = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Alias") && tipo2.equals("Ascendente") && genero.get(i).equals("H")) {
				gen = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Alias") && tipo2.equals("Descendente") && genero.get(i).equals("H")) {
				gen = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Likes") && tipo2.equals("Ascendente") && genero.get(i).equals("H")) {
				gen = numlikesR.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom);
			} else if (tipo.equals("Likes") && tipo2.equals("Descendente") && genero.get(i).equals("H")) {
				gen = numlikesR.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "  " + genero.get(i) + "\n";
				nom.add(gen);
				Collections.sort(nom, Collections.reverseOrder());
			}
			i++;
		}
		int j = 0;
		String g = "";
		while (j < nom.size()) {
			g += nom.get(j);
			j++;
		}
		return g;
	}

	public String ascendente(String tipo, ArrayList<String> nombre, ArrayList<String> apellido1,
			ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias, ArrayList<Integer> numlikesR,
			ArrayList<Double> ingresos) {
		String asc = "";
		int i = 0;
		ArrayList<String> nom = new ArrayList<>();
		
		while (i < nombre.size()) {
			if (tipo.equals("Nombre")) {
				asc = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
			} else if (tipo.equals("Apellido")) {
				asc = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
			} else if (tipo.equals("Edad")) {
				asc = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
			} else if (tipo.equals("Alias")) {
				asc = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
			} else if (tipo.equals("Likes")) {
				asc = numlikesR.get(i) + "   " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
			}
			i++;
		}
		String g = "";
		int j = 0;
		while (j < nombre.size()) {
			g += nom.get(j);
			j++;
		}
		
		return g;
	}

	public String descendente(String tipo, ArrayList<String> nombre, ArrayList<String> apellido1,
			ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias, ArrayList<Integer> numlikesR,
			ArrayList<Double> ingresos) {
		String des = "";
		ArrayList<String> nom = new ArrayList<>();
		if (tipo.equals("Nombre")) {
			int i = 0;
			while (i < nombre.size()) {
				des = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(des);
				Collections.sort(nom, Collections.reverseOrder());
				i++;
			}
		} else if (tipo.equals("Apellido")) {
			int i = 0;
			while (i < apellido1.size()) {
				des = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(des);
				Collections.sort(nom, Collections.reverseOrder());
				i++;
			}
		} else if (tipo.equals("Edad")) {
			int i = 0;
			while (i < edad.size()) {
				des = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(des);
				Collections.sort(nom, Collections.reverseOrder());
				i++;
			}
		} else if (tipo.equals("Alias")) {
			int i = 0;
			while (i < alias.size()) {
				des = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(des);
				Collections.sort(nom, Collections.reverseOrder());
				i++;
			}
		} else if (tipo.equals("Likes")) {
			int i = 0;
			while (i < numlikesR.size()) {
				des = numlikesR.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(des);
				Collections.sort(nom, Collections.reverseOrder());
				i++;
			}
		}
		int j = 0;
		String g = "";
		while (j < nombre.size()) {
			g += nom.get(j);
			j++;
		}
		return g;
	}
}