package main2;

import java.util.ArrayList;

public class Persona {

	private int id;
	private String nombre;
	private ArrayList<String> apellidos;
	private int edad;
	private String image;
	
	public Persona(int id, String nombre, ArrayList<String> apellidos, int edad, String image) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getApellidos() {
		return apellidos;
	}

	public void setApellidos(ArrayList<String> apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
