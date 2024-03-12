package observatorio.domain;

import java.sql.Date;


public class Proyecto {
    
	private String id;
    private Date fechaIni;
    private Date fechaFin;
    private String estadoProyecto;
    private Date fechaFinEstimada;
    private String descripcion;
    
    public Proyecto(String id, Date fechaIni, Date fechaFin, String estadoProyecto, Date fechaFinEstimada,
			String descripcion) {
		super();
		this.id = id;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.estadoProyecto = estadoProyecto;
		this.fechaFinEstimada = fechaFinEstimada;
		this.descripcion = descripcion;
	}
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getEstadoProyecto() {
		return estadoProyecto;
	}
	public void setEstadoProyecto(String estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}
	public Date getFechaFinEstimada() {
		return fechaFinEstimada;
	}
	public void setFechaFinEstimada(Date fechaFinEstimada) {
		this.fechaFinEstimada = fechaFinEstimada;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    
}
