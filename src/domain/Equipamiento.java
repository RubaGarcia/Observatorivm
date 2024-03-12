package observatorio.domain;

public class Equipamiento {

	private String id;
	private String idTubo;
	private String idOcular;
	private String idMontura;
	
	// Constructor
	public Equipamiento(String id, String idTubo, String idOcular, String idMontura) {
		super();
		this.id = id;
		this.idTubo = idTubo;
		this.idOcular = idOcular;
		this.idMontura = idMontura;
	}

	
	// Getters and Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdTubo() {
		return idTubo;
	}

	public void setIdTubo(String idTubo) {
		this.idTubo = idTubo;
	}

	public String getIdOcular() {
		return idOcular;
	}

	public void setIdOcular(String idOcular) {
		this.idOcular = idOcular;
	}

	public String getIdMontura() {
		return idMontura;
	}

	public void setIdMontura(String idMontura) {
		this.idMontura = idMontura;
	}

	
}