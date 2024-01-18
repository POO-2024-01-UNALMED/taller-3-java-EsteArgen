package taller3.televisores;

public class Marca {
	private String nombre;
	
	public Marca(String nombre) {
		this.setNombre(nombre);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}