package gestioncomercialmejorada;

import java.util.Scanner;

public class GestionMain {

	public static void main(String[] args) {
		
		Scanner s = new Scanner (System.in);
		
		Menu menu = new Menu (s, System.out);
		
		menu.mainMenuStart();
		
	}
}
