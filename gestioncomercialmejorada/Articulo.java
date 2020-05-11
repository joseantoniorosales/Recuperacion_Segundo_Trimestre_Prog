package gestioncomercialmejorada;

public class Articulo {

	

	protected String nombreArt;
	private int cantidad;
	private double precio;

	public Articulo(String nombreArt, int cantidad, double precio) {
		super();
		this.nombreArt = nombreArt;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getNombre() {
		return nombreArt;
	}

	public void setNombre(String nombre) {
		this.nombreArt = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void addArt(int cant) {
		this.cantidad = cant;
	}
	
	@Override
	public String toString() {
		return nombreArt + ", " + cantidad + " uds "  + "precio " + precio + "€";
	}

}
