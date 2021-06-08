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

	public String generoM(String tipo, int tam, ArrayList<String> genero, ArrayList<String> nombre,
			ArrayList<String> apellido1, ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias,
			ArrayList<Integer> numlikesR, ArrayList<Integer> numlikesO, ArrayList<Double> ingresos) {
		String gen = "";
		int i = 0;
		while (i < tam) {
			if (genero.get(i).equals("M") && tipo.equals("Nombre")) {
				gen += nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i) + " -> " + edad.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			} else if (genero.get(i).equals("M") && tipo.equals("Apellido")) {
				gen += apellido1.get(i) + " -> " + apellido2.get(i) + " -> " + nombre.get(i) + " -> " + edad.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			} else if (genero.get(i).equals("M") && tipo.equals("Edad")) {
				gen += edad.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			} else if (genero.get(i).equals("M") && tipo.equals("Alias")) {
				gen += alias.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i)
						+ " -> " + edad.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			} else if (genero.get(i).equals("M") && tipo.equals("Likes")) {
				gen += numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i)
						+ " -> " + apellido2.get(i) + " -> " + edad.get(i) + " -> " + alias.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			}
			i++;
		}
		return gen;
	}

	public String generoH(String tipo, int tam, ArrayList<String> genero, ArrayList<String> nombre,
			ArrayList<String> apellido1, ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias,
			ArrayList<Integer> numlikesR, ArrayList<Integer> numlikesO, ArrayList<Double> ingresos) {
		String gen = "";
		int i = 0;
		while (i < tam) {
			if (genero.get(i).equals("H") && tipo.equals("Nombre")) {
				gen += nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i) + " -> " + edad.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			} else if (genero.get(i).equals("H") && tipo.equals("Apellido")) {
				gen += apellido1.get(i) + " -> " + apellido2.get(i) + " -> " + nombre.get(i) + " -> " + edad.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			} else if (genero.get(i).equals("H") && tipo.equals("Edad")) {
				gen += edad.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i)
						+ " -> " + alias.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			} else if (genero.get(i).equals("H") && tipo.equals("Alias")) {
				gen += alias.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i) + " -> " + apellido2.get(i)
						+ " -> " + edad.get(i) + " -> " + numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			} else if (genero.get(i).equals("H") && tipo.equals("Likes")) {
				gen += numlikesR.get(i) + " -> " + numlikesO.get(i) + " -> " + nombre.get(i) + " -> " + apellido1.get(i)
						+ " -> " + apellido2.get(i) + " -> " + edad.get(i) + " -> " + alias.get(i) + " -> "
						+ ingresos.get(i) + " -> " + genero.get(i) + "\n";
			}
			i++;
		}
		return gen;
	}

	public String ascendente(String tipo, ArrayList<String> nombre, ArrayList<String> apellido1,
			ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias, ArrayList<Integer> numlikesR,
			ArrayList<Integer> numlikesO, ArrayList<Double> ingresos) {
		String asc = "";
		ArrayList<String> nom = new ArrayList<>();
		if (tipo.equals("Nombre")) {
			int i = 0;
			while (i < nombre.size()) {
				asc = nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
				i++;
			}
		} else if (tipo.equals("Apellido")) {
			int i = 0;
			while (i < apellido1.size()) {
				asc = apellido1.get(i) + "  " + apellido2.get(i) + "  " + nombre.get(i) + " " + edad.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
				i++;
			}
		} else if (tipo.equals("Edad")) {
			int i = 0;
			while (i < edad.size()) {
				asc = edad.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ alias.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
				i++;
			}
		} else if (tipo.equals("Alias")) {
			int i = 0;
			while (i < alias.size()) {
				asc = alias.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + numlikesR.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
				i++;
			}
		} else if (tipo.equals("Likes")) {
			int i = 0;
			while (i < numlikesR.size()) {
				asc = numlikesR.get(i) + "  " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i) + "  "
						+ edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "\n";
				nom.add(asc);
				Collections.sort(nom);
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