package observatorio.domain;

public class DesglosePresupuesto {
	private String idProyecto;
	private float cantidad;
	private String descripion;
	private String numeroDesglose;
	
	public DesglosePresupuesto(String idProyecto, float cantidad, String descripion, String numeroDesglose) {
		super();
		this.idProyecto = idProyecto;
		this.cantidad = cantidad;
		this.descripion = descripion;
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

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public String getNumeroDesglose() {
		return numeroDesglose;
	}

	public void setNumeroDesglose(String numeroDesglose) {
		this.numeroDesglose = numeroDesglose;
	}
	
	
	
}
