package gestioncomercialmejorada;

public class Usuario extends Persona implements Cliente {

	private String tlf;

	public Usuario(Persona n, Persona em) {
		super(n, em);

	}

	public Usuario(String nombre, String email, String tlf) {
		super(nombre, email);

		this.tlf = tlf;

	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	
	

	@Override
	public void compra(Comercial comercial, Articulo articulo) {

		comercial.addCompra(articulo);

	}

	@Override
	public String toString() {
		
		String imprime = "nombre: " + getNombre() + "\n correo: " + getEmail() + "\n telefono: " + getTlf();
				
				return imprime + "\n";
	
	}
	
	

}
