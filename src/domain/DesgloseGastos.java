package observatorio.domain;

public class DesgloseGastos {
	
	private String idProyecto;
	private float cantidad;
	private String descripcion;
	private String numeroDesglose;
	
	public DesgloseGastos(String idProyecto, float cantidad, String descripcion, String numeroDesglose) {
		super();
		this.idProyecto = idProyecto;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.numeroDesglose = numeroDesglose;
	}
	
	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumeroDesglose() {
		return numeroDesglose;
	}

	public void setNumeroDesglose(String numeroDesglose) {
		this.numeroDesglose = numeroDesglose;
	}

	
	
	
}
