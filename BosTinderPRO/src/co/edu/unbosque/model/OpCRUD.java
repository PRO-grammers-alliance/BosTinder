package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que contiene los metodos usados para filtrar y ordenar la informacion
 * de la base de datos en la ventana del administrador
 *
 */
public class OpCRUD {
	/**
	 * Metodo constructor
	 */
	public OpCRUD() {

	}

	/**
	 * Metodo que se encarga de filtrar la informacion con los ingresos mayores a
	 * 244.85 US
	 * 
	 * @param tipo
	 * @param tipo2
	 * @param tam
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param edad
	 * @param alias
	 * @param numlikesR
	 * @param ingresos
	 * @return una cadena de texto donde se guardan cada uno de los filtros
	 *         dependiendo del tipo y tipo2
	 */
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

	/**
	 * Metodo que filtra la informacion del usuario segun el genero, en este caso
	 * filtra a los usuarios que sean mujeres
	 * 
	 * @param tipo
	 * @param tipo2
	 * @param tam
	 * @param genero
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param edad
	 * @param alias
	 * @param numlikesR
	 * @param ingresos
	 * @return una cadena de texto donde se guardan cada uno de los filtros
	 *         dependiendo del tipo y tipo2
	 */
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

	/**
	 * Metodo que filtra la informacion del usuario segun el genero, en este caso
	 * filtra a los usuarios que sean hombres
	 * 
	 * @param tipo
	 * @param tipo2
	 * @param tam
	 * @param genero
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param edad
	 * @param alias
	 * @param numlikesR
	 * @param ingresos
	 * @return una cadena de texto donde se guardan cada uno de los filtros
	 *         dependiendo del tipo y tipo2
	 */
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

	/**
	 * Metodo que organiza la informacion de usuario segun nombre, apellido, edad,
	 * alias, numero de likes e ingresos y los muestra de forma ascendente
	 * 
	 * @param tipo
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param edad
	 * @param alias
	 * @param numlikesR
	 * @param ingresos
	 * @return cadena de texto donde guarda la informacion del usuario de forma
	 *         ascendente
	 */
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
				asc = numlikesR.get(i) + "   " + nombre.get(i) + "  " + apellido1.get(i) + "  " + apellido2.get(i)
						+ "  " + edad.get(i) + "  " + alias.get(i) + "  " + ingresos.get(i) + "\n";
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

	/**
	 * Metodo que organiza la informacion de usuario segun nombre, apellido, edad,
	 * alias, numero de likes e ingresos y los muestra de forma descendente
	 * 
	 * @param tipo
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param edad
	 * @param alias
	 * @param numlikesR
	 * @param ingresos
	 * @return cadena de texto donde guarda la informacion del usuario de forma
	 *         descendente
	 */
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

