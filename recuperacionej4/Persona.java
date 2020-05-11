package recuperacionej4;

public abstract class Persona {

	protected String nombre;
	protected String email;
	
	// Constructor principal

	public Persona(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}
	
	// Constructor Persona

	public Persona(Persona nombre2, Persona email2) {

	}
	
	// Getters y Setters

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
