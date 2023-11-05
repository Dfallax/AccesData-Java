package Examen;

public class Coche {

	private String matricula;
	private String marca;
	private String modelo;
	private Persona idPropietario;
	
	
	
	public Coche(String matricula, String marca, String modelo, Persona idPropietario) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.idPropietario = idPropietario;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Persona getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(Persona idPropietario) {
		this.idPropietario = idPropietario;
	}
	
		public String toString() {
		
		
		return matricula+","+ marca +","+ modelo+ ","+  idPropietario.getId();
	}
	public String xml() {
		
		return "<coche><matricula>"+matricula+"</matricula><marca>"+marca+"</marca><modelo>"+modelo+"</modelo>"+"</coche>";
	}
}
