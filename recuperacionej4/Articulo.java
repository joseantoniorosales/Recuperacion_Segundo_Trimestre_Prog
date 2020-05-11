package recuperacionej4;

public class Articulo {

	

	protected String nombreArt;
	private int cantidad;

	public Articulo(String nombreArt, int cantidad) {
		super();
		this.nombreArt = nombreArt;
		this.cantidad = cantidad;
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
	
	public void addArt(int cant) {
		this.cantidad = cant;
	}
	
	@Override
	public String toString() {
		return nombreArt + ", " + cantidad + " uds " + " / ";
	}

}
