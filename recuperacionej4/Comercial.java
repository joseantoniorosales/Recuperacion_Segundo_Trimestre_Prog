package recuperacionej4;

import java.util.ArrayList;

public class Comercial extends Persona {

	private String cargo;

	private ArrayList<Articulo> listaVendido = new ArrayList<Articulo>();
	
	// Constructor principal

	public Comercial(String nombre, String email, String cargo, ArrayList<Articulo> listaVendido) {
		
		super(nombre, email);
		
		this.cargo = cargo;
		this.listaVendido = listaVendido;
	}
	
	// Constructor para la clase Persona

	public Comercial(Persona nombre2, Persona email2) {
		
		super(nombre2, email2);
		
	}

	// Constructor para añadir comerciales
	
	public Comercial(String nombre, String email, String cargo) {
		
		super(nombre, email);
		
		this.cargo = cargo;
	}

	public String getCargo() {
		
		return cargo;
	}

	public void setCargo(String cargo) {
		
		this.cargo = cargo;
	}

	/* Metodo addCompra: Añade un articulo a las ventas de un cliente
	*/
	
	public void addCompra(Articulo art) {

		for (Articulo articulo : listaVendido) {

			if (articulo.getNombre().equals(art.getNombre())) {

				articulo.addArt(art.getCantidad());

			}

		}

		listaVendido.add(art);

	}

	@Override
	public String toString() {
		String imprime = "nombre: " + this.getNombre() + "\n" + "e-mail: " + super.getEmail() + "\n" + "cargo: " + this.getCargo()
				+ "\n" + "ventas realizadas" + "\n" + "==========================" + "\n\n";
		
		for (Articulo articulo : listaVendido) {
			
			imprime += articulo;
			
		}
		
		return imprime + "\n";
	}
	
	

}
