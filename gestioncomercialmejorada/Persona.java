package gestioncomercialmejorada;

public abstract class Persona {

	protected String nombre;
	protected String email;

	public Persona(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}

	public Persona(Persona nombre2, Persona email2) {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
