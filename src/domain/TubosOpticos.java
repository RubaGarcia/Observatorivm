package observatorio.domain;

public class TubosOpticos {

	private String id;
	private float apertura;
	private float longitudFocal;
	private String tipoTuboOptico;
	private String marca;
	private String modelo;
	private String estadoEquipamiento;
	
	// Constructor
	public TubosOpticos(String id, float apertura, float longitudFocal, String tipoTuboOptico, String marca, String modelo,
			String estadoEquipamiento) {
		super();
		this.id = id;
		this.apertura = apertura;
		this.longitudFocal = longitudFocal;
		this.tipoTuboOptico = tipoTuboOptico;
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

	public String getTipoTuboOptico() {
		return tipoTuboOptico;
	}

	public void setTipoTuboOptico(String tipoTuboOptico) {
		this.tipoTuboOptico = tipoTuboOptico;
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
