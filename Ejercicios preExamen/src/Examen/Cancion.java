package Examen;

import java.io.Serializable;

public class Cancion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String artista;
	private String album;
	private int duracion;
	
	
	
	public Cancion(String titulo, String artista, String album, int duracion) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.album = album;
		this.duracion = duracion;
	}
	public Cancion() {
		
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = Integer.parseInt(duracion);
	}
	
	
}
