package Examen;

public class Persona {

	private String nombre;
	private int id;
	private String telefono;
	public Persona(String id, String nombre,  String telefono) {
		super();
		this.nombre = nombre;
		this.id = Integer.parseInt(id);
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String toString() {
		
		
		return id+","+ nombre +","+ telefono ;
	}
}
