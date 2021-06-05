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
				ing += "Nombre " + nombre.get(i) + " -> " + ingresos.get(i) + "$USD\n";
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

	public String descendente(String tipo, ArrayList<String> nombre, ArrayList<String> apellido1,
			ArrayList<String> apellido2, ArrayList<Integer> edad, ArrayList<String> alias, ArrayList<Integer> numlikesR,
			ArrayList<Integer> numlikesO) {
		String des = "";
		String des2 = "";
		Collections.sort(nombre);
		Collections.sort(apellido1);
		Collections.sort(apellido2);
		Collections.sort(edad);
		Collections.sort(alias);
		Collections.sort(numlikesR);
		Collections.sort(numlikesO);
		if (tipo.equals("Nombre")) {
			for (String listaNombreO : nombre) {
				des += listaNombreO + "\n";
			}
		} else if (tipo.equals("Apellido")) {
			for (String listaApellido1O : apellido1) {
				des += "1 " + listaApellido1O;
			}
			for (String listaApellido2O : apellido2) {
				des2 += "2 " + listaApellido2O;
			}
		}else if(tipo.equals("Edad")) {
			
		}
		return des + " " + des2;
	}
}
