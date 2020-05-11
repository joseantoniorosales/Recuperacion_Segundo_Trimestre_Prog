package gestioncomercialmejorada;

import java.util.HashMap;
import java.util.Set;

public class ClientList {

	private HashMap<String, Usuario> clientList = new HashMap<>();

	// Metodo que fija nombre como clave del HashMap clientList

	public Set<String> nombre() {

		return clientList.keySet();
	}

	// Metodo para añadir clientes a la lista

	public void add(Usuario user) {

		// Llama al metodo getNombre desde la clase Usuario

		String name = user.getNombre();

		clientList.put(name, user);

	}

	// Metodo para recibir el nombre del cliente

	public Usuario get(String nombre) {

		return clientList.get(nombre);
	}

	// Metodo para borrar clientes

	public void del(String name) {

		clientList.remove(name);
	}

}
