package observatorio.business;

import java.util.List;

import observatorio.domain.ConsultaInventario;
import observatorio.domain.Equipamiento;
import observatorio.domain.Montura;
import observatorio.domain.Oculares;
import observatorio.domain.TubosOpticos;
import observatorio.persistenceLayer.InventarioDataMapper;

public class InventarioBusiness {

	/** m�todo de la capa de negocio que a�ade una montura al inventario
	 * @param id id de la montura
	 * @param marca marca de la montura
	 * @param modelo modelo de la montura
	 * @param tipoMontura tipo de la montura
	 * @param estadoEquipamiento estado en el que se encuentra
	 * @param motorizada true si est� motorizada, false en caso contrario
	 * @return true si se ha a�adido, false si ha habido algun error
	 */
	public boolean anhadeMontura(String id, String marca, String modelo, String tipoMontura, String estadoEquipamiento, boolean motorizada) {
		Montura montura = new Montura(id, marca, modelo, tipoMontura, estadoEquipamiento, motorizada);
		return new InventarioDataMapper().anhadeMontura(montura);
	}
	
	/** m�todo de la capa de negocio que a�ade un tubo �ptico al inventario
	 * @param id id del tubo
	 * @param apertura apertua del tubo
	 * @param longitudFocal longitud focal del tubo
	 * @param tipoTuboOptico tipo de tubo
	 * @param marca marca del tubo
	 * @param modelo modelo del tubo
	 * @param estadoEquipamiento estado en el que se encuentra
	 * @return true si se ha a�adido, false si ha habido algun error
	 */
	public boolean anhadeTubosOpticos(String id, float apertura, float longitudFocal, String tipoTuboOptico, String marca, String modelo,
			String estadoEquipamiento) {
		TubosOpticos tubo = new TubosOpticos(id, apertura, longitudFocal, tipoTuboOptico, marca, modelo, estadoEquipamiento);
		return new InventarioDataMapper().anhadeTubosOpticos(tubo);
	}
	
	/** m�todo de la capa de negocio que a�ade unos nuevos oculares al inventario
	 * @param id id de los oculares
	 * @param apertura apertua de los oculares
	 * @param longitudFocal longitud focal de los oculares
	 * @param campoVision campo de vision de los oculares
	 * @param marca marca de los oculares
	 * @param modelo modelo de los oculares
	 * @param estadoEquipamiento estado en el que se encuentra
	 * @return true si se ha a�adido, false si ha habido algun error
	 */
	public boolean anhadeOculares(String id, float apertura, float longitudFocal, float campoVision, String marca, String modelo,
			String estadoEquipamiento) {
		Oculares ocular = new Oculares(id, apertura, longitudFocal, campoVision, marca, modelo, estadoEquipamiento);
		return new InventarioDataMapper().anhadeOculares(ocular);
	}
	
	
	/** m�todo de la capa de negocio que a�ade un nuevo set de equipamiento
	 * @param id id del equipamiento
	 * @param idTubo id del tubo del equipo
	 * @param idOcular id del ocular del equipo
	 * @param idMontura id de la montura del equipo
	 * @return true si se ha a�adido, false si ha habido algun error
	 */
	public boolean anhadeEquipamiento(String id, String idTubo, String idOcular, String idMontura) {
		Equipamiento equi = new Equipamiento(id, idTubo, idOcular, idMontura);
		return new InventarioDataMapper().anhadeEquipamiento(equi);
	}
	
	
	/** m�todo de la capa de negocio que a�ade un nuevo tipo de tubo
	 * @param nombre nombre del tipo de tubo
	 * @return true si se ha a�adido, false si ha habido algun error
	 */
	public boolean anhadeTipoTubo(String id, String nombre) {
		return new InventarioDataMapper().anhadeTipoTubo(id, nombre);
	}
	
	
	/** m�todo de la capa de negocio que a�ade un nuevo tipo de montura
	 * @param nombre nombre del tipo de montura
	 * @return true si se ha a�adido, false si ha habido algun error
	 */
	public boolean anhadeTipoMontura(String id, String nombre) {
		return new InventarioDataMapper().anhadeTipoMontura(id, nombre);
	}
	
	/** m�todo de la capa de negocio que descataloga una montura
	 * @param montura id de la montura
	 * @return true si se ha eliminado, false si hay error
	 */
	public boolean descatalogaMontura(String montura) {
		return new InventarioDataMapper().descatalogaMontura(montura);
	}
	
	/** m�todo de la capa de negocio que descataloga un tubo
	 * @param tubo id del tubo
	 * @return true si se ha eliminado, false si hay error
	 */
	public boolean descatalogaTubo(String tubo) {
		return new InventarioDataMapper().descatalogaTubo(tubo);
	}
	
	/** m�todo de la capa de negocio que descataloga un ocular
	 * @param tubo id del ocular
	 * @return true si se ha eliminado, false si hay error
	 */
	public boolean descatalogaOcular(String ocular) {
		return new InventarioDataMapper().descatalogaOcular(ocular);
	}
	
	/** m�todo de la capa de negocio que anhade un estado a la lista de estados
	 * @param id del estado
	 * @param nombre nombre del estado
	 * @return true si ha funcionado, false si hay error
	 */
	public boolean anhadeEstadoEquipamimento(String id, String nombre) {
		return new InventarioDataMapper().anhadeEstadoEquipamimento(id, nombre);
	}
	
	/** m�todo de la capa de negocio que hace una consulta de todos los objetos del inventario
	 * @return consulta
	 */
	public List<ConsultaInventario> consultaInventario() {
		return new InventarioDataMapper().consultaInventario();
	}
	
	/** m�todo de la capa de negocio que actualiza el estado de un equipamiento
	 * @param id del equipamiento
	 * @param nombre nombre del estado
	 * @return true si ha funcionado, false si hay error
	 */
	public boolean actualizaEstadoEquipamimento(String id, String nombre) {
		return new InventarioDataMapper().actualizaEstadoEquipamimento(id, nombre);
	}

}
