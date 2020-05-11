package recuperacionej2;

import java.util.ArrayList;
import java.util.Arrays;

public class Ej2 {

	public static void main(String[] args) {

		ArrayList<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		ArrayList<Integer> lista2 = new ArrayList<>(Arrays.asList(11, 22, 14, 35));
		ArrayList<Integer> lista3 = new ArrayList<>();

		System.out.println("Lista 1 + lista 2: " + mezclaListas(lista1, lista2));
		System.out.println("Lista 2 + lista 1: " + mezclaListas(lista2, lista1));
		System.out.println("Lista 1 + lista 3: " + mezclaListas(lista1, lista3));
		System.out.println("Lista 2 + lista 3: " + mezclaListas(lista2, lista3));

	}

	public static ArrayList<Integer> mezclaListas(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		
		ArrayList<Integer> listaMezclada = new ArrayList<>();

		
		int size1 = a1.size();
		int size2 = a2.size();
		int i = 0;

		do {
			
			// Si i es menor que el tamaño de la primera lista se añade a la nueva lista
			
			if (i < size1) {
				
				listaMezclada.add(a1.get(i));
			}
			
			// Si i es menor que el tamaño de la segunda lista se añade a la nueva lista

			if (i < size2) {
				
				listaMezclada.add(a2.get(i));
			}

			i++;
			
			// Mientras que i sea menor a la primera lista o a la segunda se mezclaran las listas

		} while ((i < size1) || (i < size2));

		return listaMezclada;
	}

}
