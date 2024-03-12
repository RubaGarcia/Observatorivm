package observatorio.domain;

import java.sql.Date;

public class Persona {

	private String id;
	private String nif;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaNacimiento;
	private Date fechaRegistro;
	private String estadoPersonal = null;
	private Date fechaInicio = null;
	private Date fechaFin = null;
	
	public Persona(String id, String nif, String nombre, String apellido1, String apellido2, Date fechaNacimiento,
			Date fechaRegistro) {
		super();
		this.id = id;
		this.nif = nif;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
	}

	public String id() {
		return id;
	}

	public String nif() {
		return nif;
	}

	public String nombre() {
		return nombre;
	}

	public String apellido1() {
		return apellido1;
	}

	public String apellido2() {
		return apellido2;
	}

	public Date fechaNacimiento() {
		return fechaNacimiento;
	}

	public Date fechaRegistro() {
		return fechaRegistro;
	}
	
	public void anhadeEstado(String estado, Date fechaInicio, Date fechaFin) {
		this.estadoPersonal = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public String estadoPersonal() {
		return estadoPersonal;
	}

	public Date fechaInicio() {
		return fechaInicio;
	}

	public Date fechaFin() {
		return fechaFin;
	}

}
