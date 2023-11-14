package clase;

public class Ubicacion {

	private String localidad;
	private String calle;
	private int numero;
	private char letra;
	public Ubicacion(String localidad, String calle, int numero, char letra) {
		super();
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.letra = letra;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	
	
}
