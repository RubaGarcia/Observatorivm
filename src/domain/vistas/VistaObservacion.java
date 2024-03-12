package observatorio.domain.vistas;

import java.math.BigDecimal;
import java.sql.Date;

public class VistaObservacion {

	private String nif;
	private String objeto;
	private String equipamiento;
	private BigDecimal ar;
	private BigDecimal dec;
	private Date fechaObservacion;
	
	public VistaObservacion(String nif, String objeto, String equipamiento, BigDecimal ar, BigDecimal dec,
			Date fechaObservacion) {
		super();
		this.nif = nif;
		this.objeto = objeto;
		this.equipamiento = equipamiento;
		this.ar = ar;
		this.dec = dec;
		this.fechaObservacion = fechaObservacion;
	}
	
	public String nif() {
		return nif;
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