	/**
	 * Metodo que busca dentro de la datos.csv los usuarios con mayor numero de
	 * likes y hace un top 10 con esa informacion
	 * 
	 * @param tipo
	 * @param tipo2
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param edad
	 * @param alias
	 * @param numlikesR
	 * @param ingresos
	 * @return String con el top 10 de usuarios con mas likes de datos.csv 
	 */
	public String top10(String tipo, String tipo2, ArrayList<String> nombres, ArrayList<String> apellidos1,
			ArrayList<String> apellidos2, ArrayList<Integer> edades, ArrayList<String> aliases, ArrayList<Integer> numslikesR,
			ArrayList<Double> ingresoss) {
		String top = "";
		int pos = 0;
		ArrayList<String> nombre = (ArrayList<String>) nombres.clone();
		ArrayList<Integer> numlikesR = (ArrayList<Integer>) numslikesR.clone();
		ArrayList<String> apellido1 = (ArrayList<String>) apellidos1.clone();
		ArrayList<String> apellido2 = (ArrayList<String>) apellidos2.clone();
		ArrayList<Integer> edad = (ArrayList<Integer>) numslikesR.clone();
		ArrayList<String> alias = (ArrayList<String>) aliases.clone();
		ArrayList<Double> ingresos = (ArrayList<Double>) ingresoss.clone();
		ArrayList<Integer> likesOrdenados = new ArrayList<>();
		likesOrdenados = (ArrayList<Integer>) numslikesR.clone();
		ArrayList<String> nom = new ArrayList<>();
		Collections.sort(likesOrdenados, Collections.reverseOrder());
		System.out.println(numlikesR);
		System.out.println(likesOrdenados);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < numlikesR.size(); j++) {
				if (likesOrdenados.get(i) == numlikesR.get(j)) {
					pos = j;
					j = numlikesR.size();
				}
			}
			if (tipo.equals("Nombre") && tipo2.equals("Ascendente")) {
				top = nombre.get(pos) + "  " + numlikesR.get(pos) + "  " + apellido1.get(pos) + "  "
						+ apellido2.get(pos) + "  " + edad.get(pos) + "  " + alias.get(pos) + "  " + ingresos.get(pos)
						+ "  " + "\n";
				nom.add(top);
				Collections.sort(nom);
			} else if (tipo.equals("Nombre") && tipo2.equals("Descendente")) {
				top = nombre.get(pos) + "  " + numlikesR.get(pos) + "  " + apellido1.get(pos) + "  "
						+ apellido2.get(pos) + "  " + edad.get(pos) + "  " + alias.get(pos) + "  " + ingresos.get(pos)
						+ "  " + "\n";
				nom.add(top);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Apellido") && tipo2.equals("Ascendente")) {
				top = apellido1.get(pos) + "  " + apellido2.get(pos) + "  " + numlikesR.get(pos) + "  "
						+ nombre.get(pos) + "  " + edad.get(pos) + "  " + alias.get(pos) + "  " + ingresos.get(pos)
						+ "  " + "\n";
				nom.add(top);
				Collections.sort(nom);
			} else if (tipo.equals("Apellido") && tipo2.equals("Descendente")) {
				top = apellido1.get(pos) + "  " + apellido2.get(pos) + "  " + numlikesR.get(pos) + "  "
						+ nombre.get(pos) + "  " + edad.get(pos) + "  " + alias.get(pos) + "  " + ingresos.get(pos)
						+ "  " + "\n";
				nom.add(top);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Edad") && tipo2.equals("Ascendente")) {
				top = edad.get(pos) + "  " + numlikesR.get(pos) + "  " + nombre.get(pos) + "  " + apellido1.get(pos)
						+ "  " + apellido2.get(pos) + "  " + alias.get(pos) + "  " + ingresos.get(pos) + "  " + "\n";
				nom.add(top);
				Collections.sort(nom);
			} else if (tipo.equals("Edad") && tipo2.equals("Descendente")) {
				top = edad.get(pos) + "  " + numlikesR.get(pos) + "  " + nombre.get(pos) + "  " + apellido1.get(pos)
						+ "  " + apellido2.get(pos) + "  " + alias.get(pos) + "  " + ingresos.get(pos) + "  " + "\n";
				nom.add(top);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Alias") && tipo2.equals("Ascendente")) {
				top = alias.get(pos) + "  " + numlikesR.get(pos) + "  " + nombre.get(pos) + "  " + apellido1.get(pos)
						+ "  " + apellido2.get(pos) + "  " + edad.get(pos) + "  " + ingresos.get(pos) + "  " + "\n";
				nom.add(top);
				Collections.sort(nom);
			} else if (tipo.equals("Alias") && tipo2.equals("Descendente")) {
				top = alias.get(pos) + "  " + numlikesR.get(pos) + "  " + nombre.get(pos) + "  " + apellido1.get(pos)
						+ "  " + apellido2.get(pos) + "  " + edad.get(pos) + "  " + ingresos.get(pos) + "  " + "\n";
				nom.add(top);
				Collections.sort(nom, Collections.reverseOrder());
			} else if (tipo.equals("Likes") && tipo2.equals("Ascendente")) {
				top = numlikesR.get(pos) + "  " + nombre.get(pos) + "  " + apellido1.get(pos) + "  "
						+ apellido2.get(pos) + "  " + edad.get(pos) + "  " + alias.get(pos) + "  " + ingresos.get(pos)
						+ "  " + "\n";
				nom.add(top);
				Collections.sort(nom);
			} else if (tipo.equals("Likes") && tipo2.equals("Descendente")) {
				top = numlikesR.get(pos) + "  " + nombre.get(pos) + "  " + apellido1.get(pos) + "  "
						+ apellido2.get(pos) + "  " + edad.get(pos) + "  " + alias.get(pos) + "  " + ingresos.get(pos)
						+ "  " + "\n";
				nom.add(top);
				Collections.sort(nom, Collections.reverseOrder());
			}
			nombre.remove(pos);
			numlikesR.remove(pos);
			apellido1.remove(pos);
			apellido2.remove(pos);
			edad.remove(pos);
			alias.remove(pos);
			ingresos.remove(pos);
		}
		int h = 0;
		String g = "";
		while (h < 10) {
			g += nom.get(h);
			h++;
		}
		return g;
	}
}