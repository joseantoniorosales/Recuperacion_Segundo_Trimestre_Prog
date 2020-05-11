package gestioncomercialmejorada;

import java.util.HashMap;
import java.util.Set;

public class ComercialList {

	private HashMap<String, Comercial> comercialList = new HashMap<>();

	public Set<String> nombre() {

		return comercialList.keySet();
	}
	
	public Comercial get (String nombre) {
		
		return comercialList.get(nombre);
	}

	public void add(Comercial comer) {

		String name = comer.getNombre();
		comercialList.put(name, comer);

	}

	public void del(String name) {

		comercialList.remove(name);
	}

}
