package observatorio.business;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import observatorio.domain.Observacion;
import observatorio.domain.vistas.VistaObservacion;
import observatorio.persistenceLayer.ObservacionesDataMapper;

public class ObservacionesBusiness {

	/** m�todo de la capa de negocio que llama al de la capa de persistencia
	 * @param persona persona o null de la que se quieren obtener las observaciones
	 * @return lista de objetos de tipo vista observacion
	 */
	public List<VistaObservacion> selectObservaciones(String persona) {
		return new ObservacionesDataMapper().selectObservaciones(persona);
	}
	
	/** m�todo que a�ade la observacion que se le pasa por parametro con los argumentos
	 * @param id id de la observacion
	 * @param persona id de la persona que realiza la observacion
	 * @param objeto id del objeto observado
	 * @param equipamiento id del equipamiento con el que se ha observado
	 * @param ar coordenadas ar en las que se observa el objeto
	 * @param dec coordenadas dec en las que se observa el objeto
	 * @param fechaObservacion fecha de la observacion
	 * @return true si se ha podido realizar, false en otro caso
	 */
	public boolean anhadeObservacion(String id, String persona, String objeto, String equipamiento, 
			BigDecimal ar, BigDecimal dec, Date fechaObservacion) {
		Observacion obs = new Observacion(id, persona, objeto, equipamiento, ar, dec, fechaObservacion);
		return new ObservacionesDataMapper().anhadeObservacion(obs);
	}
}
