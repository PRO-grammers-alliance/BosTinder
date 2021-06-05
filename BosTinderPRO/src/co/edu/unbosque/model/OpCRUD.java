package co.edu.unbosque.model;

import java.util.ArrayList;

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
				ing += "Nombre " + nombre.get(i) + " -> " + ingresos.get(i) + "$USD\n";
			}
		}
		return ing;
	}

	public String generoM(int tam, ArrayList<String> genero, ArrayList<String> nombre) {
		String gen = "";
		int i = 0;
		while (i < tam) {
			gen += "Nombre: " + nombre.get(i) + " -> " + genero.get(i) + "\n";
			i++;
		}
		return gen;
	}
}
