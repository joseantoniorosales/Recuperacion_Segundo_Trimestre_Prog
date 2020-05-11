	package recuperacionej3;

	import java.util.Objects;

	

		
		public class Articulo implements Comparable<Articulo> {
			
			  private String cod = "LIBRE";
			  private String nombre;
			  private double precComp;
			  private double precVenta;
			  private int stock;
			  
			  public Articulo(String cod) {
			    this.cod = cod;
			  }
			  
			  public Articulo(String cod, String nombre, double precComp, double precVenta, int stock) {
			    
				this.cod = cod;
			    this.nombre = nombre;
			    this.precComp = precComp;
			    this.precVenta = precVenta;
			    this.stock = stock;
			  }
			  
			  public String getcod() {
			    
				  return cod;
			  }

			  public void setcod(String cod) {
			    
				  this.cod = cod;
			  }

			  public String getnombre() {
			    
				  return nombre;
			  }

			  public void setnombre(String nombre) {
			    
				  this.nombre = nombre;
			  }

			  public double getprecComp() {
			    
				  return precComp;
			  }

			  public void setprecComp(double precComp) {
			    
				  this.precComp = precComp;
			  }

			  public double getprecVenta() {
			    
				  return precVenta;
			  }

			  public void setprecVenta(double precVenta) {
			    
				  this.precVenta = precVenta;
			  }

			  public int getStock() {
			    
				  return stock;
			  }

			  public void setStock(int stock) {
			    
				  this.stock = stock;
			  }

			  public String toString() {
			    
				  String cadena = "------------------------------------------";
			    cadena += "\nCódigo: " + this.cod;
			    cadena += "\nDescripción: " + this.nombre;
			    cadena += "\nPrecio de compra: " + this.precComp;
			    cadena += "\nPrecio de venta: " + this.precVenta;
			    cadena += "\nStock: " + this.stock + " unidades";
			    cadena += "\n------------------------------------------";
			    
			    return cadena;
			  }

			  @Override
			  public int hashCode() {
			    
				  int hash = 7;
			    hash = 73 * hash + Objects.hashCode(this.cod);
			    return hash;
			  }

			  @Override
			  public boolean equals(Object obj) {
			    if (this == obj) {
			      return true;
			    }
			    if (obj == null) {
			      return false;
			    }
			    if (getClass() != obj.getClass()) {
			      return false;
			    }
			    final Articulo other = (Articulo) obj;
			    if (!Objects.equals(this.cod, other.cod)) {
			      return false;
			    }
			    return true;
			  }

			  @Override
			  public int compareTo(Articulo t) {
			    
				  return (this.cod).compareTo(t.cod);
			  }
			}


	
	

