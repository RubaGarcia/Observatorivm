package observatorio.business;

//Importamos el modelo de dominio del objeto y el data mapper
import observatorio.persistenceLayer.ObjetoDataMapper;

import observatorio.domain.Objeto;
import java.util.List;

/**
 * Clase con las operaciones de negocio del objeto.
 * Es con esta clase con la que la interfaz grafica (capa de presentacion)
 * se comunica.
 * 
 * @author Grupo E
 * @lastmodified 
 *
 */
public class ObjetoBusiness {
	
	/**
	 * Metodo que inserta a un nuevo objeto astronomico en la base de datos 
	 * @param idObjeto
	 * @param tamanho
	 * @param magnitud
	 * @param ar
	 * @param dec
	 * @param nombre
	 * @param descripcion
	 * @param constelacion
	 * @param tipo 
	 * @return
	 */
	public boolean newObjeto(String idObjeto, double ar, double dec, String descripcion, 
			String tipo, String constelacion, String nombre, double tamanho, double magnitud) {
		
		Objeto o = new Objeto(idObjeto, tamanho, magnitud, ar,
				dec, nombre, descripcion, constelacion, tipo);
		return new ObjetoDataMapper().insertObjeto(o);
	}
	
	/**
	 * Metodo que retorna objetos cercanos a un punto del cielo.
	 * @param coordenadaAR ascension recta del punto donde realizar la identificacion
	 * @param coordenadaDEC declinacion del punto donde realizar la identificacion
	 * @return
	 */
	public String identificaObjeto(String coordenadaAR, String coordenadaDEC) {
		
		return (new ObjetoDataMapper().identificaObjeto(coordenadaAR, coordenadaDEC));
	}
	
	/**
	 * Metodo que retorna los objetos visibles en una constelacion.
	 * @param idContelacion el id de la constelacion sobre la que se quiere realizar la consulta
	 * @return
	 */
	public List<Objeto> infoConstelacion(String idConstelacion) {
		
		return (new ObjetoDataMapper().infoConstelacion(idConstelacion));
	}
	
}
