package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Mascota implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String especie;
	private String sexo;
	private int edad;
	private ArrayList<Cita> citas;
	
	public Mascota(int id, String nombre, String especie, String sexo, int edad, ArrayList<Cita> citas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.sexo = sexo;
		this.edad = edad;
		this.citas = citas;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", sexo=" + sexo + ", edad=" + edad
				+ ", citas=" + citas + "]";
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
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public ArrayList<Cita> getCitas() {
		return citas;
	}
	public void setCitas(ArrayList<Cita> citas) {
		this.citas = citas;
	}
	
	
	
}
