package observatorio.domain;

public class Montura {

	private String id;
	private String marca;
	private String modelo;
	private String tipoMontura;
	private String estadoEquipamiento;
	private boolean motorizada;
	
	// Constructor
	public Montura(String id, String marca, String modelo, String tipoMontura, String estadoEquipamiento, boolean motorizada) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoMontura = tipoMontura;
		this.estadoEquipamiento = estadoEquipamiento;
		this.motorizada = motorizada;
	}

	
	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String getTipoMontura() {
		return tipoMontura;
	}

	public void setTipoMontura(String tipoMontura) {
		this.tipoMontura = tipoMontura;
	}

	public String getEstadoEquipamiento() {
		return estadoEquipamiento;
	}

	public void setEstadoEquipamiento(String estadoEquipamiento) {
		this.estadoEquipamiento = estadoEquipamiento;
	}

	public boolean isMotorizada() {
		return motorizada;
	}

	public void setMotorizada(boolean motorizada) {
		this.motorizada = motorizada;
	}
	
	
	
	
}
