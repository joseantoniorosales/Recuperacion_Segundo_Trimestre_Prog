package gestioncomercialmejorada;

import java.util.HashMap;
import java.util.Set;

public class ArticleList {

	private HashMap<String, Articulo> articleList = new HashMap<String, Articulo>();

	public Set<String> nombre() {

		return articleList.keySet();
	}

	public Articulo get(String nombre) {

		return articleList.get(nombre);
	}

	public void add(Articulo comer) {

		String name = comer.getNombre();
		articleList.put(name, comer);

	}

	public void del(String name) {

		articleList.remove(name);
	}
}
