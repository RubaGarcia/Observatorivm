package observatorio.domain;

import java.sql.Date;

public class ProyectoPersona {
	private String idPersona;
	private String idProyecto;
	private Date fechaInicio;
	private Date fechaFin;
	
	public ProyectoPersona(String idPersona, String idProyecto, Date fechaInicio, Date fechaFin) {
		super();
		this.idPersona = idPersona;
		this.idProyecto = idProyecto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	
	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	
	
}
