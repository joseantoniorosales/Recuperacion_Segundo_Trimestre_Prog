package recuperacionej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int acierto = 0;
		int preguntas = 0;

		// HashMaps para guardar las palabras y los errores

		HashMap<String, String> palabras = new HashMap<String, String>();
		HashMap<String, String> errores = new HashMap<String, String>();

		// Palabras a preguntar

		palabras.put("raspberry", "frambuesa");
		palabras.put("house", "casa");
		palabras.put("car", "coche");
		palabras.put("apple", "manzana");
		palabras.put("green", "verde");
		palabras.put("wardrobe", "armario");
		palabras.put("water", "agua");
		palabras.put("hello", "hola");

		// Listas para guardar las palabras por separado segun su idioma

		List<String> wordsEng = new ArrayList<String>(palabras.keySet());

		List<String> wordsEsp = new ArrayList<String>(palabras.values());

		// Aleatorizacion de palabras por pregunta

		while (preguntas < 5) {

			// Palabras en ingles aleatorias
			
				/* Random().nextInt(n) permite generar un valor aleatorio de la lista entre 0 y el limite 
				 * impuesto */

			int randomValue = new Random().nextInt(wordsEng.size());
			String randomEng = wordsEng.get(randomValue);

			// Palabras en español aleatorias

			int randomKey = new Random().nextInt(wordsEng.size());
			String randomEs = wordsEsp.get(randomKey);

			// Pregunta con palabras aleatorias

			System.out.print("¿" + randomEng + " es " + randomEs + "? (y/n): ");
			char resp = s.next().toLowerCase().charAt(0);

			System.out.println();

			// Comprobacion de acierto/fallo

			if (palabras.get(randomEng).equals(randomEs)) {
				
				if (resp == 'y') {
					
					acierto++;
				
				} else {
				
					errores.put(randomEng, randomEs);
				}
			
			} else {
			
				if (resp == 'n') {
				
					acierto++;
				
				} else {
				
					errores.put(randomEng, palabras.get(randomEng));
				}
			}
			
			preguntas++;
		}

		// Imprime por pantalla los puntos y las soluciones a las respuestas falladas

		System.out.print("Puntos: " + acierto + "\n\nNo has acertado estas palabras: \n");
		
		for (String i : errores.keySet()) {
		
			System.out.println(i + " : " + errores.get(i));
		}

		/*
		 * Cierra el scanner (Eclipse me resalto que debia cerrarlo aunque hasta ahora
		 * no lo he estado haciendo y funcionaba igual)
		 */

		s.close();

	}

}
