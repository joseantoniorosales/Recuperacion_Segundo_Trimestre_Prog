package recuperacionej4;

public class Empresa extends Persona implements Cliente {

	private String CIF;
	private String tlf;

	// Constructor

	public Empresa(String nombre, String cIF, String tlf) {
		super(nombre, tlf);
		CIF = cIF;
		this.tlf = tlf;
	}

	/*
	 * Metodo compra: Usando el metodo addCompra, la empresa añade a un comercial un articulo vendido
	 */

	@Override
	public void compra(Comercial comercial, Articulo articulo) {

		comercial.addCompra(articulo);

	}

}
