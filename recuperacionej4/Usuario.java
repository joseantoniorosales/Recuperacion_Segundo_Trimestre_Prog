package recuperacionej4;

public class Usuario extends Persona implements Cliente {

	private String tlf;
	
	// Constructor de la clase Persona

	public Usuario(Persona n, Persona em) {
		super(n, em);

	}
	
	// Constructor principal

	public Usuario(String nombre, String email, String tlf) {
		super(nombre, email);

		this.tlf = tlf;

	}
	
	// Getters y Setters

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	
	// Metodo compra: Usando el metodo addCompra de Comercial, el usuario añade a un comercial un articulo vendido

	@Override
	public void compra(Comercial comercial, Articulo articulo) {

		comercial.addCompra(articulo);

	}

}
