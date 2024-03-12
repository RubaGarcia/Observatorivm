package observatorio.domain;

public class ConsultaInventario {
	
	private String idTubo;
	private String estadoTubo;
	
	private String idMontura;
	private String estadoMontura;
	
	private String idOculat;
	private String estadoOcular;
	
	// Constructor
	public ConsultaInventario(String idTubo, String estadoTubo, String idMontura, String estadoMontura, 
			String idOculat, String estadoOcular) {
		super();
		this.setIdTubo(idTubo);
		this.setEstadoTubo(estadoTubo);
		this.setIdMontura(idMontura);
		this.setEstadoMontura(estadoMontura);
		this.setIdOculat(idOculat);
		this.setEstadoOcular(estadoOcular);
	}

	public String getIdTubo() {
		return idTubo;
	}

	public void setIdTubo(String idTubo) {
		this.idTubo = idTubo;
	}

	public String getEstadoTubo() {
		return estadoTubo;
	}

	public void setEstadoTubo(String estadoTubo) {
		this.estadoTubo = estadoTubo;
	}

	public String getIdMontura() {
		return idMontura;
	}

	public void setIdMontura(String idMontura) {
		this.idMontura = idMontura;
	}

	public String getEstadoMontura() {
		return estadoMontura;
	}

	public void setEstadoMontura(String estadoMontura) {
		this.estadoMontura = estadoMontura;
	}

	public String getIdOculat() {
		return idOculat;
	}

	public void setIdOculat(String idOculat) {
		this.idOculat = idOculat;
	}

	public String getEstadoOcular() {
		return estadoOcular;
	}

	public void setEstadoOcular(String estadoOcular) {
		this.estadoOcular = estadoOcular;
	}
	
	
}
