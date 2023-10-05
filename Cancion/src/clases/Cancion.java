package clases;

public class Cancion {

	private int id;
	private String titulo;
	private String artista;
	private String duracion;
	private String album;
	private String letra;

	public Cancion(int id, String titulo, String artista, String duracion, String album, String letra) {
		this.id=id;
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
		this.album = album;
		this.letra = letra;
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {

		return id + "," + titulo + "," + artista + "," + duracion + "," + album + "," + letra;

	}

}
