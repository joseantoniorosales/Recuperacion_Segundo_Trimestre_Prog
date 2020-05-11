package recuperacionej3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ej3v3 {

	public static void main(String[] args) throws InterruptedException {

		Scanner s = new Scanner(System.in);

		int opcion;
		int primeraLibre;
		int i;

		int stockInt;

		double precCompInt;
		double precVentaInt;

		String codigo;
		String codInt = "";

		String nomInt;

		String precCompIntString;
		String precVentaIntString;
		String stockIntString;

		boolean existeCodigo;

		// Crea el array de artículos

		ArrayList<Articulo> articulo = new ArrayList<>();

		articulo.add(new Articulo("A", "Calculadora", 5, 7, 30));
		articulo.add(new Articulo("B", "Boligrafo borrable", 2, 5, 100));
		articulo.add(new Articulo("C", "Aprende Java con ejercicios", 10, 15, 60));
		articulo.add(new Articulo("D", "Escuadra", 4, 6, 21));
		articulo.add(new Articulo("E", "Tarjeta SD 64 GB", 10, 17, 20));

		// Menu

		do {

			System.out.println("\n\nG E S T I S I M A L");
			System.out.println("===================");
			System.out.println("1. Listado");
			System.out.println("2. Añadir articulo");
			System.out.println("3. Eliminar articulo");
			System.out.println("4. Modificación");
			System.out.println("5. Entrada de mercancía (+stock)");
			System.out.println("6. Venta (-stock)");
			System.out.println("7. Listado de artículos bajos de stock");
			System.out.println("8. Salir");
			System.out.print("Introduzca una opción: ");
			opcion = Integer.parseInt(s.nextLine());

			switch (opcion) {

			// LISTADO

			case 1:

				System.out.println("\nLISTADO");
				System.out.println("=======");

				int numArt = 0;
				double precCompTotal = 0;
				double precVentaTotal = 0;

				Collections.sort(articulo);

				for (Articulo aux : articulo) {

					System.out.println(aux);
					numArt++;

					precCompTotal += aux.getprecComp();
					precVentaTotal += aux.getprecVenta();
				}

				double precCompMed = precCompTotal / numArt;
				double precVentaMed = precVentaTotal / numArt;
				double beneficioMed = precVentaMed - precCompMed;

				System.out.println("\nNúmero total de artículos: " + numArt);
				System.out.println("Precio de compra medio: " + String.format("%.2f", precCompMed));
				System.out.println("Precio de venta medio: " + String.format("%.2f", precVentaMed));
				System.out.println("Margen de beneficio medio: " + String.format("%.2f", beneficioMed));

				break;

			// AÑADIR

			case 2:

				System.out.println("\nNUEVO ARTÍCULO");
				System.out.println("==============");

				// Introducción de datos

				System.out.println("Por favor, introduzca los datos del artículo.");
				System.out.print("Código: ");
				codInt = s.nextLine();

				// Comprueba que el código introducido no se repita

				while (articulo.contains(new Articulo(codInt))) {
					System.out.println("Ese código ya existe en la base de datos.");
					System.out.print("Introduzca otro código: ");
					codInt = s.nextLine();
				}

				System.out.print("Nombre: ");
				nomInt = s.nextLine();

				System.out.print("Precio de compra: ");
				precCompInt = Double.parseDouble(s.nextLine());

				System.out.print("Precio de venta: ");
				precVentaInt = Double.parseDouble(s.nextLine());

				System.out.print("Stock: ");
				stockInt = Integer.parseInt(s.nextLine());

				articulo.add(new Articulo(codInt, nomInt, precCompInt, precVentaInt, stockInt));

				break;

			// BORRAR

			case 3:

				System.out.println("\nBAJA");
				System.out.println("====");

				System.out.print("Por favor, introduzca el código del artículo que desea dar de baja: ");
				codInt = s.nextLine();

				if (!articulo.contains(new Articulo(codInt))) {

					System.out.println("Lo siento, el código introducido no existe");

				} else {

					articulo.remove(new Articulo(codInt));
					System.out.println("Artículo eliminado");
				}

				break;

			// MODIFICACION
			case 4:
				System.out.println("\nMODIFICACIÓN");
				System.out.println("============");

				System.out.print("Por favor, introduzca el código del artículo cuyos datos desea cambiar: ");
				codInt = s.nextLine();

				if (!articulo.contains(new Articulo(codInt))) {

					System.out.println("El código introducido no existe.");

				} else {

					i = articulo.indexOf(new Articulo(codInt));

					System.out.println("Introduzca los nuevos datos del artículo o INTRO para dejarlos igual.");

					System.out.println("Código: " + articulo.get(i).getcod());
					System.out.print("Nuevo código: ");
					codInt = s.nextLine();

					if (!codInt.equals("")) {

						articulo.get(i).setcod(codInt);
					}

					System.out.println("nombre: " + articulo.get(i).getnombre());
					System.out.print("Nuevo nombre: ");
					nomInt = s.nextLine();

					if (!nomInt.equals("")) {

						articulo.get(i).setnombre(nomInt);
					}

					System.out.println("Precio de compra: " + articulo.get(i).getprecComp());
					System.out.print("Nuevo precio de compra: ");
					precCompIntString = s.nextLine();

					if (!precCompIntString.equals("")) {

						articulo.get(i).setprecComp(Double.parseDouble(precCompIntString));
					}

					System.out.println("Precio de venta: " + articulo.get(i).getprecVenta());
					System.out.print("Nuevo precio de venta: ");
					precVentaIntString = s.nextLine();

					if (!precVentaIntString.equals("")) {

						articulo.get(i).setprecVenta(Double.parseDouble(precVentaIntString));
					}

					System.out.println("Stock: " + articulo.get(i).getStock());
					System.out.print("Nuevo stock: ");
					stockIntString = s.nextLine();

					if (!stockIntString.equals("")) {

						articulo.get(i).setStock(Integer.parseInt(stockIntString));
					}
				}
				break;

			// ENTRADA DE MERCANCIA

			case 5:
				System.out.println("\nENTRADA DE MERCANCÍA");
				System.out.println("====================");

				System.out.print("Por favor, introduzca el código del artículo: ");
				codInt = s.nextLine();

				i = articulo.indexOf(new Articulo(codInt));

				if (!articulo.contains(new Articulo(codInt))) {
					System.out.println("Lo siento, el código introducido no existe.");
				} else {
					System.out.println("Entrada de mercancía del siguiente artículo: ");
					System.out.println(articulo.get(i));
					System.out.print("Introduzca el número de unidades que entran al almacén: ");
					stockIntString = s.nextLine();
					articulo.get(i).setStock(Integer.parseInt(stockIntString) + articulo.get(i).getStock());
					System.out.println("La mercancía ha sido registrada exitosamente.");
				}

				break;

			// VENTA

			case 6:

				System.out.println("\nVENTA");
				System.out.println("=====");

				System.out.print("Por favor, introduzca el código del artículo: ");
				codInt = s.nextLine();

				i = articulo.indexOf(new Articulo(codInt));

				if (!articulo.contains(new Articulo(codInt))) {

					System.out.println("Lo siento, el código introducido no existe.");

				} else {

					System.out.println("Venta del siguiente artículo: ");
					System.out.println(articulo.get(i));
					System.out.print("Introduzca el número de unidades que desea vender: ");
					stockInt = Integer.parseInt(s.nextLine());

					if (articulo.get(i).getStock() - stockInt > 0) {

						articulo.get(i).setStock(articulo.get(i).getStock() - stockInt);

						System.out.println("La venta ha sido realizada.");

						System.out.print("Generando factura");

						double precSinIva = (articulo.get(i).getprecVenta()) * stockInt;
						double iva = ((articulo.get(i).getprecVenta()) * (stockInt)) * 0.21;

						System.out.println("\n\nFACTURA DE VENTA");
						System.out.println("================");
						System.out.println("Cod. Articulo: " + codInt);
						System.out.println("Precio: " + String.format("%.2f", articulo.get(i).getprecVenta()) + "€");
						System.out.println("Cantidad: " + stockInt);
						System.out.println("Precio sin IVA: " + String.format("%.2f", precSinIva) + "€");
						System.out.println("IVA: " + String.format("%.2f", iva) + "€");
						System.out.println("----------------------");
						System.out.println("Precio Final: " + String.format("%.2f", (precSinIva + iva)) + "€");

					} else {

						System.out.println("Te has pasado del limite de unidades permitidas.");
					}
				}

				break;
			case 7:

				System.out.print("Introduce el stock máximo: ");
				int stockMaximo = Integer.parseInt(s.nextLine());

				System.out.println("LISTADO POR STOCK");
				System.out.println("=================");

				for (Articulo aux : articulo) {

					if (aux.getStock() <= stockMaximo) {

						System.out.println(aux);
					}
				}

				break;

			} // switch
		} while (opcion != 8);

		s.close();
	}

}
