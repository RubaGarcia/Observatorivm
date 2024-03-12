package observatorio.domain;

public class Oculares {

	private String id;
	private float apertura;
	private float longitudFocal;
	private float campoVision;
	private String marca;
	private String modelo;
	private String estadoEquipamiento;
	
	// Constructor
	public Oculares(String id, float apertura, float longitudFocal, float campoVision, String marca, String modelo,
			String estadoEquipamiento) {
		super();
		this.id = id;
		this.apertura = apertura;
		this.longitudFocal = longitudFocal;
		this.campoVision = campoVision;
		this.marca = marca;
		this.modelo = modelo;
		this.estadoEquipamiento = estadoEquipamiento;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getApertura() {
		return apertura;
	}

	public void setApertura(float apertura) {
		this.apertura = apertura;
	}

	public float getLongitudFocal() {
		return longitudFocal;
	}

	public void setLongitudFocal(float longitudFocal) {
		this.longitudFocal = longitudFocal;
	}

	public float getCampoVision() {
		return campoVision;
	}

	public void setCampoVision(float campoVision) {
		this.campoVision = campoVision;
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
	
	public String getEstadoEquipamiento() {
		return estadoEquipamiento;
	}

	public void setEstadoEquipamiento(String estadoEquipamiento) {
		this.estadoEquipamiento = estadoEquipamiento;
	}
	
	
	
}
