package observatorio.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Observacion {

	private String id;
	private String persona;
	private String objeto;
	private String equipamiento;
	private BigDecimal ar;
	private BigDecimal dec;
	private Date fechaObservacion;
	
	
	
	public Observacion(String id, String persona, String objeto, String equipamiento, BigDecimal ar, 
			BigDecimal dec, Date fechaObservacion) {
		super();
		this.id = id;
		this.persona = persona;
		this.objeto = objeto;
		this.equipamiento = equipamiento;
		this.ar = ar;
		this.dec = dec;
		this.fechaObservacion = fechaObservacion;
	}

	public String id() {
		return id;
	}
	
	public String persona() {
		return persona;
	}

	public String objeto() {
		return objeto;
	}
	
	public String equipamiento() {
		return equipamiento;
	}
	
	public BigDecimal ar() {
		return ar;
	}
	
	public BigDecimal dec() {
		return dec;
	}
	
	public Date fechaObservacion() {
		return fechaObservacion;
	}
	
}
