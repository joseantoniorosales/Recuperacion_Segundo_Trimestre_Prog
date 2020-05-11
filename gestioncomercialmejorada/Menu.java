package gestioncomercialmejorada;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {

	public Scanner s = new Scanner(System.in);

	/* Permite la salida de datos. Usado para imprimir el menu por pantalla en el main */
	
	public PrintStream salidaMain;

	public ComercialList comercialList = new ComercialList();
	public ClientList clientList = new ClientList();
	// public ArticleList articleList = new ArticleList();

	// Datos para testeo

	public void data() {

		clientList.add(new Usuario("Jose Ant", "joseantrosales2002@gname.com", "685755343"));
		clientList.add(new Usuario("Antonio", "ibame7@gname.com", "644892384"));
		clientList.add(new Usuario("Ramon", "ramonwahl@gname.com", "655031572"));

		comercialList.add(new Comercial("Pepe", "pepeEjemplo@gname.com", "vendedor textil"));
		comercialList.add(new Comercial("Alejandro", "alejandroEjemplo@gname.com", "vendedor informático"));
		comercialList.add(new Comercial("Mario", "marioEjemplo@gname.com", "vendedor general de cuarentena"));
	}

	// Imprime el menu de opciones para elegir

	public void options() {

		System.out.println("PROGRAMA DE GESTIÓN DE VENTAS DE USUARIO");
		System.out.println("========================================");

		System.out.println(
				"Elija una de las siguientes opciones (Escribe el nombre de la opcion que" + " quieres utilizar)");

		System.out.println("-------------------------------");
		System.out.println("1.- Lista (Comercial / Cliente)");
		System.out.println("-------------------------------");

		System.out.println("-------------------------------");
		System.out.println("2.- Añadir (Comercial / Cliente)");
		System.out.println("-------------------------------");

		System.out.println("--------------------------------");
		System.out.println("3.- Borrar (Comercial / Cliente)");
		System.out.println("--------------------------------");

		System.out.println("-----------------------------------");
		System.out.println("4.- Modificar (Comercial / Cliente)");
		System.out.println("-----------------------------------");

		System.out.println("-------------------------------");
		System.out.println("5.- Comprar");
		System.out.println("-------------------------------");

		System.out.println("-------------------------------");
		System.out.println("6.- Menu (hace aparecer de nuevo las opciones)");
		System.out.println("-------------------------------");

		System.out.println("-------------------------------");
		System.out.println("7.- Salir");
		System.out.println("-------------------------------");
	}

	// Constructor
	
	public Menu(Scanner s, PrintStream salidaMain) {

		this.s = s;

		this.salidaMain = salidaMain;
	}

	// Comprueba si se han pasado los parametros correctos en las opciones

	public boolean comprOpcion(String[] opcion) {

		// Si la opcion no tiene 2 parametros introducidos, no se puede continuar

		if (opcion.length < 2) {

			return false;
		}
		
		// Devuelve la funcion especifica de cliente o comercial

		return opcion[1].equals("cliente") || opcion[1].equals("comercial");
	}

	// Analiza la linea introducida y devuelve la misma

	public String readAndWrite(String intro) {

		System.out.print(intro);

		return s.nextLine();
	}

	// Separa comandos

	public String[] split(String intro) {

		/* separa los datos introducidos para poder diferenciar entre las funciones de cliente y comercial.
		 * Se usa .split(parametro para dividir)
		*/
		
		return readAndWrite(intro).split(" ");
	}

	// Añadir comerciales

	public void addComercial(String[] opcion) {

		/* Si se introducen 2 parametros (más tarde se comprueba si son los correctos en la funcion conjunta)
		 * se pedirán los datos para añadir un comercial (nombre, correo y cargo)
		*/
		
		if (opcion.length == 2) {

			String nomComer = readAndWrite("nombre: ");
			String mailComer = readAndWrite("correo: ");
			String cargoComer = readAndWrite("cargo: ");

			comercialList.add(new Comercial(nomComer, mailComer, cargoComer));
		}
	}

	// Añadir clientes

	public void addClient(String[] opcion) {
		
		/* Si se introducen 2 parametros (más tarde se comprueba si son los correctos en la funcion conjunta)
		 * se pedirán los datos para añadir un cliente (nombre, correo y telefono)
		*/

		if (opcion.length == 2) {

			String nomClient = readAndWrite("nombre: ");
			String mailClient = readAndWrite("correo: ");
			String tlfClient = readAndWrite("telefono: ");

			clientList.add(new Usuario(nomClient, mailClient, tlfClient));
		}

	}
	
	// Funcion no implementada para añadir articulos

	/* public void addArticle(String[] opcion) {
		
		if (opcion.length == 2) {
			
			String nomArt = readAndWrite("nombre: ");
			String cantArt = readAndWrite("cantidad: ");
			String precArt = readAndWrite("precio: ");
			
			art
		}
	 
	}
 */
	
	// Funcion añadir

	public void add(String[] opcion) {
		
		/* Se comprueba si la opcion introducida es valida. Si lo es, se insta al usuario ha introducir
		 * a quien quiere aplicar la operacion (comercial o cliente) */

		if (!comprOpcion(opcion)) {

			System.out.println("Debes introducir o bien -comercial- o bien -cliente-");

			return;

		}

		if (opcion[1].equals("cliente")) {

			addClient(opcion);

		} else {

			addComercial(opcion);
		}
	}

	// Lista de comerciales

	public void listComer(String[] opcion) {

		for (String name : comercialList.nombre()) {

			System.out.println(comercialList.get(name));

		}
	}

	// Lista de clientes

	public void listClient(String[] opcion) {

		for (String name : clientList.nombre()) {

			System.out.println(clientList.get(name));

		}
	}

	// Funcion listado

	public void list(String[] opcion) {

		/* Se comprueba si la opcion introducida es valida. Si lo es, se insta al usuario ha introducir
		 * a quien quiere aplicar la operacion (comercial o cliente) */
		
		if (!comprOpcion(opcion)) {

			System.out.println("Debes introducir o bien -comercial- o bien -cliente-");

			return;

		}

		if (opcion[1].equals("cliente")) {

			listClient(opcion);

		} else {

			listComer(opcion);
		}
	}

	// Borrar comerciales

	public void delComer(String[] opcion) {
		
		/* Si se introducen 2 parametros (más tarde se comprueba si son los correctos en la funcion conjunta)
		 * se pedirá el nombre (clave) del comercial para borrarlo */

		if (opcion.length == 2) {

			String nameComer = readAndWrite("nombre del comercial: ");

			comercialList.del(nameComer);
		}
	}

	// Borrar cliente

	public void delClient(String[] opcion) {
		
		/* Si se introducen 2 parametros (más tarde se comprueba si son los correctos en la funcion conjunta)
		 * se pedirá el nombre (clave) del cliente para borrarlo */

		if (opcion.length == 2) {

			String nameClient = readAndWrite("nombre del cliente: ");

			clientList.del(nameClient);

		}

	}

	// Funcion de borrado

	public void del(String[] opcion) {
		
		/* Se comprueba si la opcion introducida es valida. Si lo es, se insta al usuario ha introducir
		 * a quien quiere aplicar la operacion (comercial o cliente) */

		if (!comprOpcion(opcion)) {

			System.out.println("Debes introducir o bien -comercial- o bien -cliente-");

			return;
		}

		if (opcion[1].equals("cliente")) {

			delClient(opcion);
			
		} else {

			delComer(opcion);
		}
	}

	// Modificar comerciales

	public void modComer(String[] opcion) {

		/* Si se introducen 2 parametros (más tarde se comprueba si son los correctos en la funcion conjunta)
		 * se pedirán el nombre (clave) del cliente para a continuación pedirle el dato que desea cambiar
		 * y el nuevo valor del mismo */
		
		if (opcion.length == 2) {

			String nameComer = readAndWrite("nombre del comercial: ");
			String datoMod = readAndWrite("dato que quiere modificar: ");
			String datoModValue = readAndWrite("nuevo valor del dato: ");

			Comercial comer = comercialList.get(nameComer);

			if (comer == null) {

				System.out.println("No existe ese comercial");
				return;
			}

			switch (datoMod.toLowerCase()) {

			case "nombre":

				comer.setNombre(datoModValue);

				break;

			case "correo":

				comer.setEmail(datoModValue);
				break;

			case "cargo":

				comer.setCargo(datoModValue);
				break;

			default:
				break;
			}
		}
	}

	// Modificar clientes

	public void modClient(String[] opcion) {
		
		/* Si se introducen 2 parametros (más tarde se comprueba si son los correctos en la funcion conjunta)
		 * se pedirán el nombre (clave) del comercial para a continuación pedirle el dato que desea cambiar
		 * y el nuevo valor del mismo */

		if (opcion.length == 2) {

			String nameClient = readAndWrite("nombre del cliente: ");
			String datoMod = readAndWrite("dato que quiere modificar: ");
			String datoModValue = readAndWrite("nuevo valor del dato: ");

			Usuario client = clientList.get(nameClient);

			if (client == null) {

				System.out.println("No existe ese cliente");
				return;
			}

			switch (datoMod.toLowerCase()) {

			case "nombre":

				client.setNombre(datoModValue);

				break;

			case "correo":

				client.setEmail(datoModValue);
				break;

			case "telefono":

				client.setTlf(datoModValue);
				break;

			default:
				break;
			}
		}
	}

	// Funcion modificar

	public void mod(String[] opcion) {
		
		/* Se comprueba si la opcion introducida es valida. Si lo es, se insta al usuario ha introducir
		 * a quien quiere aplicar la operacion (comercial o cliente) */

		if (!comprOpcion(opcion)) {

			System.out.println("Debes introducir o bien -comercial- o bien -cliente-");
			return;
		}

		if (opcion[1].equals("cliente")) {

			modClient(opcion);
		} else {

			modComer(opcion);
		}
	}

	// Funcion comprar

	public void buy(String[] opcion) {
		
		/* Si se introduce menos de un parametro no se procede a la funcion */

		if (opcion.length < 1) {

			return;

		}
		
		/* Si se introduce un parametro (comprar) se pide el nombre del comercial */

		if (opcion.length == 1) {

			String nameComer = readAndWrite("nombre del comercial: ");

			if (comercialList.get(nameComer) == null) {

				System.out.println("Ese comercial no esta registrado, pruebe otro: ");
				return;
			}
			
			/* Se pide el nombre del producto a comprar, la cantidad del mismo y su precio (ambos parseados)
			 * a String) y se añade a las ventas del comercial
			*/

			String nomProduct = readAndWrite("Nombre del producto: ");
			String stringCantProduct = readAndWrite("Cantidad del producto: ");
			String stringPrecProduct = readAndWrite("Precio del producto: ");

			int cantProduct = Integer.parseInt(stringCantProduct);
			double precProductTotal = Double.parseDouble(stringPrecProduct);

			Articulo art = new Articulo(nomProduct, cantProduct, precProductTotal);

			Comercial comer = comercialList.get(nameComer);

			comer.addCompra(art);

		}
	}

	// Menu principal

	public void mainMenuStart() {
		
		// Inicializa la función data(), añadiendo los datos preestablecidos al ejecutarse

		data();
		
		// Imprime por pantalla el menu de opciones

		options();

		while (true) {

			String[] opcion = split("Escribe la opcion que deseas: ");
			
			System.out.println();

			switch (opcion[0].toLowerCase()) {

			case "lista":

				list(opcion);

				break;

			case "añadir":

				add(opcion);

				break;

			case "modificar":

				mod(opcion);

				break;

			case "borrar":

				del(opcion);

				break;

			case "comprar":

				buy(opcion);

				break;

			case "menu":

				options();

				break;

			case "salir":

				return;

			default:

				System.out.println("Comando no reconocido\n");

				options();

			}

		}
	}

}
